package main.java.view.guiElements.JPanelElems;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.controller.exceptions.DBSavingException;
import main.java.controller.exceptions.InterruptDrawException;
import main.java.controller.handler.JSONHandler;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.I18nHandler;
import main.java.controller.listener.ActionListener.GetPreviousQuestion;
import main.java.controller.listener.ActionListener.SaveQuestionToModel;
import main.java.model.ChangeOfAddress;
import main.java.model.ModelFactory;
import main.java.view.guiElements.AnswerInterface;
import main.java.view.guiElements.JButtonElems.FancyButton;
import main.java.view.guiElements.JOptionPaneElems.ErrorPopUp;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;
import main.java.view.guiElements.JTextFieldElems.InputAnswer;
import main.java.view.screen.views.ChangeOfAddressShowToken;

public class QALabel extends AbstractJPanel {
	private ScreenHandler screenHandler;
	private QuestionLabel qPanel;
	private AnswerLabel aPanel;
	private ProgressBar progressBar;
	private String language;
	private JSONHandler jsonHandler;
	private JSONObject baseModel;
	private JSONObject wholeJSON;
	private JSONObject questionsObj;
	private int questionCount;
	private JSONObject currentQuestion;
	private AnswerInterface currentAnswerLabel;
	private I18nHandler i18n;

	public QALabel(ScreenHandler screenHandler, Dimension dimensions, String questionFile, ProgressBar progressBar) {
		this(screenHandler, dimensions, questionFile);
		this.progressBar = progressBar;
		this.progressBar.setBoxes(this.questionCount);
	}

	public QALabel(ScreenHandler screenHandler, Dimension dimensions, String questionFile) {
		super(screenHandler);
		this.setI18n(screenHandler);
		this.screenHandler = screenHandler;
		this.language = screenHandler.getLanguage().getLanguage();
		this.setPreferredSize(dimensions);
		this.setMinimumSize(dimensions);
		this.setLayout(new GridBagLayout());
		this.setBackground(this.colorHandler.getColor("menuButton2"));

		this.jsonHandler = new JSONHandler();

		this.wholeJSON = jsonHandler.getBaseJSON(questionFile);
		this.questionsObj = jsonHandler.getJSON(this.wholeJSON, "questions");
		String initialKey = jsonHandler.getString(this.wholeJSON, "initial");
		this.baseModel = jsonHandler.getBaseModel(this.wholeJSON);
		this.questionCount = jsonHandler.getInt(this.wholeJSON, "questionCount");
		this.currentQuestion = jsonHandler.getJSON(this.questionsObj, initialKey);

		this.qPanel = new QuestionLabel(screenHandler);
		this.aPanel = new AnswerLabel(screenHandler);

		FancyButton next = new FancyButton(screenHandler, "menuButton2", "bigMenuButton");
		next.setForeground(colorHandler.getColor("bigMenuButtonFG"));
		next.setBackground(colorHandler.getColor("bigMenuButtonBG"));
		next.setText(i18n.getString("nextButton"));
		next.addActionListener(new SaveQuestionToModel(this, this.jsonHandler));

		FancyButton previous = new FancyButton(screenHandler, "menuButton2", "bigMenuButton");
		previous.setForeground(colorHandler.getColor("bigMenuButtonFG"));
		previous.setBackground(colorHandler.getColor("bigMenuButtonBG"));
		previous.setText(i18n.getString("previousButton"));
		previous.addActionListener(new GetPreviousQuestion(this, this.jsonHandler));

		this.showQuestion(currentQuestion);

		GridBagConstraints gbc = new GridBagConstraints();
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

	public void showQuestion(JSONObject question) {
		this.setQuestion(question);
		this.setAnswerType(question);
	}

	public void setI18n(ScreenHandler screenHandler) {
		try {
			this.i18n = new I18nHandler(this.getClass().getSimpleName(), screenHandler.getLanguage(), screenHandler);
		} catch (InterruptDrawException e) {
			screenHandler.changeCurrentView(screenHandler.getPreviousView());
		}
	}

	public void updateProgrssBar(int answeredQuestions) {
		if (this.progressBar != null) {
			this.progressBar.emptyBar();
			for (int i = 0; i < answeredQuestions; i++) {
				this.progressBar.updateBox(i, true);
			}
		}
	}

	public void setQuestion(JSONObject question) {
		this.qPanel.setQuestion(jsonHandler.getString(question, this.language));
	}

	public void setAnswerType(JSONObject question) {
		this.aPanel.adjustAnswerType(question);
	}

	public void showAnswers() {
		ModelFactory mf = new ModelFactory();
		try {
			ChangeOfAddress coa = mf.saveChangeOfAddressToDB(mf.createChangeOfAddress(this.baseModel));
			screenHandler.changeCurrentView(new ChangeOfAddressShowToken(screenHandler, coa.getProcessID()));
		} catch (DBSavingException dbse) {
			new ErrorPopUp(screenHandler, dbse.getMessage(), i18n.getString("DBErrorTitle"));
		}

	}

	public void showErrorPopup(String message) {
		new ErrorPopUp(this.screenHandler, message, this.i18n.getString("answerError"));
	}

	public class QuestionLabel extends AbstractJPanel {
		ScreenHandler screenHandler;

		public QuestionLabel(ScreenHandler screenHandler) {
			super(screenHandler);
			this.screenHandler = screenHandler;
			this.setLayout(new GridBagLayout());
			this.setBackground(colorHandler.getColor("transparent"));
		}

		public void setQuestion(String question) {
			this.removeAll();
			FancyTextArea questionArea = new FancyTextArea(this.screenHandler);
			questionArea.setText(question);
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.insets = new Insets(15, 25, 15, 25);
			this.add(questionArea, gbc);
			this.revalidate();
			this.repaint();
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
			String answerType = jsonHandler.getString(question, "type");

			this.removeAll();

			switch (answerType.toLowerCase()) {
			case "input":
				updateAnswerLabel(new InputAnswer(screenHandler));
				break;
			case "date":
				updateAnswerLabel(new DateAnswer(screenHandler));
				break;
			case "select":
				JSONArray options = jsonHandler.getJSONArray(question, "options", language);
				updateAnswerLabel(new SelectionAnswer(screenHandler, options, true));
				break;
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

	public JSONObject getBaseModel() {
		return baseModel;
	}

	public void setBaseModel(JSONObject baseModel) {
		this.baseModel = baseModel;
	}

	public JSONObject getQuestionsObj() {
		return questionsObj;
	}

	public void setQuestionsObj(JSONObject questionsObj) {
		this.questionsObj = questionsObj;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public ProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(ProgressBar progressBar) {
		this.progressBar = progressBar;
	}
}
