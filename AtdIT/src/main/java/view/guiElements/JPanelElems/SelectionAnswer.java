package main.java.view.guiElements.JPanelElems;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

import org.json.simple.JSONArray;

import main.java.controller.exceptions.FaltyAnswerException;
import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.AnswerInterface;

public class SelectionAnswer extends AbstractJPanel implements AnswerInterface {
	private ButtonGroup bg;
	
	public SelectionAnswer(ScreenHandler screenHandler, JSONArray options, boolean selectSingle) {
		super(screenHandler);
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

	public String getAnswer() throws FaltyAnswerException {
		try {
			return this.bg.getSelection().getActionCommand();
		} catch (NullPointerException npe) {
			throw new FaltyAnswerException("No button picked");
		}
	}
}
