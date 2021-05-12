package main.java.screen.views;

import java.util.Locale;

import main.java.ScreenHandler;

public class BlankView extends AbstractView {

    public BlankView(ScreenHandler screenHandler) {
        super(screenHandler);
    }

    @Override
    public void drawItems() {
        // BlankView is only a fall back page. No items are supposed to be drawn.
    }

}
