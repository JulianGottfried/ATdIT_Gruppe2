package main.java.controller.exceptions;

public class DBSavingException extends Exception {
	public DBSavingException(String modelName) {
        super("The model " + modelName + " couldn't be saved to the Databse");
    }
}
