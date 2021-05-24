package main.java.persistence.databaseManager;

import main.java.persistence.databaseTables.AbstractEntry;
/**
 * Interface for database manager. Nothing special about it.
 * Whoever reads this comment, visit https://www.youtube.com/watch?v=dQw4w9WgXcQ to enjoy some good music :D
 * Just an easter egg, don't take it to serious ;)
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public interface DatabaseManagerInterface {
	static final String PERSISTENCEUNITNAME = "PostgreSQL";
	
	public boolean setDatabaseEntry(AbstractEntry entry);
	
	public boolean updateDatabaseEntry(AbstractEntry newEntry);
	
	public <T extends AbstractEntry> T getDatabaseEntry(Class<T> entityClass, int key);
}
