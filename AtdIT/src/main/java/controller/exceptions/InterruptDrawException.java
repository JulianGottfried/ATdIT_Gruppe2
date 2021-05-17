package main.java.controller.exceptions;
/**
 * This class is used for creating the <code>InterruptDrawException</code>.
 * 
 * @author weilichsoheisse
 * @version 16.05.2021
 *
 */

public class InterruptDrawException extends Exception {
	/**
	 * 
	 * @param message a message for the exception
	 */
    public InterruptDrawException(String message) {
        super(message);
    }
}
