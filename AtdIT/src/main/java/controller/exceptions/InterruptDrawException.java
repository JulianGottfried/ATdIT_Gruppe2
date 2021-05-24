package main.java.controller.exceptions;

/**
 * This exception is thrown, if any view could not be loaded correctly. This can appear if the connection to the database
 * could not be established or an internal file could not be found.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */

public class InterruptDrawException extends Exception {
    public InterruptDrawException(String message) {
        super(message);
    }
}
