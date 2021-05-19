package main.java;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.controller.handler.ScreenHandler;
import main.java.model.Address;
import main.java.model.ChangeOfAddress;
import main.java.model.ModelFactory;
import main.java.model.Person;
import main.java.model.StageOfCOA;
import main.java.persistence.databaseManager.DatabaseManager;
import main.java.persistence.databaseTables.Addresses;
import main.java.persistence.databaseTables.ChangesOfAddresses;
import main.java.persistence.databaseTables.HouseOwners;
import main.java.persistence.databaseTables.Identifications;
import main.java.persistence.databaseTables.Persons;
import main.java.persistence.databaseTables.StagesOfCOA;

public class StartProgram {

	public static void main(String[] args) {
		
//		new ChangeOfAddressQuestions();
//		System.out.println(new ModelFactory().turnToJSON(ChangeOfAddress.class));
        new ScreenHandler();
//    	DatabaseManager dbm = new DatabaseManager();
//    	   	
//    	ChangesOfAddresses coa = new ChangesOfAddresses(new Date());
//    	
//	    	Persons person = new Persons("Marvin", "Weitz", "m", new Date(2000, 11, 24), "Bad Hersfeld", "ledig", null, null, "Deutsch");
//	    	
//		    	Addresses person1Ad = new Addresses("Rohrbacher Str", 59, "Stock 1", 69115, "Heidelberg", "Deutschland");
//		    	dbm.setDatabaseEntry(person1Ad);
//		    	
//
//		    	Identifications id1 = new Identifications("X4D567", "Wildeck-Obersuhl", new Date(2011, 12, 24), new Date(2025, 12, 24));
//		    	dbm.setDatabaseEntry(id1);
//		    	
//		    	person.setAddress(person1Ad);
//		    	person.setIdentification(id1);
//		    	
//		    dbm.setDatabaseEntry(person);
//
//		    
//		     coa.setPerson(person);	   
//
//    	
//	    	Addresses adOld = new Addresses("Rohrbacher Str", 69, null, 69115, "Heidelberg", "Deutschland");
//	    		dbm.setDatabaseEntry(adOld);
//	    	coa.setOldAddress(adOld);
//    	
//			Addresses adNew = new Addresses("Rohrbacher Str", 59, "1. Stock", 69115, "Heidelberg", "Deutschland");
//				coa.setNewAddress(adNew);
//			dbm.setDatabaseEntry(adNew);
//    	
//	    	
//	    	HouseOwners ho = new HouseOwners("Gerd", "Treiber");
//		    	Addresses adOwner = new Addresses("Rohrbacher Str", 59, "4. Stock", 69115, "Heidelberg", "Deutschland");
//		    	dbm.setDatabaseEntry(adOwner);
//		    	
//		    	ho.setAddress(adOwner);
//	    	  	dbm.setDatabaseEntry(ho);
//    	
//	    	coa.setHouseOwner(ho);
//	    	
//	    dbm.setDatabaseEntry(coa);
//	    
//    	
//	    
//	    StagesOfCOA sOCOA = new StagesOfCOA(true, false, false);
//	    
//	    sOCOA.setProcessID(coa);
//    	
//    	dbm.setDatabaseEntry(sOCOA);
    }
}
