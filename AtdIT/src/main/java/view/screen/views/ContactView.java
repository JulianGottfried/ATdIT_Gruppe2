package main.java.view.screen.views;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.plaf.InsetsUIResource;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.JPanelElems.BackgroundPanel;
import main.java.view.guiElements.JPanelElems.Header;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;
import main.java.view.screen.views.ChangeOfAddressShowToken.Body;

public class ContactView extends AbstractView {

    public ContactView(ScreenHandler screenHandler) {
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
    
    public class Body extends BackgroundPanel {

		public Body(ScreenHandler screenHandler) {
			super(screenHandler);
			
			FancyTextArea contactText = new FancyTextArea(screenHandler);
	        contactText.setText(i18n.getString("ContactText"));
	        
	        gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy  = 0;
	        gbc.weightx = 1.0;
	        gbc.weighty = 1.0;
	        gbc.insets = new Insets(100, 100, 100, 100);
	        gbc.fill = GridBagConstraints.BOTH;
	        this.add(contactText, gbc);
		}
    }
}
