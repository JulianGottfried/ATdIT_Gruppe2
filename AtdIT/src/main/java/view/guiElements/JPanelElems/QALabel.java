package main.java.view.guiElements.JPanelElems;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.controller.exceptions.InterruptDrawException;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.languageHandler.I18nHandler;
import main.java.controller.listener.ActionListener.SaveQuestionToModel;
import main.java.questions.QuestionHandler;
import main.java.view.guiElements.AnswerInterface;
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
	private AnswerInterface currentAnswerLabel;
	private I18nHandler i18n;

	public QALabel(ScreenHandler screenHandler, Dimension dimensions, String questionFile) {
		super(screenHandler);
		this.setI18n(screenHandler);
		this.language = screenHandler.getLanguage().getLanguage();
		this.setPreferredSize(dimensions);
		this.setMinimumSize(dimensions);
		this.setLayout(new GridBagLayout());
		this.setBackground(this.colorHandler.getColor("menuButton2"));
		
		this.qh = new QuestionHandler();
		this.questionObj = qh.getQuestionsFromJSON(questionFile);
		String initialKey = qh.getString(this.questionObj, "initial");
		this.currentQuestion = qh.getJSON(questionObj, initialKey);
		
		this.qPanel =  new QuestionLabel(screenHandler);
		this.aPanel =  new AnswerLabel(screenHandler);
		
		FancyButton next = new FancyButton(screenHandler, "menuButton2", "bigMenuButton");
		next.setForeground(colorHandler.getColor("bigMenuButtonFG"));
		next.setBackground(colorHandler.getColor("bigMenuButtonBG"));
		next.setText(i18n.getString("nextButton"));
		next.addActionListener(new SaveQuestionToModel(this, this.qh));
		FancyButton previous = new FancyButton(screenHandler, "menuButton2", "bigMenuButton");
		previous.setForeground(colorHandler.getColor("bigMenuButtonFG"));
		previous.setBackground(colorHandler.getColor("bigMenuButtonBG"));
		previous.setText(i18n.getString("previousButton"));
		previous.addActionListener(new SaveQuestionToModel(this, this.qh));
		
		this.showQuestion(currentQuestion);
		
		GridBagConstraints 
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(0, 50, 50, 20);
		gbc.anchor = GridBagConstraints.LAST_LINE_END;
		this.add(previous, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(qPanel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(50, 50, 50, 50);
		gbc.fill = GridBagConstraints.BOTH;
		this.add(aPanel, gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(0, 20, 50, 50);
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		this.add(next, gbc);	
	}
	
	public void setI18n(ScreenHandler screenHandler) {
		try {
			this.i18n = new I18nHandler(this.getClass().getSimpleName(), screenHandler.getLanguage(), screenHandler);
		} catch (InterruptDrawException e) {
            screenHandler.changeCurrentView(screenHandler.getPreviousView());
		}
	}
	
	public void showQuestion(JSONObject questionObj) {
		this.setQuestion(this.currentQuestion);
		this.setAnswerType(this.currentQuestion);
	}
	
	public void setQuestion(JSONObject question) {
		this.qPanel.setQuestion(qh.getString(question, this.language));
	}
	
	public void setAnswerType(JSONObject question) {
		this.aPanel.adjustAnswerType(question);
	}
	
	public class QuestionLabel extends AbstractJPanel {
		private FancyTextArea questionArea;
		
		public QuestionLabel(ScreenHandler screenHandler) {
			super(screenHandler);
			this.setLayout(new GridBagLayout());
			this.setBackground(colorHandler.getColor("transparent"));
			this.questionArea = new FancyTextArea(screenHandler);
			
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.CENTER;
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
		}
		
		public void adjustAnswerType(JSONObject question) {
			String answerType = qh.getString(question, "type");
			
			this.removeAll();
			
			switch(answerType.toLowerCase()) {
			case "input": 
				updateAnswerLabel(new InputAnswer(screenHandler));
				break;
			case "date": 
				updateAnswerLabel(new DateAnswer(screenHandler));
				break; 
			case "select": 
				JSONArray options = qh.getJSONArray(question, "options", language);
				updateAnswerLabel(new SelectionAnswer(screenHandler, options, true));
				break;
			default:
			}
		}
		
		public void updateAnswerLabel(AnswerInterface answerLabel) {
			currentAnswerLabel = answerLabel;
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.insets = new Insets(20, 20, 20, 20);
			gbc.fill = GridBagConstraints.BOTH;
			this.removeAll();	
			this.add((Component) answerLabel, gbc);
			this.revalidate();
			this.repaint();
		}
	}

	public JSONObject getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(JSONObject currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public AnswerInterface getCurrentAnswerLabel() {
		return currentAnswerLabel;
	}

	public void setCurrentAnswerLabel(AnswerInterface currentAnswerLabel) {
		this.currentAnswerLabel = currentAnswerLabel;
	}
}
