package main.java.view.screen.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.plaf.InsetsUIResource;


import main.java.controller.handler.ScreenHandler;
import main.java.controller.listener.ActionListener.Return2Home;
import main.java.view.guiElements.JButtonElems.FancyButton;
import main.java.view.guiElements.JPanelElems.BackgroundPanel;
import main.java.view.guiElements.JPanelElems.Header;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;

public class ChangeOfAddressShowToken extends AbstractView {
	ScreenHandler screenHandler;
	int token;
	
	public ChangeOfAddressShowToken(ScreenHandler screenHandler, int token) {
		super(screenHandler);
		this.screenHandler = screenHandler;
		this.token = token;
	}

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
	
	public class Body extends BackgroundPanel {
		public Body(ScreenHandler screenHandler) {
			super(screenHandler);
			this.setLayout(new GridBagLayout());
			GridBagConstraints gbc;
			
			FancyTextArea textDisplay  = new FancyTextArea(screenHandler);
			textDisplay.setText(i18n.getString("text"));
			
			FancyTextArea tokenDisplay  = new FancyTextArea(screenHandler);
			tokenDisplay.setText(String.valueOf(token));
			
			FancyButton okButton = new FancyButton(screenHandler, "menuButton2");
			okButton.setText(i18n.getString("ok"));
			okButton.addActionListener(new Return2Home(screenHandler));
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.insets = new Insets(200, 800, 50, 800);
			gbc.fill = GridBagConstraints.BOTH;
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			this.add(textDisplay, gbc);
			
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.LINE_END;
			this.add(tokenDisplay, gbc);
			
			gbc = new GridBagConstraints();
			gbc.gridx = 1;
			gbc.gridy = 1;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			gbc.anchor = GridBagConstraints.LINE_START;
			this.add(okButton, gbc);
		}
	}
}
