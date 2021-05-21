package main.java.controller.listener.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.controller.handler.ScreenHandler;
import main.java.view.screen.views.HomeScreenView;

public class Return2Home implements ActionListener {
ScreenHandler screenHandler;
	
	public Return2Home(ScreenHandler screenHandler) {
		this.screenHandler = screenHandler;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		screenHandler.changeCurrentView(new HomeScreenView(screenHandler));		
	}

}
