package main.java.view.screen.views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.plaf.InsetsUIResource;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.JPanelElems.BackgroundPanel;
import main.java.view.guiElements.JPanelElems.Header;
import main.java.view.guiElements.JPanelElems.ProgressBar;
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
			
			FancyTextArea title = new FancyTextArea(screenHandler, 1800, 100, fontHandler.getFont("h1"));
			title.setFont(fontHandler.getFont("h1Under"));
            title.setText(i18n.getString("title"));
            
            
            ProgressBar pb = new ProgressBar(screenHandler, "menuButton2", new Dimension(100, 400), 7);
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
//            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(50, 50, 50, 50);
            this.add(pb, gbc);
            
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
