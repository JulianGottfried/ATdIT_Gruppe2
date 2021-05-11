package main.java.gui_elements.functional_elements;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import main.java.ScreenHandler;
import main.java.screen.views.AbstractView;

public class ViewSwitcher implements ActionListener {
    ScreenHandler handler;
    AbstractView view;

    public ViewSwitcher(ScreenHandler handler, AbstractView view) {
        this.handler = handler;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handler.changeView(view);
    }
}