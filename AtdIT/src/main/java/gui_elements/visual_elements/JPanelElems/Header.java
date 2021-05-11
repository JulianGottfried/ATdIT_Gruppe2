package main.java.gui_elements.visual_elements.JPanelElems;

import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.InsetsUIResource;

import main.java.ScreenHandler;
import main.java.exceptions.InterruptDrawException;
import main.java.gui_elements.functional_elements.ViewSwitcher;
import main.java.gui_elements.visual_elements.JLabelElems.ImageDisplay;
import main.java.gui_elements.visual_elements.JOptionPaneElems.ErrorPopUp;
import main.java.handler.ColorHandler;
import main.java.handler.I18nHandler;
import main.java.screen.views.AddressView;
import main.java.screen.views.ContactView;
import main.java.screen.views.CurrentEventsView;
import main.java.screen.views.HomeScreenView;
import main.java.screen.views.TokenInspectorView;
import main.resources.utilities.Fonts;
import main.resources.utilities.Images;

public class Header extends AbstractJPanel{
    GridBagConstraints gbc;
    ScreenHandler screenHandler;
    String colorTemplate;
    Locale language;
    String bundleName;
    I18nHandler i18n;

    public Header(ScreenHandler screenHandler, Locale language, String colorTemplate) {
    	super(colorTemplate);
    	this.colorTemplate = colorTemplate;
        this.screenHandler = screenHandler;
        this.language = language;
        this.bundleName = this.getClass().getSimpleName();
        this.setI18n();
        this.setLayout(new GridBagLayout());

        ImageDisplay logo = new ImageDisplay(Images.getLogo(), -1, 100, new Return2Home());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(logo, gbc);

        MenuBar header = new MenuBar(this.colorTemplate);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new InsetsUIResource(0, 100, 0, 100);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(header, gbc);

        LangButtons langButtons = new LangButtons(this.colorTemplate);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.1;
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(langButtons, gbc);
    }

    public class Return2Home extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            screenHandler.changeView(new HomeScreenView(screenHandler, language, colorTemplate));
        }
    }

    public void setI18n() {
        try {
            this.i18n = new I18nHandler(this.bundleName, this.language, this.screenHandler);
        } catch (InterruptDrawException e) {
            new ErrorPopUp(screenHandler.getCurrentView(), i18n.getString("errorMessage"), i18n.getString("errorTitle"));
            screenHandler.changeView(screenHandler.getPreviousView());
        }
    }

    class MenuBar extends AbstractJPanel {
        public MenuBar(String colorTemplate) {
        	super(colorTemplate);
            this.setLayout(new GridBagLayout());

            // TODO Class with key exception handler for i18n
            // TODO Class with image exception handler for image loads
            JButton latestButton = new JButton();
            latestButton.setText(i18n.getString("latest"));
            latestButton.addActionListener(new ViewSwitcher(screenHandler, new CurrentEventsView(screenHandler, language, colorTemplate)));
            latestButton.setBackground(colorHandler.getColor("menuButton1"));
            latestButton.setFont(Fonts.getButton());
            latestButton.setForeground(colorHandler.getColor("menuButtonText"));

            JButton addressButton = new JButton();
            addressButton.setText(i18n.getString("changeAddress"));
            addressButton.addActionListener(new ViewSwitcher(screenHandler, new AddressView(screenHandler, language, colorTemplate)));
            addressButton.setBackground(colorHandler.getColor("menuButton2"));
            addressButton.setFont(Fonts.getButton());
            addressButton.setForeground(colorHandler.getColor("menuButtonText"));

            JButton contactButton = new JButton();
            contactButton.setText(i18n.getString("contact"));
            contactButton.addActionListener(new ViewSwitcher(screenHandler, new ContactView(screenHandler, language, colorTemplate)));
            contactButton.setBackground(colorHandler.getColor("menuButton3"));
            contactButton.setFont(Fonts.getButton());
            contactButton.setForeground(colorHandler.getColor("menuButtonText"));

            JButton processButton = new JButton();
            processButton.setText(i18n.getString("processesing"));
            processButton.addActionListener(new ViewSwitcher(screenHandler, new TokenInspectorView(screenHandler, language, colorTemplate)));
            processButton.setBackground(colorHandler.getColor("menuButton4"));
            processButton.setFont(Fonts.getButton());
            processButton.setForeground(colorHandler.getColor("menuButtonText"));

            gbc = new GridBagConstraints();
            gbc.insets = new InsetsUIResource(0, 50, 0, 50);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1.0;

            gbc.gridx = 0;
            this.add(latestButton, gbc);

            gbc.gridx = 1;
            this.add(addressButton, gbc);

            gbc.gridx = 2;
            this.add(contactButton, gbc);

            gbc.gridx = 3;
            this.add(processButton, gbc);
        }
    }

    class LangButtons extends AbstractJPanel {

        public LangButtons(String colorTemplate) {
        	super(colorTemplate);
            JButton german = new JButton();
            JButton english = new JButton();

            german.setContentAreaFilled(false);
            english.setContentAreaFilled(false);

            german.addActionListener(new ChangeLanguage(new Locale("de", "DE")));
            english.addActionListener(new ChangeLanguage(new Locale("en", "US")));

            Image germanImage = Images.getGerman();
            Image scaledGermanImage = germanImage.getScaledInstance(50, -1, Image.SCALE_SMOOTH);
            ImageIcon germanIcon = new ImageIcon(scaledGermanImage);
            german.setIcon(germanIcon);

            Image englishImage = Images.getEnglish();
            Image newEnglishImage = englishImage.getScaledInstance(50, -1, Image.SCALE_SMOOTH);
            ImageIcon englishIcon = new ImageIcon(newEnglishImage);
            english.setIcon(englishIcon);

            this.setLayout(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.insets = new InsetsUIResource(0, 0, 5, 0);
            this.add(german, gbc);

            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1.0;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.insets = new InsetsUIResource(5, 0, 0, 0);
            this.add(english, gbc);
        }
    }

    class ChangeLanguage implements ActionListener {
        Locale language;

        public ChangeLanguage(Locale language) {
            this.language = language;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            screenHandler.changeCurrentViewLanguage(language);
        }
    }
}
