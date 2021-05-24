package main.java.controller.exceptions;
/**
 * This exception is thrown, if a problem during the database saving process appears.
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class DBSavingException extends Exception {
	public DBSavingException(String modelName) {
        super("The model " + modelName + " couldn't be saved to the Database");
    }
}
