package main.java.persistence.databaseManager;

import main.java.persistence.databaseTables.AbstractEntry;

public interface DatabaseManagerInterface {
	static final String PERSISTENCEUNITNAME = "PostgreSQL";
	
	public boolean setDatabaseEntry(AbstractEntry entry);
	
	public boolean updateDatabaseEntry(AbstractEntry newEntry);
	
	public <T extends AbstractEntry> T getDatabaseEntry(Class<T> entityClass, int key);
}
