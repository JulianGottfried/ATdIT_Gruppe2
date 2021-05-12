package main.java.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import main.java.handler.ScreenHandler;

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
