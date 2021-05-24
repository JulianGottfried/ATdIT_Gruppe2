package test.java.controller.handler.utilityHandler;

import static org.junit.Assert.assertEquals;

import java.awt.Font;

import org.junit.Test;

import main.java.controller.handler.utilityHandler.FontHandler;

/**
 * Font Handler test Checks if the right font for a specific code is returned..
 * 
 * @author weilichsoheisse
 * @version 22.05.2021
 *
 */
public class FontHandlerTest {
	String fontTestKey = "h1";
	Font testFont = new Font("Dialog", Font.BOLD, 54);
	FontHandler testFontHandler = new FontHandler("fonts/normalFonts.properties");

	@Test
	public void checkIfRightFontIsReturnedForSpecificKey() {
		assertEquals(testFont, testFontHandler.getFont(fontTestKey));
	}
}
