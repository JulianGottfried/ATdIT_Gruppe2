package main.java.view.guiElements.JPanelElems;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.json.simple.JSONArray;

import main.java.controller.exceptions.FaultyAnswerException;
import main.java.controller.exceptions.InterruptDrawException;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.I18nHandler;
import main.java.view.guiElements.AnswerInterface;
/**
 * Used to select the answer.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class SelectionAnswer extends AbstractJPanel implements AnswerInterface {
	private ButtonGroup bg;
	private I18nHandler i18n;
	
	public SelectionAnswer(ScreenHandler screenHandler, JSONArray options, boolean selectSingle) {
		super(screenHandler);
		this.setI18n(screenHandler);
		this.setLayout(new GridBagLayout());
		
		bg = new ButtonGroup();
		for (int i=0; i<options.size(); i++) {
			String buttonString = (String) options.get(i);
			JRadioButton jb = new JRadioButton(buttonString);
			jb.setActionCommand(buttonString);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = i%2;
			gbc.gridy = i/2;
			gbc.insets = new Insets(5, 5, 5, 5);
			gbc.anchor = GridBagConstraints.LINE_START;
			this.add(jb, gbc);
			if (selectSingle) {
				bg.add(jb);
			}
		}
	}
	
	public void setI18n(ScreenHandler screenHandler) {
		try {
			this.i18n = new I18nHandler(this.getClass().getSimpleName(), screenHandler.getLanguage(), screenHandler);
		} catch (InterruptDrawException e) {
            screenHandler.changeCurrentView(screenHandler.getPreviousView());
		}
	}

	public String getAnswer() throws FaultyAnswerException {
		try {
			return this.bg.getSelection().getActionCommand();
		} catch (NullPointerException npe) {
			throw new FaultyAnswerException(this.i18n.getString("errorMessage"));
		}
	}
}
