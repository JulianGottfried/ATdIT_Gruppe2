package main.java.display.guiElements.JTextAreaElems;

import javax.swing.JTextArea;

import main.java.display.handler.ScreenHandler;
import main.java.display.handler.utilityHandler.ColorHandler;
import main.java.display.handler.utilityHandler.FontHandler;

public abstract class AbstractJTextArea extends JTextArea {
	ColorHandler colorHandler;
	FontHandler fontHandler;

	public AbstractJTextArea(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
	}
}
