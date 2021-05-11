package main.java.gui_elements.visual_elements.JTextAreaElems;

import javax.swing.JTextArea;

import main.java.handler.ColorHandler;

public class AbstractJTextArea extends JTextArea {
	ColorHandler colorHandler;

	public AbstractJTextArea(String colorTemplate) {
		this.colorHandler = new ColorHandler(colorTemplate);
	}
	
	public AbstractJTextArea() {
	}
}
