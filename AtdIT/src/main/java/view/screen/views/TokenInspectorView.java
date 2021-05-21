package main.java.view.screen.views;

import javax.swing.plaf.InsetsUIResource;

import main.java.view.guiElements.JButtonElems.FancyButton;
import main.java.view.guiElements.JOptionPaneElems.ErrorPopUp;
import main.java.view.guiElements.JPanelElems.BackgroundPanel;
import main.java.view.guiElements.JPanelElems.Header;
import main.java.view.guiElements.JPanelElems.KeyValueDisplay;
import main.java.view.guiElements.JTextFieldElems.InputAnswer;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.listener.ActionListener.ShowStagesOfCOA;

import java.awt.GridBagConstraints;

public class TokenInspectorView extends AbstractView {	
	
    public TokenInspectorView(ScreenHandler screenHandler) {
        super(screenHandler);
    }
    
    public void showErrorPopUp() {
    	new ErrorPopUp(this.screenHandler, i18n.getString("errorMessage"), i18n.getString("errorTitle"));
    }


    public void drawItems() {
        Header header = new Header(this.screenHandler);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new InsetsUIResource(20, 0, 20, 0);
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(header, gbc);

        Body body = new Body(screenHandler, this);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(body, gbc);
    }

    class Body extends BackgroundPanel {
        public Body(ScreenHandler screenHandler, TokenInspectorView parent) {
        	super(screenHandler);
        	InputAnswer inputField = new InputAnswer(screenHandler);
        	KeyValueDisplay tokenDisplay = new KeyValueDisplay(screenHandler);
        	FancyButton submit = new FancyButton(screenHandler, "menuButton4");
        	submit.setText(i18n.getString("submit"));
        	submit.addActionListener(new ShowStagesOfCOA(screenHandler, inputField, tokenDisplay, parent));

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new InsetsUIResource(20, 400, 20, 200);
            this.add(inputField, gbc);
            
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.insets = new InsetsUIResource(20, 200, 20, 400);
            this.add(submit, gbc);
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new InsetsUIResource(20, 400, 20, 400);
            this.add(tokenDisplay, gbc);
        }
    }
}
