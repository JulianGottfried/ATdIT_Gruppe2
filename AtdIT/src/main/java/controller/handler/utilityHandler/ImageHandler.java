package main.java.controller.handler.utilityHandler;

import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * The image handler gets the images from the .properties file.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class ImageHandler extends AbstractUtilityHandler {
	private static final String LINK2IMAGES = new InternalPathsHandler().getProperty("images");

	public ImageHandler(String propName) {
		super(propName);
	}
	/**
	 * 
	 * @param imageName the name of the image, which path is saved in the .properties file.
	 * @return an image
	 */
    public Image getImage(String imageName) {
    	String imageLink = LINK2IMAGES + this.getProperty(imageName);
        ImageIcon icon = new ImageIcon(imageLink);
        return icon.getImage();
    }
	
}
