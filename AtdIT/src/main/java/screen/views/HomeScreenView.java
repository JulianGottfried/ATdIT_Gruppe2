package main.java.screen.views;

import java.awt.GridBagConstraints;

import javax.swing.plaf.InsetsUIResource;

import main.java.ScreenHandler;
import main.java.gui_elements.visual_elements.JPanelElems.BackgroundPanel;
import main.java.gui_elements.visual_elements.JPanelElems.Header;
import main.java.gui_elements.visual_elements.JTextAreaElems.TextArea;
import main.resources.utilities.Fonts;

import java.util.Locale;

public class HomeScreenView extends AbstractView {

    public HomeScreenView(ScreenHandler screenHandler, Locale language, String colorTemplate) {
        super(screenHandler, language, colorTemplate);
    }

    @Override
    public void drawItems() {
        Header header = new Header(this.screenHandler, this.language, this.colorTemplate);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new InsetsUIResource(20, 0, 20, 0);
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(header, gbc);

        Body body = new Body();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(body, gbc);
    }

    class Body extends BackgroundPanel {

        public Body() {
            gbc = new GridBagConstraints();

            TextArea title = new TextArea(0, 0, Fonts.getH1(), colorTemplate);
            title.setText(i18n.getString("title").toUpperCase());

            TextArea text = new TextArea(600, 600, colorTemplate);
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
