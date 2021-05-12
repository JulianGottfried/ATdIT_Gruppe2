package main.java.guiElements.JLabelElems;

import javax.swing.JLabel;

import main.java.handler.ColorHandler;
import main.java.handler.ScreenHandler;

public abstract class AbstractJLabel extends JLabel {
	ColorHandler colorHandler;
	
	public AbstractJLabel(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJLabel() {
	}
}
