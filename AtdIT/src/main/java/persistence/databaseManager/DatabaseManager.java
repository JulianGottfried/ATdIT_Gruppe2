package main.java.persistence.databaseManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.json.simple.JSONObject;

import main.java.persistence.databaseTables.AbstractEntry;
import main.java.persistence.databaseTables.Person;

public class DatabaseManager implements DatabaseManagerInterface{
	EntityManager entityManager;
	EntityManagerFactory emFactory;
	
	public static void main(String[] args) {
		Person person = new Person();
		person.setPersonenID("123");
		person.setNachName("weitz");
		new DatabaseManager().updateDatabase(person);
		Person outPerson = new DatabaseManager().getDatabaseEntry(Person.class, "123");
		System.out.println(outPerson.getNachName());
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
