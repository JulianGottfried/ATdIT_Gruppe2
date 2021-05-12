package main.java.gui_elements.JLabelElems;

import javax.swing.JLabel;

import main.java.ScreenHandler;
import main.java.handler.ColorHandler;

public abstract class AbstractJLabel extends JLabel {
	ColorHandler colorHandler;
	
	public AbstractJLabel(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJLabel() {
	}
}
