package main.java.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.simple.JSONObject;

import main.java.persistence.databaseTables.AbstractEntry;
import main.java.persistence.databaseTables.Person;

public class DatabaseManager implements DatabaseManagerInterface {
	EntityManager entityManager;
	EntityManagerFactory emFactory;
	
	public static void main(String[] args) {
	}
	
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
	
	public AbstractEntry getDatabaseEntry(Class<AbstractEntry> entityClass, String key) {
		createManager();
		AbstractEntry retrievedEntry = this.entityManager.find(entityClass, key);
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
