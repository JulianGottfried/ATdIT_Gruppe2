package main.java.view.guiElements.JPanelElems;

import java.util.Locale;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.plaf.InsetsUIResource;

import main.java.controller.exceptions.InterruptDrawException;
import main.java.view.guiElements.JButtonElems.FancyButton;
import main.java.view.guiElements.JLabelElems.ImageDisplay;
import main.java.view.guiElements.JOptionPaneElems.ErrorPopUp;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.languageHandler.I18nHandler;
import main.java.controller.listener.ActionListener.ChangeLanguage;
import main.java.controller.listener.ActionListener.ViewSwitcher;
import main.java.controller.listener.mouseAdapter.Return2Home;
import main.java.view.screen.views.*;

public class Header extends AbstractJPanel{
    private GridBagConstraints gbc;
    private ScreenHandler screenHandler;
    private Locale language;
    private String bundleName;
    private I18nHandler i18n;

    public Header(ScreenHandler screenHandler) {
    	super(screenHandler);
        this.screenHandler = screenHandler;
        this.language = screenHandler.getLanguage();
        this.bundleName = this.getClass().getSimpleName();
        this.setI18n();
        this.setLayout(new GridBagLayout());

        ImageDisplay logo = new ImageDisplay(screenHandler, imageHandler.getImage("logo"), -1, 100, new Return2Home(screenHandler));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(logo, gbc);

        ButtonBar buttonBar = new ButtonBar(screenHandler);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new InsetsUIResource(0, 100, 0, 100);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(buttonBar, gbc);

        LangButtons langButtons = new LangButtons(screenHandler);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.1;
        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(langButtons, gbc);
    }

    public void setI18n() {
        try {
            this.i18n = new I18nHandler(this.bundleName, this.language, this.screenHandler);
        } catch (InterruptDrawException e) {
            new ErrorPopUp(this.screenHandler, i18n.getString("errorMessage"), i18n.getString("errorTitle"));
            this.screenHandler.changeCurrentView(this.screenHandler.getPreviousView());
        }
    }
    
    //TODO: ask if text should be fully outsourced or not 
    class ButtonBar extends AbstractJPanel {
    	
        public ButtonBar(ScreenHandler screenHandler) {
        	super(screenHandler);
            this.setLayout(new GridBagLayout());

            // TODO Class with key exception handler for i18n
            // TODO Class with image exception handler for image loads
            FancyButton latestButton = new FancyButton(screenHandler, "menuButton1");
            latestButton.setText(i18n.getString("latest"));
            latestButton.addActionListener(new ViewSwitcher(screenHandler, new CurrentEventsView(screenHandler)));

            FancyButton addressButton = new FancyButton(screenHandler, "menuButton2");
            addressButton.setText(i18n.getString("changeAddress"));
            addressButton.addActionListener(new ViewSwitcher(screenHandler, new ChangeOfAddressInitial(screenHandler)));

            FancyButton contactButton = new FancyButton(screenHandler, "menuButton3");
            contactButton.setText(i18n.getString("contact"));
            contactButton.addActionListener(new ViewSwitcher(screenHandler, new ContactView(screenHandler)));

            FancyButton processButton = new FancyButton(screenHandler, "menuButton4");
            processButton.setText(i18n.getString("processesing"));
            processButton.addActionListener(new ViewSwitcher(screenHandler, new TokenInspectorView(screenHandler)));

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

        public LangButtons(ScreenHandler screenHandler) {
        	super(screenHandler);
            FancyButton german = new FancyButton(screenHandler);
            FancyButton english = new FancyButton(screenHandler);

            german.setContentAreaFilled(false);
            english.setContentAreaFilled(false);

            german.addActionListener(new ChangeLanguage(screenHandler, new Locale("de", "DE")));
            english.addActionListener(new ChangeLanguage(screenHandler, new Locale("en", "US")));

            Image germanImage = imageHandler.getImage("german");
            Image scaledGermanImage = germanImage.getScaledInstance(50, -1, Image.SCALE_SMOOTH);
            ImageIcon germanIcon = new ImageIcon(scaledGermanImage);
            german.setIcon(germanIcon);

            Image englishImage = imageHandler.getImage("english");
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
}
