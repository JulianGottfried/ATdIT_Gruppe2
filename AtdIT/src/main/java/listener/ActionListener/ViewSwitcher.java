package main.java.listener.ActionListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.java.handler.ScreenHandler;
import main.java.screen.views.AbstractView;

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
