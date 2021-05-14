package main.java.view.guiElements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.view.handler.ScreenHandler;
import main.java.view.handler.utilityHandler.ColorHandler;

public abstract class AbstractJOptionPane extends JOptionPane {
	ColorHandler colorHandler;
	
	public AbstractJOptionPane(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJOptionPane() {
		
	}
}
