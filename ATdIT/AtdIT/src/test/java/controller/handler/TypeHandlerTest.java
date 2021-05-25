package test.java.controller.handler;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.controller.handler.TypeHandler;

public class TypeHandlerTest {
	@Test
	public void testIfNumericStringIsRecognised() {
		String numericTest = "384";
		assertEquals(true, TypeHandler.isInt(numericTest));
	}

	@Test
	public void testIfNonNumericStringIsRecognised() {
		String nonNumericTest = "3regi4";
		assertEquals(false, TypeHandler.isInt(nonNumericTest));
	}
}
