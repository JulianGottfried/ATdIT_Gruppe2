package main.java.handler;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.MissingResourceException;

import main.java.exceptions.InterruptDrawException;
import main.java.gui_elements.JOptionPaneElems.ErrorPopUp;

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
            bundle = ResourceBundle.getBundle(constructBundleLink(bundleName), language);
            this.setBundle(bundle);
        } catch (MissingResourceException e) {
            new ErrorPopUp(screenHandler.getCurrentView(), i18n.getString("errorMessage"),
                    i18n.getString("errorTitle"));
            throw new InterruptDrawException("TEST");
        }
    }

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
            new ErrorPopUp(screenHandler.getCurrentView(), i18n.getString("keyErrorMessage") + " " + key,
                    i18n.getString("keyErrorTitle"));
            return i18n.getString("missingKey");
        }

    }
}
