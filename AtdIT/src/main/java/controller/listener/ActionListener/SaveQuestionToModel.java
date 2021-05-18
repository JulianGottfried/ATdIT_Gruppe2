package main.java.controller.listener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;

import main.java.questions.QuestionHandler;
import main.java.view.guiElements.JPanelElems.QALabel;

public class SaveQuestionToModel implements ActionListener {
	private QALabel qaLabel;
	private QuestionHandler qh;
	private JSONObject currQ;
	
	public SaveQuestionToModel(QALabel qaLabel, QuestionHandler qh) {
		this.qaLabel = qaLabel;
		this.qh = qh;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.currQ = qaLabel.getCurrentQuestion();
		String answer = this.getAnswer();
		this.saveAnswer();
	}
	
	public String getAnswer() {
		String answer = qaLabel.getCurrentAnswerLabel().getAnswer();
		System.out.println(answer);
		return answer;
	}
	
	public void saveAnswer() {
		String model = qh.getString(currQ, "model");
	}
}
