package main.java.view.screen.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.plaf.InsetsUIResource;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.JPanelElems.BackgroundPanel;
import main.java.view.guiElements.JPanelElems.Header;
import main.java.view.guiElements.JPanelElems.ProgressBar;
import main.java.view.guiElements.JPanelElems.ProgressBarLabel;
import main.java.view.guiElements.JPanelElems.QALabel;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;

public class ChangeOfAddressQA extends AbstractView {
	

	protected ChangeOfAddressQA(ScreenHandler screenHandler) {
		super(screenHandler);
	}

	@Override
	public void drawItems() {
		Header header = new Header(this.screenHandler);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new InsetsUIResource(20, 0, 20, 0);
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(header, gbc);
        
        Body body = new Body(this.screenHandler);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(body, gbc);
	}
	
	class Body extends BackgroundPanel {

		public Body(ScreenHandler screenHandler) {
			super(screenHandler);
			
			FancyTextArea title = new FancyTextArea(screenHandler, 650, 100, fontHandler.getFont("h1"));
			title.setFont(fontHandler.getFont("h1Under"));
            title.setText(i18n.getString("title"));  
            
            ProgressBar progressBar = new ProgressBar(screenHandler, new Dimension(100, 400), "menuButton2", "progressBarBox", 14, 13, 2);
            ProgressBarLabel progBarLabel = new ProgressBarLabel(screenHandler, progressBar, "menuButton2", new Dimension(100, 400));
            
            FancyTextArea titleText = new FancyTextArea(screenHandler, fontHandler.getFont("progBarTitle"));
            titleText.setText("Frage 1/14");
            progBarLabel.setTitle(titleText);
            
            FancyTextArea upperText = new FancyTextArea(screenHandler, fontHandler.getFont("progBarUpper"));
            upperText.setText("Ende");
            progBarLabel.setUpperText(upperText);
            
            FancyTextArea lowerText = new FancyTextArea(screenHandler, fontHandler.getFont("progBarLower"));
            lowerText.setText("Start");
            progBarLabel.setLowerText(lowerText);
            
            QALabel qaLabel = new QALabel(screenHandler, new Dimension(800, 600), "ChangeOfAddressQuestions.json");
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(125, 150, 50, 50);
            this.add(progBarLabel, gbc);
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(125, 350, 50, 500);
            this.add(qaLabel, gbc);
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.FIRST_LINE_START;
            gbc.insets = new Insets(50, 50, 50, 50);
            this.add(title, gbc);
		}
	}
	
	
}
