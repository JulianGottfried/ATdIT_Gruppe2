package main.java.guiElements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.handler.ScreenHandler;
import main.java.handler.utilityHandler.ColorHandler;

public abstract class AbstractJOptionPane extends JOptionPane {
	ColorHandler colorHandler;
	
	public AbstractJOptionPane(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJOptionPane() {
		
	}
}
