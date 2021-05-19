package main.java.model;

import java.lang.reflect.Field;
import java.util.Date;

import javax.lang.model.SourceVersion;

import org.hibernate.mapping.Subclass;
import org.json.simple.JSONObject;

import main.java.persistence.databaseManager.DatabaseManager;
import main.java.persistence.databaseTables.Addresses;
import main.java.persistence.databaseTables.Assignees;
import main.java.persistence.databaseTables.ChangesOfAddresses;
import main.java.persistence.databaseTables.HouseOwners;
import main.java.persistence.databaseTables.HouseProviders;
import main.java.persistence.databaseTables.Identifications;
import main.java.persistence.databaseTables.Persons;
import main.java.persistence.databaseTables.StagesOfCOA;
import net.bytebuddy.implementation.bind.annotation.Super;

public class ModelFactory {
	
	private DatabaseManager dbm;
	
	public ModelFactory() {
		this.dbm = new DatabaseManager();
	}
	
	public Model createModelFromKeyWord(String keyword) {
		switch (keyword.toLowerCase()) {
		case "address":
		}
		return null;
	}
	

	
	public Address createAddress(String street, int streetNumber, String secondLine, int postcode, String city, String country) {		
		return new Address(street, streetNumber, secondLine, postcode, city, country);
	}

	public Address createAddress(Addresses addressEntry) {
		Address address = new Address();
		if (addressEntry != null) {
			address.setCity(addressEntry.getCity());
			address.setCountry(addressEntry.getCountry());
			address.setPostcode(addressEntry.getPostcode());
			address.setSecondLine(addressEntry.getSecondLine());
			address.setStreetNumber(addressEntry.getStreetNumber());
			address.setStreet(addressEntry.getStreet());
		}
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
		if (assigneeEntry != null) {
			assignee.setAddress(createAddress(assigneeEntry.getAddress()));
			assignee.setName(assigneeEntry.getName());
			assignee.setSurname(assigneeEntry.getSurname());
		}
		return assignee;
	}
	
	public Assignee createAssignee(int key) {
		Assignees assigneeEntry = dbm.getDatabaseEntry(Assignees.class, key);
		return createAssignee(assigneeEntry);
	}
	
	public ChangeOfAddress createChangeOfAddress(Person person, Date moveInDate, Address oldAddress, Address newAddress,
			HouseProvider houseProvider, HouseOwner houseOwner, Assignee assignee) {
		return new ChangeOfAddress(person, moveInDate, oldAddress, newAddress, houseProvider, houseOwner, assignee);
	}
	
	public ChangeOfAddress createChangeOfAddress(ChangesOfAddresses coaEntry) {
		ChangeOfAddress coa = new ChangeOfAddress();
		if (coaEntry != null) {
			coa.setAssignee(createAssignee(coaEntry.getAssignee()));
			coa.setHouseOwner(createHouseOwner(coaEntry.getHouseOwner()));
			coa.setHouseProvider(createHouseProvider(coaEntry.getHouseProvider()));
			coa.setMoveInDate(coaEntry.getMoveInDate());
			coa.setNewAddress(createAddress(coaEntry.getNewAddress()));
			coa.setOldAddress(createAddress(coaEntry.getOldAddress()));
			coa.setPerson(createPerson(coaEntry.getPerson()));
		}
		return coa;
	}

	public ChangeOfAddress createChangeOfAddress(int key) {
		ChangesOfAddresses coaEntry = dbm.getDatabaseEntry(ChangesOfAddresses.class, key);
		return createChangeOfAddress(coaEntry);
	}
	
	public HouseOwner createHouseOwner(String name, String surname, Address address) {
		return new HouseOwner(name, surname, address);
	}
	
	public HouseOwner createHouseOwner(HouseOwners houseOwnerEntry) {
		HouseOwner houseOwner = new HouseOwner();
		if (houseOwnerEntry != null) {
			houseOwner.setAddress(createAddress(houseOwnerEntry.getAddress()));
			houseOwner.setName(houseOwnerEntry.getName());
			houseOwner.setSurname(houseOwnerEntry.getSurname());
		}
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
		if (houseProviderEntry != null) {
			houseProvider.setAddress(createAddress(houseProviderEntry.getAddress()));
			houseProvider.setName(houseProviderEntry.getName());
			houseProvider.setSurname(houseProviderEntry.getSurname());
		}
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
		if (idEntry != null) {
			identification.setDateOfIssuing(idEntry.getDateOfIssuing());
			identification.setExpiryDate(idEntry.getExpiryDate());
			identification.setIssuingAuthority(idEntry.getIssuingAuthority());
			identification.setIDNumber(idEntry.getIDNumber());
		}
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
		if (personEntry != null) {
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
		}
		return person;
	}
	
	public StageOfCOA createStagesOfCOA(Boolean[] stages) {
		return new StageOfCOA(stages); 
	}
	
	public StageOfCOA createStagesOfCOA(StagesOfCOA stagesEntry) {
		StageOfCOA stages = new StageOfCOA();
		if (stagesEntry != null) {
			Boolean[] stagesList = {stagesEntry.isReceived(), 
									stagesEntry.isDataProcessing(), 
									stagesEntry.isReadyForMeeting()};
			stages.setStages(stagesList);
		}
		return stages;
	}
	
	public StageOfCOA createStagesOfCOA(int key) {
		StagesOfCOA stagesEntry = dbm.getDatabaseEntry(StagesOfCOA.class, key);
		return createStagesOfCOA(stagesEntry);
	}
	
	public JSONObject turnToJSON(Class model) {
		JSONObject json = new JSONObject();
		Field[] fields = model.getDeclaredFields();
		for (Field field: fields) {
			JSONObject value = null;
			try {
				Class<?> fieldClass = Class.forName(field.getType().getName());
				
				if (Model.class.isAssignableFrom(fieldClass)) {
					value = turnToJSON(fieldClass);
				};
			} catch (ClassNotFoundException e) {
				// TODO logger
			}

			json.put(field.getName(), value);
		}
		return json;
	}
}
