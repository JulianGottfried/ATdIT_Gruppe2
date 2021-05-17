package main.java.view.screen.views;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.plaf.InsetsUIResource;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.listener.ActionListener.ViewSwitcher;
import main.java.view.guiElements.JButtonElems.FancyButton;
import main.java.view.guiElements.JPanelElems.BackgroundPanel;
import main.java.view.guiElements.JPanelElems.Header;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;

public class ChangeOfAddressInitial extends AbstractView {

    public ChangeOfAddressInitial(ScreenHandler screenHandler) {
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
        
        Body body = new Body(screenHandler);
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
            title.setText(i18n.getString("title"));
            
            FancyTextArea text = new FancyTextArea(screenHandler, 1800, 600, new Insets(100, 100, 100, 100));
            text.setText(i18n.getString("text"));
            
            FancyButton startProcess = new FancyButton(screenHandler, "menuButton2", "bigMenuButton");
            startProcess.setForeground(colorHandler.getColor("bigMenuButtonFG"));
            startProcess.setText(i18n.getString("startButton"));
            startProcess.addActionListener(new ViewSwitcher(screenHandler, new ChangeOfAddressQA(screenHandler)));
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.anchor = GridBagConstraints.LAST_LINE_START;
            gbc.insets = new Insets(0, 110, 250, 0);
            this.add(startProcess, gbc); 
            
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.ipady = 5;
            gbc.insets = new Insets(30, 10, 50, 10);
            this.add(title, gbc);
            
            gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 1.0;
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.ipady = 5;
            gbc.insets = new Insets(30, 10, 50, 10);
            this.add(text, gbc);           
        }
    }

}
