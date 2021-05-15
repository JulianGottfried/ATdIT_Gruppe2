package main.java.model;

import main.java.persistence.databaseManager.DatabaseManager;
import main.java.persistence.databaseTables.Addresses;

public class ModelFactory {
	private Address address;
	private ChangeOfAddress changeofAddress;
	private HouseOwner houseOwner;
	private HouseProvider houseProvider;
	private Identification identification;
	private Person person;
	private StageOfCOA stageOfCOA;
	
	private DatabaseManager dbm;
	
	public ModelFactory() {
		this.dbm = new DatabaseManager();
	}
	
	public Address getAddress(int key) {
		Addresses entry = dbm.getDatabaseEntry(Addresses.class, key);
		
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public ChangeOfAddress getChangeofAddress(int key) {
		return changeofAddress;
	}
	
	public void setChangeofAddress(ChangeOfAddress changeofAddress) {
		this.changeofAddress = changeofAddress;
	}
	
	public HouseOwner getHouseOwner(int key) {
		return houseOwner;
	}
	
	public void setHouseOwner(HouseOwner houseOwner) {
		this.houseOwner = houseOwner;
	}
	
	public HouseProvider getHouseProvider(int key) {
		return houseProvider;
	}
	
	public void setHouseProvider(HouseProvider houseProvider) {
		this.houseProvider = houseProvider;
	}
	
	public Identification getIdentification(int key) {
		return identification;
	}
	
	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
	
	public Person getPerson(int key) {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public StageOfCOA getStageOfCOA(int key) {
		return stageOfCOA;
	}
	
	public void setStageOfCOA(StageOfCOA stageOfCOA) {
		this.stageOfCOA = stageOfCOA;
	}
}
