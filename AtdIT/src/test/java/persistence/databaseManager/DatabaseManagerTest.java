package test.java.persistence.databaseManager;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import main.java.persistence.databaseManager.DatabaseManager;
import main.java.persistence.databaseTables.Addresses;
import main.java.persistence.databaseTables.Identifications;
import main.java.persistence.databaseTables.Persons;

/**
 * 
 * @author weilichsoheisse
 * @version 22.05.2021
 * 
 *          Need to finish later
 */
public class DatabaseManagerTest {

	@Test
	public void checkIfSetDatabaseEntryAndGetDatabaseEntryReturnTheSameResult() {

		DatabaseManager dbm = new DatabaseManager();

		@SuppressWarnings("deprecation")
		Persons person1 = new Persons("Marvin", "Weitz", "m", new Date(2000, 11, 24), "Bad Hersfeld", "ledig", null,
				null, "Deutsch");

		Addresses person1Ad = new Addresses("Rohrbacher Str", 59, "Stock 1", 69115, "Heidelberg", "Deutschland");
		dbm.setDatabaseEntry(person1Ad);

		@SuppressWarnings("deprecation")
		Identifications id1 = new Identifications("PPSQ34", "Wildeck-Obersuhl", new Date(2011, 12, 24),
				new Date(2025, 12, 24));
		dbm.setDatabaseEntry(id1);

		person1.setAddress(person1Ad);
		person1.setIdentification(id1);
		person1.setPersonID(123);

		dbm.setDatabaseEntry(person1);

		System.out.print(dbm.getDatabaseEntry(Persons.class, 123)); // return null?
		// assertEquals(person1, dbm.getDatabaseEntry(Persons.class, 123));

	}
}
