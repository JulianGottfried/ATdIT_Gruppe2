package main.java.controller.handler;

import java.util.Locale;
import java.util.ResourceBundle;

import main.java.controller.exceptions.InterruptDrawException;
import main.java.view.guiElements.JOptionPaneElems.ErrorPopUp;
import main.java.controller.handler.utilityHandler.InternalPathsHandler;

import java.util.MissingResourceException;

/**
 * I18nHandler is used for all language translation and internationalisation
 * processes and connects to the internal .properties file.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class I18nHandler {
	private ResourceBundle bundle;
	private Locale language;
	private ScreenHandler screenHandler;
	private ResourceBundle i18n;
	private static final String LINK2BUNDLES = new InternalPathsHandler().getProperty("i18n");

	public I18nHandler(String bundleName, Locale language, ScreenHandler screenHandler) throws InterruptDrawException {
		this.language = language;
		this.screenHandler = screenHandler;
		this.i18n = setOwnI18n();
		constructBundle(bundleName);
	}

	public void constructBundle(String bundleName) throws InterruptDrawException {
		try {
			this.bundle = ResourceBundle.getBundle(constructBundleLink(bundleName), language);
		} catch (MissingResourceException e) {
			throw new InterruptDrawException("");
		}
	}

	/**
	 * Generates the bundle Link
	 * 
	 * @param bundleName Name of the required bundle
	 * @return the bundle Link
	 */
	public static String constructBundleLink(String bundleName) {
		return LINK2BUNDLES + bundleName + "/" + bundleName;
	}

	public ResourceBundle setOwnI18n() {
		return ResourceBundle.getBundle(constructBundleLink("i18nHandler"), this.language);
	}

	public ResourceBundle getBundle() {
		return this.bundle;
	}

	public void setBundle(ResourceBundle newBundle) {
		this.bundle = newBundle;
	}

	public String getString(String key) {
		try {
			return bundle.getString(key);
		} catch (MissingResourceException e) {
			new ErrorPopUp(screenHandler, i18n.getString("keyErrorMessage") + " " + key,
					i18n.getString("keyErrorTitle"));
			return i18n.getString("missingKey");
		}
	}
}
