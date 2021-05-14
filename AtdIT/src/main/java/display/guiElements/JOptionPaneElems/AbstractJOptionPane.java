package main.java.display.guiElements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.display.handler.ScreenHandler;
import main.java.display.handler.utilityHandler.ColorHandler;

public abstract class AbstractJOptionPane extends JOptionPane {
	ColorHandler colorHandler;
	
	public AbstractJOptionPane(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJOptionPane() {
		
	}
}
