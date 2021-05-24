package main.java.view.guiElements.JTextFieldElems;

import main.java.controller.exceptions.FaultyAnswerException;
import main.java.controller.exceptions.InterruptDrawException;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.I18nHandler;
import main.java.view.guiElements.AnswerInterface;
/**
 * Used to enter the answers in the UI.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class InputAnswer extends AbstractJTextField implements AnswerInterface {
	I18nHandler i18n;
	
	public InputAnswer(ScreenHandler screenHandler) {
		super(screenHandler);
		setI18n(screenHandler);
		this.setFont(fontHandler.getFont("inputQuestion"));
	}
	
	public void setI18n(ScreenHandler screenHandler) {
		try {
			this.i18n = new I18nHandler(this.getClass().getSimpleName(), screenHandler.getLanguage(), screenHandler);
		} catch (InterruptDrawException e) {
            screenHandler.changeCurrentView(screenHandler.getPreviousView());
		}
	}

	public String getAnswer() throws FaultyAnswerException {
		String text = this.getText().trim();
		if (!text.isEmpty()) {
			return text;
		} else {
			throw new FaultyAnswerException(i18n.getString("errorMessage"));
		}
	}

}
