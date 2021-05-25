package main.java.view.guiElements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.controller.handler.ScreenHandler;
import main.java.view.screen.views.AbstractView;
/**
 * An error PopUp box.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class ErrorPopUp extends AbstractJOptionPane {
    public ErrorPopUp(ScreenHandler screenHandler, String message, String title) {
    	super(screenHandler);
        showMessageDialog(screenHandler.getCurrentView(), message, title, JOptionPane.ERROR_MESSAGE);
    }
}
