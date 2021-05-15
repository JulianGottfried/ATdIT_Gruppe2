package main.java;

import java.util.Date;

import main.java.controller.handler.ScreenHandler;
import main.java.persistence.databaseManager.DatabaseManager;
import main.java.persistence.databaseTables.Addresses;
import main.java.persistence.databaseTables.ChangesOfAddresses;
import main.java.persistence.databaseTables.HouseOwners;

public class StartProgram {

    public static void main(String[] args) {
        // new ScreenHandler();
    	DatabaseManager dbm = new DatabaseManager();
    	
    	ChangesOfAddresses coa = new ChangesOfAddresses(213, new Date(), 32423);
    	
    	Addresses adOld = new Addresses("Rohrbacher Str", 69, null, 69115, "Heidelberg", "Deutschland");
    	dbm.setDatabaseEntry(adOld);
    	coa.setOldAddress(adOld);
    	
    	Addresses adNew = new Addresses("Rohrbacher Str", 59, "1. Stock", 69115, "Heidelberg", "Deutschland");
    	coa.setNewAddress(adNew);
    	dbm.setDatabaseEntry(adNew);
    	
    	Addresses adOwner = new Addresses("Rohrbacher Str", 59, "4. Stock", 69115, "Heidelberg", "Deutschland");
    	HouseOwners ho = new HouseOwners("Gerd", "Treiber");
    	ho.setAddress(adOwner);
    	dbm.setDatabaseEntry(adOwner);
    	dbm.setDatabaseEntry(ho);
    	
    	coa.setHouseOwner(ho);
    	
    	dbm.setDatabaseEntry(coa);
    }
}
