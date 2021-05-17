package main.java.view.guiElements.JPanelElems;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import org.json.simple.JSONObject;

import main.java.controller.handler.ScreenHandler;
import main.java.questions.QuestionHandler;
import main.java.view.guiElements.JButtonElems.FancyButton;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;
import main.java.view.guiElements.JTextFieldElems.InputAnswer;

public class QALabel extends AbstractJPanel {
	private QuestionLabel qPanel;
	private AnswerLabel aPanel;
	private String language;
	private QuestionHandler qh;
	private JSONObject questionObj;
	private JSONObject currentQuestion;

	public QALabel(ScreenHandler screenHandler, Dimension dimensions, String questionFile) {
		super(screenHandler);
		this.language = screenHandler.getLanguage().getDisplayLanguage();
		this.qh = new QuestionHandler();
		this.questionObj = qh.getQuestion(questionFile);
		String initialKey = qh.getString(this.questionObj, "initial");
		this.currentQuestion = qh.getJSON(questionObj, initialKey);
		this.setPreferredSize(dimensions);
		this.setMinimumSize(dimensions);
		this.setLayout(new GridBagLayout());
		this.qPanel =  new QuestionLabel(screenHandler);
		this.aPanel =  new AnswerLabel(screenHandler);
		FancyButton confirm = new FancyButton(screenHandler, "menuButton2", "bigMenuButton");
        confirm.setForeground("bigMenuButtonFG");
		confirm.setText("Weiter");
		
		this.showQuestion(currentQuestion);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(qPanel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(50, 50, 50, 50);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(aPanel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(0, 50, 50, 50);
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		this.add(confirm, gbc);
	}
	
	public void showQuestion(JSONObject questionObj) {
		System.out.println(this.language);
		this.setQuestion(qh.getString(questionObj, this.language));
		this.setAnswerType(qh.getString(questionObj, "type"));
	}
	
	public void setQuestion(String question) {
		this.qPanel.setQuestion(question);
	}
	
	public void setAnswerType(String answerType) {
		this.aPanel.adjustAnswerType(answerType);
	}
	
	public class QuestionLabel extends AbstractJPanel {
		private FancyTextArea questionArea;
		
		public QuestionLabel(ScreenHandler screenHandler) {
			super(screenHandler);
			this.setLayout(new GridBagLayout());
			this.setBackground(Color.BLACK);
			this.questionArea = new FancyTextArea(screenHandler);
			this.questionArea.setBackground(Color.BLACK);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
			gbc.insets = new Insets(15, 25, 15, 25);
			this.add(this.questionArea, gbc);
		}
		
		public void setQuestion(String question) {
			this.questionArea.setText(question);
		}		
	}
	
	public class AnswerLabel extends AbstractJPanel {
		private ScreenHandler screenHandler;
		
		public AnswerLabel(ScreenHandler screenHandler) {
			super(screenHandler);
			this.screenHandler = screenHandler;
			this.setLayout(new GridBagLayout());
			this.setBackground(Color.BLACK);
		}
		
		public void adjustAnswerType(String answerType) {
			this.removeAll();
			
			switch(answerType.toLowerCase()) {
			case "input": updateAnswerLabel(new InputAnswer(screenHandler));
				break;
			case "date": updateAnswerLabel(new DateAnswer(screenHandler));
				break; 
			case "select": 
				String[] options = {"question 1", "question2", "q3", "q4"};
				updateAnswerLabel(new SelectionAnswer(screenHandler, options, true));
				break;
			default:
			}
		}
		
		public void updateAnswerLabel(Component answerLabel) {
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.insets = new Insets(20, 20, 20, 20);
			gbc.fill = GridBagConstraints.BOTH;
			this.removeAll();	
			this.add(answerLabel, gbc);
			this.revalidate();
			this.repaint();
		}
	}
}
