package main.java.view.screen.views;

import javax.swing.JLabel;
import javax.swing.plaf.InsetsUIResource;

import main.java.view.guiElements.JPanelElems.BackgroundPanel;
import main.java.view.guiElements.JPanelElems.Header;
import main.java.view.handler.ScreenHandler;

import java.awt.GridBagConstraints;

public class TokenInspectorView extends AbstractView {

    public TokenInspectorView(ScreenHandler screenHandler) {
        super(screenHandler);
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
            JLabel label = new JLabel(i18n.getString("message"));

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            this.add(label, gbc);
        }
    }
}
