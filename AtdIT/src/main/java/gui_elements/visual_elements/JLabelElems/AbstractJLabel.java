package main.java.gui_elements.visual_elements.JLabelElems;

import javax.swing.JLabel;

import main.java.handler.ColorHandler;

public class AbstractJLabel extends JLabel {
	ColorHandler colorHandler;
	
	public AbstractJLabel(String colorTemplate) {
		this.colorHandler = new ColorHandler(colorTemplate);
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJLabel() {
	}
}
