package main.java.gui_elements.JTextAreaElems;

import javax.swing.JTextArea;

import main.java.ScreenHandler;
import main.java.handler.ColorHandler;
import main.java.handler.FontHandler;

public abstract class AbstractJTextArea extends JTextArea {
	ColorHandler colorHandler;
	FontHandler fontHandler;

	public AbstractJTextArea(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
	}
}
