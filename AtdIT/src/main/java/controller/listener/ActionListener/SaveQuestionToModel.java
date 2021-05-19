package main.java.controller.listener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;

import main.java.controller.exceptions.FaltyAnswerException;
import main.java.questions.QuestionHandler;
import main.java.view.guiElements.JPanelElems.QALabel;

public class SaveQuestionToModel implements ActionListener {
	private QALabel qaLabel;
	private QuestionHandler qh;
	private JSONObject currentQuestion;
	private String answer;
	
	public SaveQuestionToModel(QALabel qaLabel, QuestionHandler qh) {
		this.qaLabel = qaLabel;
		this.qh = qh;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			this.answer = qaLabel.getCurrentAnswerLabel().getAnswer();
			this.currentQuestion = qaLabel.getCurrentQuestion();
			this.saveAnswer();
			this.switchToNextAnswer();
		} catch (FaltyAnswerException fae) {
			// TODO: logger
		}
	}
	
	public void saveAnswer() {
		String saveLocation = qh.getString(this.currentQuestion, "model");
		qh.safeAnswerAt(qaLabel.getBaseModel(), this.answer, saveLocation);
	}
	
	public void switchToNextAnswer() {
		String nextKey;
		JSONObject cases = qh.getJSON(this.currentQuestion, "case");
		if (cases != null) {
			String possibleNextKey = qh.getString(cases, this.answer);
			if (possibleNextKey != null) {
				nextKey = possibleNextKey;
			} else {
				nextKey = qh.getString(this.currentQuestion, "next");
			}
		} else {
			nextKey = qh.getString(this.currentQuestion, "next");
		}
		JSONObject nextQuestion = qh.getJSON(qaLabel.getQuestionsObj(), nextKey);
		qaLabel.showQuestion(nextQuestion);
		qaLabel.setCurrentQuestion(nextQuestion);
	}
}
