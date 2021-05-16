package main.java.controller.listener.mouseAdapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.controller.handler.ScreenHandler;
import main.java.view.screen.views.HomeScreenView;

public class Return2Home extends MouseAdapter {
	ScreenHandler screenHandler;
	
	public Return2Home(ScreenHandler screenHandler) {
		this.screenHandler = screenHandler;
	}
	
    @Override
    public void mouseClicked(MouseEvent e) {
        screenHandler.changeCurrentView(new HomeScreenView(screenHandler));
    }
}
