package main.java.view.screen.views;

import main.java.controller.exceptions.InterruptDrawException;

public interface ViewInterface {
	public void loadSelf() throws InterruptDrawException;
	
	public void drawItems();
	
	public abstract void refresh();
}
