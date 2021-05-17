package main.java.controller.handler.utilityHandler;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * This class gets and returns the image from resources.
 * @author weilichsoheisse
 * @version 16.05.2021
 *
 */

public class ImageHandler extends AbstractUtilityHandler {
	private static final String LINK2IMAGES = new InternalPathsHandler().getProperty("images");

	public ImageHandler(String propName) {
		super(propName);
	}
	
    public Image getImage(String imageName) {
    	String imageLink = LINK2IMAGES + this.getProperty(imageName);
        ImageIcon icon = new ImageIcon(imageLink);
        return icon.getImage();
    }
	
}
