package main.java.controller.listener.ActionListener;

import java.awt.event.ActionListener;

import main.java.controller.handler.ScreenHandler;
import main.java.view.screen.views.AbstractView;

import java.awt.event.ActionEvent;
/**
 * 
 * This class is used as an action listener for a view switch command.
 * @author weilichsoheisse
 * @version 16.05.2021
 *
 */
public class ViewSwitcher implements ActionListener {
    ScreenHandler screenHandler;
    AbstractView view;

    public ViewSwitcher(ScreenHandler screenHandler, AbstractView view) {
        this.screenHandler = screenHandler;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	screenHandler.changeCurrentView(view);
    }
}
