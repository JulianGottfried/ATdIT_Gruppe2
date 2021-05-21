package main.java.view.guiElements;

import main.java.controller.exceptions.FaultyAnswerException;

public interface AnswerInterface {
	public String getAnswer() throws FaultyAnswerException;
}
