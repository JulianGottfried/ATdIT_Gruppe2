package main.java.controller.exceptions;
/**
 * This exception is thrown, if any wrong answer is given. Any wrong datatype is included.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class FaultyAnswerException extends Exception {
    public FaultyAnswerException(String message) {
        super(message);
    }
}
