package main.java.persistence.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.simple.JSONObject;

import main.java.persistence.databaseTables.AbstractEntry;
import main.java.persistence.databaseTables.Persons;

public class DatabaseManager implements DatabaseManagerInterface{
	EntityManager entityManager;
	EntityManagerFactory emFactory;
	
	public void writeToDatabase(AbstractEntry entry) {
		createManager();
		this.entityManager.persist(entry);
		closeManager();
	}
	
	public void updateDatabase(AbstractEntry newEntry) {
		createManager();
		this.entityManager.merge(newEntry);
		closeManager();
	}
	
	public <T extends AbstractEntry> T getDatabaseEntry(Class<T> entityClass, int key) {
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
