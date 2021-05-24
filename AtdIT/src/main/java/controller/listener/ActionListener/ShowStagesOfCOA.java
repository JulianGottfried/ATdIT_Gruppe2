package main.java.controller.listener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import main.java.controller.exceptions.FaultyAnswerException;
import main.java.controller.exceptions.InterruptDrawException;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.TypeHandler;
import main.java.controller.handler.I18nHandler;
import main.java.model.ModelFactory;
import main.java.model.StageOfCOA;
import main.java.view.guiElements.JPanelElems.KeyValueDisplay;
import main.java.view.guiElements.JTextFieldElems.InputAnswer;
import main.java.view.screen.views.TokenInspectorView;

/**
 * Shows the current state of the process.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class ShowStagesOfCOA implements ActionListener {
	ScreenHandler screenHandler;
	InputAnswer inputField;
	KeyValueDisplay keyValueDisplay;
	TokenInspectorView view;
	ModelFactory mf;
	I18nHandler i18n;

	public ShowStagesOfCOA(ScreenHandler screenHandler, InputAnswer inputField, KeyValueDisplay keyValueDisplay,
			TokenInspectorView view) {
		this.screenHandler = screenHandler;
		this.inputField = inputField;
		this.keyValueDisplay = keyValueDisplay;
		this.view = view;
		this.mf = new ModelFactory();
		setI18n(screenHandler);
	}

	/**
	 * sets the language to the users current language.
	 * 
	 * @param screenHandler the used screenHandler
	 */
	public void setI18n(ScreenHandler screenHandler) {
		try {
			this.i18n = new I18nHandler(this.getClass().getSimpleName(), screenHandler.getLanguage(), screenHandler);
		} catch (InterruptDrawException e) {
			screenHandler.changeCurrentView(screenHandler.getPreviousView());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String requestString;
		try {
			requestString = this.inputField.getAnswer();
			if (TypeHandler.isInt(requestString)) {
				int requestToken = Integer.parseInt(requestString);
				StageOfCOA model = mf.createStageOfCOA(requestToken);
				HashMap<String, Boolean> pairMap = new HashMap<>();
				pairMap.put(i18n.getString("received"), model.getReceived());
				pairMap.put(i18n.getString("processing"), model.getDataProcessing());
				pairMap.put(i18n.getString("meeting"), model.getReadyForMeeting());
				keyValueDisplay.showPairsBoolean(pairMap);
			} else {
				this.view.showErrorPopUp();
			}
		} catch (FaultyAnswerException fae) {
			this.view.showErrorPopUp();
		}

		view.revalidate();
		view.repaint();

	}

}
