package main.java.view.screen.views;

import main.java.controller.handler.ScreenHandler;
import main.java.view.guiElements.JTextAreaElems.FancyTextArea;

public class ContactView extends AbstractView {

    public ContactView(ScreenHandler screenHandler) {
        super(screenHandler);
    }

    @Override
    public void drawItems() {
        FancyTextArea contactText = new FancyTextArea(screenHandler);
    }

}
