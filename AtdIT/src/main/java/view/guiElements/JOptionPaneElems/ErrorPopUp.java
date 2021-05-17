package main.java.view.guiElements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.view.screen.views.AbstractView;

/**
* This class creates an error popup. 
* @author weilichsoheisse
* @version 16.05.2021
*
*/

public class ErrorPopUp extends AbstractJOptionPane {
    public ErrorPopUp(AbstractView parent, String message, String title) {
        showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
