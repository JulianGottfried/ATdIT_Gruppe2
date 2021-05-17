package main.java.view.guiElements.JButtonElems;

import javax.swing.JButton;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.ColorHandler;
import main.java.controller.handler.utilityHandler.FontHandler;

public class AbstractButton extends JButton {
	ColorHandler colorHandler;
	FontHandler fontHandler;
	
	public AbstractButton(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.fontHandler = screenHandler.getFontHandler();
		this.setBackground(colorHandler.getColor("background"));
		this.setFont(fontHandler.getFont("menuButton"));
        this.setForeground(colorHandler.getColor("menuButtonText"));
	}
}
