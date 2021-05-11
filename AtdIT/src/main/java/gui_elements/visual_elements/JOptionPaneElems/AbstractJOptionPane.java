package main.java.gui_elements.visual_elements.JOptionPaneElems;

import javax.swing.JOptionPane;

import main.java.handler.ColorHandler;

public class AbstractJOptionPane extends JOptionPane {
	ColorHandler colorHandler;
	
	public AbstractJOptionPane(String colorTemplate) {
		this.colorHandler = new ColorHandler(colorTemplate);
		this.setBackground(colorHandler.getColor("background"));
	}
	
	public AbstractJOptionPane() {
	}
}
