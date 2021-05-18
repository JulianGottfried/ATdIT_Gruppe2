package main.java.view.guiElements.JTextFieldElems;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.AnswerInterface;

public class InputAnswer extends AbstractJTextField implements AnswerInterface {

	public InputAnswer(ScreenHandler screenHandler) {
		super(screenHandler);
		this.setFont(fontHandler.getFont("inputQuestion"));
	}

	@Override
	public String getAnswer() {
		return this.getText();
	}

}
