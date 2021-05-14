package main.java.view.guiElements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.utilityHandler.ColorHandler;

public abstract class AbstractJOptionPane extends JOptionPane {
	ColorHandler colorHandler;
	
	public AbstractJOptionPane(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJOptionPane() {
		
	}
}
