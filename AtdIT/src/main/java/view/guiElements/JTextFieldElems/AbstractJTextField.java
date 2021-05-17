package main.java.view.guiElements.JTextFieldElems;

import javax.swing.JTextField;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.ColorHandler;
import main.java.controller.handler.utilityHandler.FontHandler;

public abstract class AbstractJTextField extends JTextField {
	ColorHandler colorHandler;
	FontHandler fontHandler;

	public AbstractJTextField(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
	}
}
