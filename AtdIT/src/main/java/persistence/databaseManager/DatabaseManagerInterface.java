package main.java.persistence.databaseManager;

import main.java.persistence.databaseTables.AbstractEntry;

public interface DatabaseManagerInterface {
	static final String PERSISTENCEUNITNAME = "PostgreSQL";
	
	public void setDatabaseEntry(AbstractEntry entry);
	
	public void updateDatabaseEntry(AbstractEntry newEntry);
	
	public <T extends AbstractEntry> T getDatabaseEntry(Class<T> entityClass, int key);
}