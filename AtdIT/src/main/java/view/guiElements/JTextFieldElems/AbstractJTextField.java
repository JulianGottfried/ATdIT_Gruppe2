package main.java.view.guiElements.JTextFieldElems;

import javax.swing.JTextField;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.ColorHandler;
import main.java.controller.handler.utilityHandler.FontHandler;
/**
 * Basic Text Field.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public abstract class AbstractJTextField extends JTextField {
	ColorHandler colorHandler;
	FontHandler fontHandler;

	public AbstractJTextField(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
	}
}
