package test.java.controller.handler.utilityHandler;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

import main.java.controller.handler.utilityHandler.ColorHandler;

/**
 * Color Handler test Checks if the right color for a specific code is returned
 * or black in an unknown case.
 * 
 * @author weilichsoheisse
 * @version 22.05.2021
 *
 */
public class ColorHandlerTest {
	String colorTestKey = "background";
	String colorExceptionKey = "not available";
	Color testColor = Color.white;
	Color testExceptionColor = Color.black;
	ColorHandler testColorHandler = new ColorHandler("colors/normalColors.properties");
	
	@Test
	public void checkIfRightColorIsReturnedForBackground () {
		assertEquals(testColor, testColorHandler.getColor(colorTestKey));	
	}
	
	@Test
	public void checkIfColorHandlerReturnsBlackAsDefaultIfUnknownColorIsGiven () {
		assertEquals(testExceptionColor, testColorHandler.getColor(colorExceptionKey));
	}
}
