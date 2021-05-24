package main.java.view.guiElements.JPanelElems;

import java.util.Locale;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.plaf.InsetsUIResource;

import main.java.controller.exceptions.InterruptDrawException;
import main.java.view.guiElements.JButtonElems.FancyButton;
import main.java.view.guiElements.JLabelElems.ImageDisplay;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.I18nHandler;
import main.java.controller.listener.ActionListener.ChangeLanguage;
import main.java.controller.listener.ActionListener.ViewSwitcher;
import main.java.controller.listener.mouseAdapter.Return2Home;
import main.java.view.screen.views.*;

/**
 * The header is the top part of the views. It is used as a navigation bar.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class Header extends AbstractJPanel {
	private GridBagConstraints gbc;
	private I18nHandler i18n;

	public Header(ScreenHandler screenHandler) {
		super(screenHandler);
		this.setI18n(screenHandler);
		this.setLayout(new GridBagLayout());

		ImageDisplay logo = new ImageDisplay(screenHandler, imageHandler.getImage("logo"), -1, 100,
				new Return2Home(screenHandler));
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

	public void setI18n(ScreenHandler screenHandler) {
		try {
			this.i18n = new I18nHandler(this.getClass().getSimpleName(), screenHandler.getLanguage(), screenHandler);
		} catch (InterruptDrawException e) {
			screenHandler.changeCurrentView(screenHandler.getPreviousView());
		}
	}

	/**
	 * The Buttons in the nav bar. Uses the fancyButtons.
	 * @author weilichsoheisse
	 * @version 22.05.2021
	 *
	 */
	class ButtonBar extends AbstractJPanel {

		public ButtonBar(ScreenHandler screenHandler) {
			super(screenHandler);
			this.setLayout(new GridBagLayout());
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
	/**
	 * The language buttons to switch to Germen or English.
	 * 
	 * @author weilichsoheisse
	 * @version 22.05.2021
	 *
	 */
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
