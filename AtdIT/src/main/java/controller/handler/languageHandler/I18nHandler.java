package main.java.controller.handler.languageHandler;

import java.util.Locale;
import java.util.ResourceBundle;

import main.java.controller.exceptions.InterruptDrawException;
import main.java.view.guiElements.JOptionPaneElems.ErrorPopUp;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.InternalPathsHandler;

import java.util.MissingResourceException;

/**
 * This class is used for managing and switching the languages
 * 
 * @author weilichsoheisse
 * @version 16.05.2021
 *
 */

public class I18nHandler {
    private ResourceBundle bundle;
    private Locale language;
    private ScreenHandler screenHandler;
    private ResourceBundle i18n;
    private static final String LINK2BUNDLES = new InternalPathsHandler().getProperty("i18n");
    
    /**
     * Used to build and use language bundles
     * @param bundleName the name of the language bundle that should be provided to the user
     * @param language that is available (german and english)
     * @param screenHandler that is currently used
     * @throws InterruptDrawException thrown if the language could not be loaded
     */

    public I18nHandler(String bundleName, Locale language, ScreenHandler screenHandler) throws InterruptDrawException {
        this.language = language;
        this.screenHandler = screenHandler;
        this.i18n = setOwnI18n();
        constructBundle(bundleName);
    }

    /**
     * used to construct the required language bundle
     * @param bundleName
     * @throws InterruptDrawException thrown if bundle could not be created
     */
    
    public void constructBundle(String bundleName) throws InterruptDrawException {
        try {
            this.bundle = ResourceBundle.getBundle(constructBundleLink(bundleName), language);
        } catch (MissingResourceException e) {
            new ErrorPopUp(screenHandler.getCurrentView(), i18n.getString("errorMessage"),
                    i18n.getString("errorTitle"));
            throw new InterruptDrawException("TEST");
        }
    }
    /**
     * 
     * @param bundleName
     * @return returns the bundle
     */
    public static String constructBundleLink(String bundleName) {
        return LINK2BUNDLES + bundleName + "/" + bundleName;
    }
    /**
     * sets the language with the bundle link
     * @return 
     */
    public ResourceBundle setOwnI18n() {
        return ResourceBundle.getBundle(constructBundleLink("i18nHandler"), this.language);
    }
    
    public ResourceBundle getBundle() {
        return this.bundle;
    }

    public void setBundle(ResourceBundle newBundle) {
        this.bundle = newBundle;
    }
    /**
     * gets the textstrings
     * @param key
     * @return returns the string or an error text
     */
    public String getString(String key) {
        try {
            return bundle.getString(key);
        } catch (MissingResourceException e) {
            new ErrorPopUp(screenHandler.getCurrentView(), i18n.getString("keyErrorMessage") + " " + key,
                    i18n.getString("keyErrorTitle"));
            return i18n.getString("missingKey");
        }

    }
}
