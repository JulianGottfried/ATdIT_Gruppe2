package main.java.gui_elements.visual_elements;

import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.MouseAdapter;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.InsetsUIResource;

import main.java.ScreenHandler;
import main.java.gui_elements.functional_elements.ViewSwitcher;
import main.java.screen.views.AddressView;
import main.java.screen.views.ContactView;
import main.java.screen.views.CurrentView;
import main.java.screen.views.HomeScreenView;
import main.java.screen.views.TokenInspectorView;
import main.resources.utilities.Colors;
import main.resources.utilities.Fonts;
import main.resources.utilities.Images;

public class Header extends JPanel {
    GridBagConstraints gbc;
    ScreenHandler handler;
    Locale language;
    ResourceBundle i18n;

    public Header(ScreenHandler handler, Locale language) {
        this.handler = handler;
        this.language = language;
        this.i18n = ResourceBundle.getBundle("main/resources/i18n/Header/Header", language);
        this.setLayout(new GridBagLayout());
        this.setBackground(Colors.getBackground());

        ImageDisplay logo = new ImageDisplay(Images.getLogo(), -1, 100, new Return2Home());
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(logo, gbc);

        MenuBar header = new MenuBar();
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new InsetsUIResource(0, 100, 0, 100);
        gbc.weightx = 0.7;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(header, gbc);

        LangButtons langButtons = new LangButtons();
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
            handler.changeView(new HomeScreenView(handler, language));
        }
    }

    class MenuBar extends JPanel {
        public MenuBar() {
            this.setLayout(new GridBagLayout());
            this.setBackground(Colors.getBackground());

            // TODO Class with key exception handler for i18n
            // TODO Class with image exception handler for image loads
            JButton latestButton = new JButton();
            latestButton.setText(i18n.getString("latest"));
            latestButton.addActionListener(new ViewSwitcher(handler, new CurrentView(handler, language)));
            latestButton.setBackground(Colors.getMenuButton1());
            latestButton.setFont(Fonts.getButton());
            latestButton.setForeground(Colors.getMenuButtonText());

            JButton addressButton = new JButton();
            addressButton.setText(i18n.getString("changeAddress"));
            addressButton.addActionListener(new ViewSwitcher(handler, new AddressView(handler, language)));
            addressButton.setBackground(Colors.getMenuButton2());
            addressButton.setFont(Fonts.getButton());
            addressButton.setForeground(Colors.getMenuButtonText());

            JButton contactButton = new JButton();
            contactButton.setText(i18n.getString("contact"));
            contactButton.addActionListener(new ViewSwitcher(handler, new ContactView(handler, language)));
            contactButton.setBackground(Colors.getMenuButton3());
            contactButton.setFont(Fonts.getButton());
            contactButton.setForeground(Colors.getMenuButtonText());

            JButton processButton = new JButton();
            processButton.setText(i18n.getString("processesing"));
            processButton.addActionListener(new ViewSwitcher(handler, new TokenInspectorView(handler, language)));
            processButton.setBackground(Colors.getMenuButton4());
            processButton.setFont(Fonts.getButton());
            processButton.setForeground(Colors.getMenuButtonText());

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

    class LangButtons extends JLabel {

        public LangButtons() {
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
            handler.changeCurrentViewLanguage(language);
        }
    }
}
