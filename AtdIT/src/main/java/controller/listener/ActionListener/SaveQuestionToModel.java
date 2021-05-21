package main.java.controller.listener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;

import main.java.controller.exceptions.FaultyAnswerException;
import main.java.controller.handler.JSONHandler;
import main.java.view.guiElements.JPanelElems.QALabel;

public class SaveQuestionToModel implements ActionListener {
	private QALabel qaLabel;
	private JSONHandler jsonHandler;
	private JSONObject currentQuestion;
	private String answer;
	
	public SaveQuestionToModel(QALabel qaLabel, JSONHandler jsonHandler) {
		this.qaLabel = qaLabel;
		this.jsonHandler = jsonHandler;
		this.currentQuestion = qaLabel.getCurrentQuestion();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.currentQuestion = qaLabel.getCurrentQuestion();
			this.answer = qaLabel.getCurrentAnswerLabel().getAnswer();
			this.saveAnswer(this.answer);
			this.switchToNextAnswer();
		} catch (FaultyAnswerException fae) {
			if (this.jsonHandler.getBoolean(this.currentQuestion, "allowedEmpty")) {
				this.answer = null;
				this.currentQuestion = qaLabel.getCurrentQuestion();
				this.saveAnswer(this.answer);
				this.switchToNextAnswer();
			}
			else {		
				qaLabel.showErrorPopup(fae.getMessage());
				// TODO: logger
			}
		}
	}
	
	public void saveAnswer(String answer) {
		String saveLocation = jsonHandler.getString(this.currentQuestion, "model");
		jsonHandler.safeAnswerAt(qaLabel.getBaseModel(), this.answer, saveLocation);
	}
	
	public void switchToNextAnswer() {
		String nextKey;
		JSONObject cases = jsonHandler.getJSON(this.currentQuestion, "case");
		if (cases != null) {
			String possibleNextKey = jsonHandler.getString(cases, this.answer);
			if (possibleNextKey != null) {
				nextKey = possibleNextKey;
			} else {
				nextKey = jsonHandler.getString(this.currentQuestion, "next");
			}
		} else {
			nextKey = jsonHandler.getString(this.currentQuestion, "next");
		}
		JSONObject nextQuestion = jsonHandler.getJSON(qaLabel.getQuestionsObj(), nextKey);
		if (nextQuestion != null) {
			qaLabel.showQuestion(nextQuestion);
			qaLabel.setCurrentQuestion(nextQuestion);
			int answeredQuestions = jsonHandler.getInt(nextQuestion, "number");
			qaLabel.updateProgrssBar(answeredQuestions);
		} else {
			qaLabel.showAnswers();
		}
	}
}
