package main.java.guiElements.JTextAreaElems;

import javax.swing.JTextArea;

import main.java.handler.ScreenHandler;
import main.java.handler.utilityHandler.ColorHandler;
import main.java.handler.utilityHandler.FontHandler;

public abstract class AbstractJTextArea extends JTextArea {
	ColorHandler colorHandler;
	FontHandler fontHandler;

	public AbstractJTextArea(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
	}
}
