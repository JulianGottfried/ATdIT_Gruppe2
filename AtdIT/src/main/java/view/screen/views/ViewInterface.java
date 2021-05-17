package main.java.view.screen.views;

import main.java.controller.exceptions.InterruptDrawException;

/**
*  
* @author weilichsoheisse
* @version 16.05.2021
*
*/

public interface ViewInterface {
	public void loadSelf() throws InterruptDrawException;
	
	public void drawItems();
	
	public abstract void refresh();
}
