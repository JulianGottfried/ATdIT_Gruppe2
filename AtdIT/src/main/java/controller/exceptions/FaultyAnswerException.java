package main.java.controller.exceptions;

public class FaultyAnswerException extends Exception {
    public FaultyAnswerException(String message) {
        super(message);
    }
}
