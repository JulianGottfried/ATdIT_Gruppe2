package main.java.persistence.databaseManager;

import main.java.persistence.databaseTables.AbstractEntry;

public interface DatabaseManagerInterface {
	static final String PERSISTENCEUNITNAME = "PostgreSQL";
	
	public void writeToDatabase(AbstractEntry entry);
	
	public void updateDatabase(AbstractEntry newEntry);
	
	//public Class<? extends AbstractEntry> getDatabaseEntry(Class<? extends AbstractEntry> entityClass, String key);
	
	public <T extends AbstractEntry> T getDatabaseEntry(Class<T> entityClass, String key);
}
