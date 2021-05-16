package main.java.view.screen.views;

import main.java.controller.handler.ScreenHandler;

public class BlankView extends AbstractView {

    public BlankView(ScreenHandler screenHandler) {
        super(screenHandler);
    }

    @Override
    public void drawItems() {
        // BlankView is only a fall back page. No items are supposed to be drawn.
    }

}
