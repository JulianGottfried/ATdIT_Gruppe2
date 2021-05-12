package main.java.gui_elements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.ScreenHandler;
import main.java.handler.ColorHandler;

public abstract class AbstractJOptionPane extends JOptionPane {
	ColorHandler colorHandler;
	
	public AbstractJOptionPane(ScreenHandler screenHandler) {
		this.colorHandler = screenHandler.getColorHandler();
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJOptionPane() {
		
	}
}
