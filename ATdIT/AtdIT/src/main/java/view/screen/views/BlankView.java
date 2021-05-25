package main.java.view.screen.views;

import main.java.controller.handler.ScreenHandler;

/**
 * This view is blank. This is a fall back page. No items are supposed to be
 * drawn.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class BlankView extends AbstractView {

	public BlankView(ScreenHandler screenHandler) {
		super(screenHandler);
	}

	@Override
	public void drawItems() {
	}

}
