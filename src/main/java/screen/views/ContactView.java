package main.java.screen.views;

import main.java.ScreenHandler;

import java.awt.GridBagLayout;
import java.util.Locale;

public class ContactView extends AbstractView {

    public ContactView(ScreenHandler screenHandler, Locale language) {
        super(screenHandler, language);
        this.setLayout(new GridBagLayout());
    }

    @Override
    public void drawItems() {
        // TODO Auto-generated method stub

    }

}
