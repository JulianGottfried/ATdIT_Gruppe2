package main.java.view.screen.views;

import java.util.Locale;

import javax.swing.JPanel;

import main.java.view.exceptions.InterruptDrawException;
import main.java.view.handler.ScreenHandler;
import main.java.view.handler.languageHandler.I18nHandler;
import main.java.view.handler.utilityHandler.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public abstract class AbstractView extends JPanel implements ViewInterface {
    String bundleName;
    ScreenHandler screenHandler;
    Locale language;
    ColorHandler colorHandler;
    FontHandler fontHandler;
    I18nHandler i18n;
    GridBagConstraints gbc;

    protected AbstractView(ScreenHandler screenHandler) {
        this.screenHandler = screenHandler;
        this.bundleName = this.getClass().getSimpleName();
        this.setLayout(new GridBagLayout());
    }

    public void loadSelf() throws InterruptDrawException {
    	this.removeAll();
    	this.revalidate();
    	this.repaint();
        try {
            this.i18n = new I18nHandler(bundleName, screenHandler.getLanguage(), this.screenHandler);
        } catch (InterruptDrawException e) {
            screenHandler.changeCurrentView(screenHandler.getPreviousView());
            throw new InterruptDrawException(e.getMessage());
        }
        this.colorHandler = screenHandler.getColorHandler();
        this.fontHandler = screenHandler.getFontHandler();
        this.setBackground(colorHandler.getColor("background"));
        this.drawItems();
    }

    public abstract void drawItems();

    public void refresh() {
        this.removeAll();
        this.revalidate();
        try {
            this.loadSelf();
        } catch (InterruptDrawException e) {
            // TODO: Add logger
        }
    }
}
