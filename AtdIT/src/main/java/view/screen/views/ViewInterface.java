package main.java.view.screen.views;

import main.java.view.exceptions.InterruptDrawException;

public interface ViewInterface {
	public void loadSelf() throws InterruptDrawException;
	
	public void drawItems();
	
	public abstract void refresh();
}
