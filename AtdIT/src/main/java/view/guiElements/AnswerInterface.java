package main.java.view.guiElements;

import java.util.Date;

import main.java.controller.exceptions.FaltyAnswerException;

public interface AnswerInterface {
	public String getAnswer() throws FaltyAnswerException;
}
