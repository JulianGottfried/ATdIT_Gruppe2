package main.java.view.guiElements;

import java.util.Date;

import main.java.controller.exceptions.FaultyAnswerException;

/**
 * Answer interface for the user to input his answers during the COA process.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public interface AnswerInterface {
	public String getAnswer() throws FaultyAnswerException;
}
