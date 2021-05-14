package main.java.view.guiElements.JTextAreaElems;

import javax.swing.JTextArea;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.ColorHandler;
import main.java.controller.handler.utilityHandler.FontHandler;

public abstract class AbstractJTextArea extends JTextArea {
	ColorHandler colorHandler;
	FontHandler fontHandler;

	public AbstractJTextArea(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
	}
}
