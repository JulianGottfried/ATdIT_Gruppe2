package main.java.controller.listener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import main.java.controller.handler.ScreenHandler;

/**
 * Changes language if user clicks on language button.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */

public class ChangeLanguage implements ActionListener {
    Locale language;
    ScreenHandler screenHandler;

    public ChangeLanguage(ScreenHandler screenHandler, Locale language) {
        this.screenHandler = screenHandler;
        this.language = language;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        screenHandler.changeCurrentViewLanguage(language);
    }
}
