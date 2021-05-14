package main.java.view.listener.ActionListener;

import java.awt.event.ActionListener;

import main.java.view.handler.ScreenHandler;
import main.java.view.screen.views.AbstractView;

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
