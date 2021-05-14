package main.java.display.listener.ActionListener;

import java.awt.event.ActionListener;

import main.java.display.handler.ScreenHandler;
import main.java.display.screen.views.AbstractView;

import java.awt.event.ActionEvent;

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
