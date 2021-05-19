package main.java.controller.listener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;

import main.java.questions.QuestionHandler;
import main.java.view.guiElements.JPanelElems.QALabel;

public class GetPreviousQuestion implements ActionListener {
	private QALabel qaLabel;
	private QuestionHandler qh;
	
	public GetPreviousQuestion(QALabel qaLabel, QuestionHandler qh) {
		this.qaLabel = qaLabel;
		this.qh = qh;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JSONObject currObj = qaLabel.getCurrentQuestion();
		String previousKey = qh.getString(currObj, "previous");
		JSONObject previousQuestion = qh.getJSON(qaLabel.getQuestionsObj(), previousKey);
		qaLabel.showQuestion(previousQuestion);
		qaLabel.setCurrentQuestion(previousQuestion);
	}

}
