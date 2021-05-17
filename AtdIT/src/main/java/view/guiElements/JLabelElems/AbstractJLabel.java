package main.java.view.guiElements.JLabelElems;

import javax.swing.JLabel;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.ColorHandler;

public abstract class AbstractJLabel extends JLabel {
	ColorHandler colorHandler;
	
	public AbstractJLabel(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
}
