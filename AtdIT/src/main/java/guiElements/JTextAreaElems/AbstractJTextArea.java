package main.java.guiElements.JTextAreaElems;

import javax.swing.JTextArea;

import main.java.handler.ColorHandler;
import main.java.handler.FontHandler;
import main.java.handler.ScreenHandler;

public abstract class AbstractJTextArea extends JTextArea {
	ColorHandler colorHandler;
	FontHandler fontHandler;

	public AbstractJTextArea(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
	}
}
