package main.java.persistence.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import main.java.persistence.databaseTables.AbstractEntry;
/**
 * The database manager class is used for all operation dealing with the database.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class DatabaseManager implements DatabaseManagerInterface{
	EntityManager entityManager;
	EntityManagerFactory emFactory;
	/**
	 * Creates a database entry.
	 */
	public boolean setDatabaseEntry(AbstractEntry entry) {
		try {
			createManager();
			this.entityManager.persist(entry);
			closeManager();
			return true;
		} catch (PersistenceException pe) {
			return false;
		}
	}
	/**
	 * Updates an existing database entry
	 */
	public boolean updateDatabaseEntry(AbstractEntry newEntry) {
		try {
			createManager();
			this.entityManager.merge(newEntry);
			closeManager();
			return true;
		} catch (PersistenceException pe) {
			return false;
		}
	}
	/**
	 * Gets an entry from the database.
	 */
	public <T extends AbstractEntry> T getDatabaseEntry(Class<T> entityClass, int key) {
		createManager();
		T retrievedEntry = this.entityManager.find(entityClass, key);
		closeManager();
		return retrievedEntry;
	}
	/**
	 * Gets an entry from the database.
	 */
	public <T extends AbstractEntry> T getDatabaseEntry(Class<T> entityClass, String key) {
		createManager();
		T retrievedEntry = this.entityManager.find(entityClass, key);
		closeManager();
		return retrievedEntry;
	}
	
	private void createManager() {
		this.emFactory = Persistence.createEntityManagerFactory(PERSISTENCEUNITNAME);
		this.entityManager = emFactory.createEntityManager();
		this.entityManager.getTransaction().begin();
	}
	
	private void closeManager() {
		this.entityManager.getTransaction().commit();
		this.entityManager.close();	
		this.emFactory.close();
	}
}
