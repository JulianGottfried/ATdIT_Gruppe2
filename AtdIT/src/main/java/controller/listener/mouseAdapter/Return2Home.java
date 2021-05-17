package main.java.controller.listener.mouseAdapter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.java.controller.handler.ScreenHandler;
import main.java.view.screen.views.HomeScreenView;
/**
 * 
 * This class handles the click on the home button.
 * @author weilichsoheisse
 * @version 16.05.2021
 *
 */
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
