package main.java.controller.listener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.json.simple.JSONObject;

import main.java.controller.handler.JSONHandler;
import main.java.view.guiElements.JPanelElems.QALabel;

/**
 * Gets back to an older question during the change of address process
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class GetPreviousQuestion implements ActionListener {
	private QALabel qaLabel;
	private JSONHandler jsonHandler;

	public GetPreviousQuestion(QALabel qaLabel, JSONHandler jsonHandler) {
		this.qaLabel = qaLabel;
		this.jsonHandler = jsonHandler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JSONObject currObj = qaLabel.getCurrentQuestion();
		String previousKey = jsonHandler.getString(currObj, "previous");
		if (previousKey != null) {
			JSONObject previousQuestion = jsonHandler.getJSON(qaLabel.getQuestionsObj(), previousKey);
			qaLabel.updateProgrssBar(jsonHandler.getInt(previousQuestion, "number"));
			qaLabel.showQuestion(previousQuestion);
			qaLabel.setCurrentQuestion(previousQuestion);
		}
	}

}
