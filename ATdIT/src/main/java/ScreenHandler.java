package main.java;

import java.util.Locale;

import java.awt.Container;

import main.java.exceptions.InterruptDrawException;
import main.java.screen.Start;
import main.java.screen.views.HomeScreenView;
import main.java.screen.views.BlankView;
import main.java.screen.views.AbstractView;

public class ScreenHandler {
    private AbstractView currentView;
    private AbstractView previousView;
    Locale language = Locale.getDefault();

    private Start mainScreen = new Start();

    public ScreenHandler() {
        this.currentView = new HomeScreenView(this, this.language);
        this.previousView = new BlankView(this, this.language);
        this.changeView(this.currentView);
    }

    public static void main(String[] args) {
        new ScreenHandler();
    }

    public void changeView(AbstractView view) {
        this.resetContainer(this.mainScreen);
        this.loadView(view);
    }

    public void loadView(AbstractView view) {
        try {
            view.loadSelf();
        } catch (InterruptDrawException e) {
            // TODO: Logger
            return;
        }

        this.drawView(view);

        this.setPreviousView(this.currentView);
        this.setCurrentView(view);
    }

    public void drawView(AbstractView view) {
        this.mainScreen.add(view);
        redrawContainer(this.mainScreen);
        this.mainScreen.setVisible(true);
    }

    public void resetContainer(Container container) {
        container.remove(this.currentView);
        this.redrawContainer(container);
    }

    public void redrawContainer(Container container) {
        container.revalidate();
        container.repaint();
    }

    public void changeCurrentViewLanguage(Locale language) {
        this.currentView.setLanguage(language);
        this.resetContainer(this.mainScreen);
        try {
            this.currentView.loadSelf();
        } catch (InterruptDrawException e) {
            // TODO: Logger
            return;
        }
        this.drawView(this.currentView);
    }

    public AbstractView getPreviousView() {
        return this.previousView;
    }

    public void setPreviousView(AbstractView newView) {
        this.previousView = newView;
    }

    public AbstractView getCurrentView() {
        return this.currentView;
    }

    public void setCurrentView(AbstractView newView) {
        this.currentView = newView;
    }
}
