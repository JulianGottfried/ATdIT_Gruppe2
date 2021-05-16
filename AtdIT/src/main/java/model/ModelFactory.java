package main.java.model;

import java.util.ArrayList;
import java.util.Date;

import main.java.persistence.databaseManager.DatabaseManager;
import main.java.persistence.databaseTables.Addresses;
import main.java.persistence.databaseTables.Assignees;
import main.java.persistence.databaseTables.ChangesOfAddresses;
import main.java.persistence.databaseTables.HouseOwners;
import main.java.persistence.databaseTables.HouseProviders;
import main.java.persistence.databaseTables.Identifications;
import main.java.persistence.databaseTables.Persons;
import main.java.persistence.databaseTables.StagesOfCOA;

public class ModelFactory {
	
	private DatabaseManager dbm;
	
	public ModelFactory() {
		this.dbm = new DatabaseManager();
	}
	
	public Address createAddress(String street, int streetNumber, String secondLine, int postcode, String city, String country) {		
		return new Address(street, streetNumber, secondLine, postcode, city, country);
	}

	public Address createAddress(Addresses addressEntry) {
		Address address = new Address();
		address.setCity(addressEntry.getCity());
		address.setCountry(addressEntry.getCountry());
		address.setPostcode(addressEntry.getPostcode());
		address.setSecondLine(addressEntry.getSecondLine());
		address.setStreetNumber(addressEntry.getStreetNumber());
		address.setStreet(addressEntry.getStreet());
		return address;
	}
	
	public Address createAddress(int key) {
		Addresses addressEntry = dbm.getDatabaseEntry(Addresses.class, key);
		return createAddress(addressEntry);
	}
	
	public Assignee createAssignee(String name, String surname, Address address) {
		return new Assignee(name, surname, address);
	}
	
	public Assignee createAssignee(Assignees assigneeEntry) {
		Assignee assignee = new Assignee();
		assignee.setAddress(createAddress(assigneeEntry.getAddress()));
		assignee.setName(assigneeEntry.getName());
		assignee.setSurname(assigneeEntry.getSurname());
		return assignee;
	}
	
	public Assignee createAssignee(int key) {
		Assignees assigneeEntry = dbm.getDatabaseEntry(Assignees.class, key);
		return createAssignee(assigneeEntry);
	}
	
	public ChangeOfAddress createChangeOfAddress(ArrayList<Person> persons, Date moveInDate, Address oldAddress, Address newAddress,
			HouseProvider houseProvider, HouseOwner houseOwner, Assignee assignee) {
		return new ChangeOfAddress(persons, moveInDate, oldAddress, newAddress, houseProvider, houseOwner, assignee);
	}
	
	public ChangeOfAddress createChangeOfAddress(ChangesOfAddresses coaEntry) {
		ChangeOfAddress coa = new ChangeOfAddress();
		coa.setAssignee(createAssignee(coaEntry.getAssignee()));
		coa.setHouseOwner(createHouseOwner(coaEntry.getHouseOwner()));
		coa.setHouseProvider(createHouseProvider(coaEntry.getHouseProvider()));
		coa.setMoveInDate(coaEntry.getMoveInDate());
		coa.setNewAddress(createAddress(coaEntry.getNewAddress()));
		coa.setOldAddress(createAddress(coaEntry.getOldAddress()));
		ArrayList<Person> personList = new ArrayList<Person>();
		for (Persons personEntry : coaEntry.getPersonList()) {
			personList.add(createPerson(personEntry));
		}
		coa.setPersons(personList);
		return coa;
	}

	public ChangeOfAddress createChangeOfAddress(int key) {
		ChangesOfAddresses coaEntry = new ChangesOfAddresses();
		return createChangeOfAddress(coaEntry);
	}
	
	public HouseOwner createHouseOwner(String name, String surname, Address address) {
		return new HouseOwner(name, surname, address);
	}
	
	public HouseOwner createHouseOwner(HouseOwners houseOwnerEntry) {
		HouseOwner houseOwner = new HouseOwner();
		houseOwner.setAddress(createAddress(houseOwnerEntry.getAddress()));
		houseOwner.setName(houseOwnerEntry.getName());
		houseOwner.setSurname(houseOwnerEntry.getSurname());
		return houseOwner;
	}
	
	public HouseOwner createHouseOwner(int key) {
		HouseOwners houseOwnerEntry = dbm.getDatabaseEntry(HouseOwners.class, key);
		return createHouseOwner(houseOwnerEntry);
	}
	
	public HouseProvider createHouseProvide(String name, String surname, Address address) {
		return new HouseProvider(name, surname, address);
	}
	
	public HouseProvider createHouseProvider(HouseProviders houseProviderEntry) {
		HouseProvider houseProvider = new HouseProvider();
		houseProvider.setAddress(createAddress(houseProviderEntry.getAddress()));
		houseProvider.setName(houseProviderEntry.getName());
		houseProvider.setSurname(houseProviderEntry.getSurname());
		return houseProvider;
	}
	
	public HouseProvider createHouseProvider(int key) {
		HouseProviders houseProviderEntry = dbm.getDatabaseEntry(HouseProviders.class, key);
		return createHouseProvider(houseProviderEntry);
	}
	
	public Identification createIdentification(String iDNumber, String issuingAuthority, Date dateOfIssuing, Date expiryDate) {
		return new Identification(iDNumber, issuingAuthority, dateOfIssuing, expiryDate);
	}
	
	public Identification createIdentification(Identifications idEntry) {
		Identification identification = new Identification();
		identification.setDateOfIssuing(idEntry.getDateOfIssuing());
		identification.setExpiryDate(idEntry.getExpiryDate());
		identification.setIssuingAuthority(idEntry.getIssuingAuthority());
		identification.setIDNumber(idEntry.getIDNumber());
		return identification;
	}
	
	public Identification createIdentification(int key) {
		Identifications idEntry = dbm.getDatabaseEntry(Identifications.class, key);
		return createIdentification(idEntry);
	}
	
	public Person createPerson(int key) {
		Persons personEntry = dbm.getDatabaseEntry(Persons.class, key);
		return createPerson(personEntry);
	}
	
	public Person createPerson(String name, String surname, String gender, Address address, Date dateOfBirth, String placeOfBirth,
			String maritalStatus, Date dateOfMarriage, String placeOfMarriage, String citizinship, Identification identification) {
		return new Person(name,surname, gender, address, dateOfBirth, placeOfBirth, maritalStatus, dateOfMarriage, placeOfMarriage,
			citizinship, identification);
	}
	
	public Person createPerson(Persons personEntry) {
		Person person = new Person();
		person.setAddress(createAddress(personEntry.getAddress()));
		person.setCitizinship(personEntry.getCitizenship());
		person.setDateOfBirth(personEntry.getDateOfBirth());
		person.setDateOfMarriage(personEntry.getDateOfMarriage());
		person.setGender(personEntry.getGender());
		person.setIdentification(createIdentification(personEntry.getIdentification()));
		person.setMaritalStatus(personEntry.getMaritalStatus());
		person.setName(personEntry.getName());
		person.setPlaceOfBirth(personEntry.getPlaceOfBirth());
		person.setPlaceOfMarriage(personEntry.getPlacOfMarriage());
		person.setSurname(personEntry.getSurname());
		return null;
	}
	
	public StageOfCOA createStagesOfCOA(Boolean[] stages) {
		return new StageOfCOA(stages); 
	}
	
	public StageOfCOA createStagesOfCOA(StagesOfCOA stagesEntry) {
		StageOfCOA stages = new StageOfCOA();
		Boolean[] stagesList = {stagesEntry.isReceived(), 
								stagesEntry.isDataProcessing(), 
								stagesEntry.isReadyForMeeting()};
		stages.setStages(stagesList);
		return stages;
	}
	
	public StageOfCOA readStagesOfCOAFromDB(int key) {
		StagesOfCOA stagesEntry = dbm.getDatabaseEntry(StagesOfCOA.class, key);
		return createStagesOfCOA(stagesEntry);
	}
}
