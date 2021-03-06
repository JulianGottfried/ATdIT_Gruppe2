package main.java.view.guiElements.JButtonElems;

import main.java.controller.handler.ScreenHandler;
/**
 * A beautiful button with all features included.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class FancyButton extends AbstractButton{
	
	public FancyButton(ScreenHandler screenHandler) {
		super(screenHandler);
	}
	
	public FancyButton(ScreenHandler screenHandler, String bgColorKey) {
		super(screenHandler);
		this.setBackground(colorHandler.getColor(bgColorKey));
	}
	
	public FancyButton(ScreenHandler screenHandler, String bgColorKey, String fontKey) {
		super(screenHandler);
		this.setBackground(colorHandler.getColor(bgColorKey));
		this.setFont(fontHandler.getFont(fontKey));
	}
}
