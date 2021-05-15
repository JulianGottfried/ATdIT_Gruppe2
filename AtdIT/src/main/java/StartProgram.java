package main.java;

import java.util.Date;

import main.java.controller.handler.ScreenHandler;
import main.java.persistence.databaseManager.DatabaseManager;
import main.java.persistence.databaseTables.Addresses;
import main.java.persistence.databaseTables.ChangesOfAddresses;
import main.java.persistence.databaseTables.Persons;

public class StartProgram {

    public static void main(String[] args) {
        // new ScreenHandler();
    	
    	DatabaseManager dbm = new DatabaseManager();
    	
    	// moin meister
    	ChangesOfAddresses x = new ChangesOfAddresses();
    	dbm.writeToDatabase(x);
    }
}
