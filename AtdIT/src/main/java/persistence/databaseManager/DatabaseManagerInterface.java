package main.java.persistence.databaseManager;

import main.java.persistence.databaseTables.AbstractEntry;
import main.java.persistence.databaseTables.Persons;

public interface DatabaseManagerInterface {
	static final String PERSISTENCEUNITNAME = "PostgreSQL";
	
	public void setDatabaseEntry(AbstractEntry entry);
	
	public void updateDatabase(AbstractEntry newEntry);
	
	public <T extends AbstractEntry> T getDatabaseEntry(Class<T> entityClass, int key);
}
