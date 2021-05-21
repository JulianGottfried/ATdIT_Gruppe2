package main.java.view.guiElements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.controller.handler.ScreenHandler;

public class ErrorPopUp extends AbstractJOptionPane {
    public ErrorPopUp(ScreenHandler screenHandler, String message, String title) {
    	super(screenHandler);
        showMessageDialog(screenHandler.getCurrentView(), message, title, JOptionPane.ERROR_MESSAGE);
    }
}
