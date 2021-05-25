package main.java.controller.exceptions;

/**
 * This exception is thrown, if the last question during the registration process is answered.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */

public class EndOfQuestions extends Exception {
    public EndOfQuestions(String message) {
        super(message);
    }
}

