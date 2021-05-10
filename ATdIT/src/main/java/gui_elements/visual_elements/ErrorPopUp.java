package main.java.gui_elements.visual_elements;

import javax.swing.JOptionPane;

import main.java.screen.views.AbstractView;

public class ErrorPopUp extends JOptionPane {
    public ErrorPopUp(AbstractView parent, String message, String title) {
        showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
