package main.java.persistence;

import main.java.persistence.databaseTables.AbstractEntry;

public interface DatabaseManagerInterface {
	static final String PERSISTENCEUNITNAME = "PostgreSQL";
	
	public void writeToDatabase(AbstractEntry entry);
	
	public void updateDatabase(AbstractEntry newEntry);
	
	public AbstractEntry getDatabaseEntry(Class<AbstractEntry> entityClass, String key);
}
