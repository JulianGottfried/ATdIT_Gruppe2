package main.java.display.screen.views;

import main.java.display.exceptions.InterruptDrawException;

public interface ViewInterface {
	public void loadSelf() throws InterruptDrawException;
	
	public void drawItems();
	
	public abstract void refresh();
}
