package main.java.screen.views;

import main.java.exceptions.InterruptDrawException;

public interface ViewInterface {
	public void loadSelf() throws InterruptDrawException;
	
	public void drawItems();
	
	public abstract void refresh();
}
