package main.java.display.screen.views;

import java.awt.GridBagConstraints;

import javax.swing.plaf.InsetsUIResource;

import main.java.display.guiElements.JPanelElems.BackgroundPanel;
import main.java.display.guiElements.JPanelElems.Header;
import main.java.display.guiElements.JTextAreaElems.TextArea;
import main.java.display.handler.ScreenHandler;

public class HomeScreenView extends AbstractView {

    public HomeScreenView(ScreenHandler screenHandler) {
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
            gbc = new GridBagConstraints();

            TextArea title = new TextArea(screenHandler, 0, 0, fontHandler.getFont("h1"));
            title.setText(i18n.getString("title").toUpperCase());

            TextArea text = new TextArea(screenHandler, 600, 600);
            text.setText(i18n.getString("welcome"));

            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.ipady = 5;
            gbc.insets = new InsetsUIResource(0, 10, 50, 10);
            this.add(title, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            this.add(text, gbc);
        }
    }
}
