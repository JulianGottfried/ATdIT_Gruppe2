package main.java.controller.handler;
/**
 * Checks if String is numeric or not.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class TypeHandler {
	/**
	 * 
	 * @param input String to checked if numeric or not.
	 * @return True if String contains only numbers.
	 */
	public static boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}
}
