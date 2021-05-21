package main.java.view.screen.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.plaf.InsetsUIResource;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.JLabelElems.ImageDisplay;
import main.java.view.guiElements.JPanelElems.BackgroundPanel;
import main.java.view.guiElements.JPanelElems.Header;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;

public class CurrentEventsView extends AbstractView {

    public CurrentEventsView(ScreenHandler screenHandler) {
        super(screenHandler);
    }

    @Override
    public void drawItems() {
    	Header header = new Header(this.screenHandler);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new InsetsUIResource(20, 0, 20, 0);
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(header, gbc);

        Body body = new Body(screenHandler);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(body, gbc);
    }
    
    public class Body extends BackgroundPanel {

		public Body(ScreenHandler screenHandler) {
			super(screenHandler);
			this.setLayout(new GridBagLayout());
			
			FancyTextArea title = new FancyTextArea(screenHandler, 500, 100, fontHandler.getFont("h1"));
			title.setText(i18n.getString("title"));
			
			JLabel corona = new JLabel();
			corona.setLayout(new GridBagLayout());
			
			ImageDisplay coronaImage = new ImageDisplay(screenHandler, imageHandler.getImage("vaccination"), 500, -1);
			FancyTextArea coronaText = new FancyTextArea(screenHandler);
			coronaText.setText(i18n.getString("corona"));
			
			JLabel library = new JLabel();
			library.setLayout(new GridBagLayout());
			
			ImageDisplay libraryImage = new ImageDisplay(screenHandler, imageHandler.getImage("library"), 500, -1);
			FancyTextArea libraryText = new FancyTextArea(screenHandler);
			libraryText.setText(i18n.getString("library"));
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.insets = new Insets(50, 50, 20, 20);
			gbc.anchor = GridBagConstraints.FIRST_LINE_START;
			this.add(title, gbc);
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.anchor = GridBagConstraints.PAGE_START;
			corona.add(coronaImage, gbc);
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.weightx = 1.0;
			gbc.anchor = GridBagConstraints.PAGE_START;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(20, 600, 20, 600);
			corona.add(coronaText, gbc);
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
			this.add(corona, gbc);
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.anchor = GridBagConstraints.PAGE_START;
			library.add(libraryImage, gbc);
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.weightx = 1.0;
			gbc.anchor = GridBagConstraints.PAGE_START;
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.insets = new Insets(20, 600, 20, 600);
			library.add(libraryText, gbc);
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 2;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.fill = GridBagConstraints.BOTH;
			this.add(library, gbc);
		}
    }
}
