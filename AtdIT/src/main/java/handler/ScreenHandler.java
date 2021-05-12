package main.java.handler;

import java.util.Locale;

import java.awt.Container;

import main.java.exceptions.InterruptDrawException;
import main.java.screen.views.HomeScreenView;
import main.java.screen.views.BlankView;
import main.java.screen.WindowFrame;
import main.java.screen.views.AbstractView;

public class ScreenHandler {
    private Locale language;
    private String colorTemplate;
    private String fontTemplate;
    private String imageTemplate;
    private ColorHandler colorHandler;
    private FontHandler fontHandler;
    private ImageHandler imageHandler;
    private AbstractView currentView;
    private AbstractView previousView;
    private WindowFrame mainScreen;

    public ScreenHandler() {
    	this.language = Locale.getDefault();
    	this.colorTemplate = "colors/normalColors.properties";
    	this.fontTemplate = "fonts/normalFonts.properties";
    	this.imageTemplate = "images/normalImages.properties";
    	this.colorHandler = new ColorHandler(colorTemplate);
    	this.fontHandler = new FontHandler(fontTemplate);
    	this.imageHandler = new ImageHandler(imageTemplate);
        this.mainScreen = new WindowFrame();
        this.currentView = new HomeScreenView(this);
        this.previousView = new BlankView(this);
        this.changeView(this.currentView);
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
    	this.setLanguage(language);
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

	public Locale getLanguage() {
		return language;
	}

	public void setLanguage(Locale language) {
		this.language = language;
	}

	public String getColorTemplate() {
		return colorTemplate;
	}

	public void setColorTemplate(String colorTemplate) {
		this.colorTemplate = colorTemplate;
	}

	public String getFontTemplate() {
		return fontTemplate;
	}

	public void setFontTemplate(String fontTemplate) {
		this.fontTemplate = fontTemplate;
	}

	public ColorHandler getColorHandler() {
		return colorHandler;
	}

	public void setColorHandler(ColorHandler colorHandler) {
		this.colorHandler = colorHandler;
	}

	public FontHandler getFontHandler() {
		return fontHandler;
	}

	public void setFontHandler(FontHandler fontHandler) {
		this.fontHandler = fontHandler;
	}

	public ImageHandler getImageHandler() {
		return imageHandler;
	}

	public void setImageHandler(ImageHandler imageHandler) {
		this.imageHandler = imageHandler;
	}
}
