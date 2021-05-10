package main.java.screen.views;

import java.util.Locale;

import javax.swing.JPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import main.java.ScreenHandler;
import main.java.exceptions.InterruptDrawException;
import main.resources.utilities.Colors;
import main.resources.utilities.I18nHandler;

public abstract class AbstractView extends JPanel {
    protected Locale language;
    protected String bundleName;
    protected I18nHandler i18n;
    protected ScreenHandler screenHandler;
    protected GridBagConstraints gbc;

    protected AbstractView(ScreenHandler screenHandler, Locale language) {
        this.screenHandler = screenHandler;
        this.bundleName = this.getClass().getSimpleName();
        this.language = language;
        this.setBackground(Colors.getBackground());
        this.setLayout(new GridBagLayout());
    }

    public void loadSelf() throws InterruptDrawException {
        try {
            this.i18n = new I18nHandler(this.bundleName, this.language, this.screenHandler);
        } catch (InterruptDrawException e) {
            screenHandler.changeView(screenHandler.getPreviousView());
            throw new InterruptDrawException(e.getMessage());
        }
        this.drawItems();
    }

    public abstract void drawItems();

    public Locale getLanguage() {
        return this.language;
    }

    public void setLanguage(Locale language) {
        this.language = language;
        this.refresh();
    }

    private void refresh() {
        this.removeAll();
        this.revalidate();
        try {
            this.loadSelf();
        } catch (InterruptDrawException e) {
            // TODO: Add logger
        }
    }
}
