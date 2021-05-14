package main.java.view.guiElements.JTextAreaElems;

import javax.swing.JTextArea;

import main.java.view.handler.ScreenHandler;
import main.java.view.handler.utilityHandler.ColorHandler;
import main.java.view.handler.utilityHandler.FontHandler;

public abstract class AbstractJTextArea extends JTextArea {
	ColorHandler colorHandler;
	FontHandler fontHandler;

	public AbstractJTextArea(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
	}
}
