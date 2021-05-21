package main.java.controller.handler;

public class TypeHandler {
	
	public static boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
