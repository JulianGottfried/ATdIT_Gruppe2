package main.java.model;

import java.lang.reflect.Field;
import java.util.Date;

import javax.persistence.RollbackException;

import org.json.simple.JSONObject;

import main.java.controller.exceptions.DBSavingException;
import main.java.controller.handler.JSONHandler;
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

	private JSONHandler jsonHandler;
	
	public ModelFactory() {
		this.dbm = new DatabaseManager();
		this.jsonHandler = new JSONHandler();
	}
		
	public Address createAddress(String street, int streetNumber, String secondLine, int postcode, String city, String country) {		
		return new Address(street, streetNumber, secondLine, postcode, city, country);
	}
	
	public Address createAddress(JSONObject jsonObject) {
		return new Address(
				this.jsonHandler.getString(jsonObject, "street"),
				this.jsonHandler.getInt(jsonObject, "streetNumber"),
				this.jsonHandler.getString(jsonObject, "secondLine"),
				this.jsonHandler.getInt(jsonObject, "postcode"),
				this.jsonHandler.getString(jsonObject, "city"),
				this.jsonHandler.getString(jsonObject, "country")
				);
	}

	public Address createAddress(Addresses addressesEntry) {
		Address address = new Address();
		if (addressesEntry != null) {
			address.setCity(addressesEntry.getCity());
			address.setCountry(addressesEntry.getCountry());
			address.setPostcode(addressesEntry.getPostcode());
			address.setSecondLine(addressesEntry.getSecondLine());
			address.setStreetNumber(addressesEntry.getStreetNumber());
			address.setStreet(addressesEntry.getStreet());
		}
		return address;
	}
	
	public Address createAddress(int key) {
		Addresses addressesEntry = dbm.getDatabaseEntry(Addresses.class, key);
		return createAddress(addressesEntry);
	}
	
	public Addresses saveAddressToDB(Address addressModel) throws DBSavingException {
		Addresses addressesEntry = new Addresses(
				addressModel.getStreet(),
				addressModel.getStreetNumber(),
				addressModel.getSecondLine(),
				addressModel.getPostcode(),
				addressModel.getCity(),
				addressModel.getCountry()
				);
		if (this.dbm.setDatabaseEntry(addressesEntry)) {
			return addressesEntry;
		} else {
			throw new DBSavingException(Address.class.getSimpleName());
		}
		
	}
	
	public Assignee createAssignee(String name, String surname, Address address) {
		return new Assignee(name, surname, address);
	}
	
	public Assignee createAssignee(JSONObject jsonObject) {
		return new Assignee(
				this.jsonHandler.getString(jsonObject, "name"),
				this.jsonHandler.getString(jsonObject, "surname"),
				this.createAddress(this.jsonHandler.getJSON(jsonObject, "address"))
				);
	}
	
	public Assignee createAssignee(Assignees assigneesEntry) {
		Assignee assignee = new Assignee();
		if (assigneesEntry != null) {
			assignee.setAddress(createAddress(assigneesEntry.getAddress()));
			assignee.setName(assigneesEntry.getName());
			assignee.setSurname(assigneesEntry.getSurname());
		}
		return assignee;
	}
	
	public Assignee createAssignee(int key) {
		Assignees assigneesEntry = dbm.getDatabaseEntry(Assignees.class, key);
		return createAssignee(assigneesEntry);
	}
	
	public Assignees saveAssigneeToDB(Assignee assigneeModel) throws DBSavingException {
		Assignees asssigneesEntry = new Assignees(
				assigneeModel.getName(),
				assigneeModel.getSurname()
				);
		Addresses addressesEntry = this.saveAddressToDB(assigneeModel.getAddress());
		asssigneesEntry.setAddress(addressesEntry);
		if (this.dbm.setDatabaseEntry(asssigneesEntry)) {
			return asssigneesEntry;
		} else {
			throw new DBSavingException(Assignee.class.getSimpleName());
		}
	}
	
	public ChangeOfAddress createChangeOfAddress(Person person, Date moveInDate, Address oldAddress, Address newAddress,
			HouseProvider houseProvider, HouseOwner houseOwner, Assignee assignee) {
		return new ChangeOfAddress(person, moveInDate, oldAddress, newAddress, houseProvider, houseOwner, assignee);
	}
	
	public ChangeOfAddress createChangeOfAddress(JSONObject jsonObject) {
		return new ChangeOfAddress(
				this.createPerson(this.jsonHandler.getJSON(jsonObject, "person")),
				this.jsonHandler.getDate(jsonObject, "moveInDate"),
				this.createAddress(this.jsonHandler.getJSON(jsonObject, "oldAddress")),
				this.createAddress(this.jsonHandler.getJSON(jsonObject, "newAddress")),
				this.createHouseProvider(this.jsonHandler.getJSON(jsonObject, "houseProvider")),
				this.createHouseOwner(this.jsonHandler.getJSON(jsonObject, "houseOwner")),
				this.createAssignee(this.jsonHandler.getJSON(jsonObject, "assignee"))
				);
	}
	
	public ChangeOfAddress createChangeOfAddress(ChangesOfAddresses coaEntry) {
		ChangeOfAddress coa = new ChangeOfAddress();
		if (coaEntry != null) {
			coa.setProcessID(coaEntry.getProcessID());
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
	
	public ChangeOfAddress saveChangeOfAddressToDB(ChangeOfAddress coaModel) throws DBSavingException {
		ChangesOfAddresses coaEntry = new ChangesOfAddresses(
				coaModel.getMoveInDate()
				);
		Persons personsEntry = this.savePersonToDB(coaModel.getPerson());
		coaEntry.setPerson(personsEntry);
		Addresses oldAddressesEntry = this.saveAddressToDB(coaModel.getOldAddress());
		coaEntry.setOldAddress(oldAddressesEntry);
		Addresses newAddressesEntry = this.saveAddressToDB(coaModel.getNewAddress());
		coaEntry.setOldAddress(newAddressesEntry);
		HouseOwners houseOwnersEntry = this.saveHouseOwnerToDB(coaModel.getHouseOwner());
		coaEntry.setHouseOwner(houseOwnersEntry);
		HouseProviders houseProvidersEntry = this.saveHouseProviderToDB(coaModel.getHouseProvider());
		coaEntry.setHouseProvider(houseProvidersEntry);
		Assignees assigneesEntry = this.saveAssigneeToDB(coaModel.getAssignee());
		coaEntry.setAssignee(assigneesEntry);
		if (this.dbm.setDatabaseEntry(coaEntry)) {
			StageOfCOA stageOfCOA = this.createStageOfCOA(true, false, false);
			stageOfCOA.setChangesOfAddresses(coaEntry);
			this.saveStageOfCOAToDB(stageOfCOA);
			return this.createChangeOfAddress(coaEntry);
		} else {
			throw new DBSavingException(ChangeOfAddress.class.getSimpleName());
		}
	}
	
	public HouseOwner createHouseOwner(String name, String surname, Address address) {
		return new HouseOwner(name, surname, address);
	}
	
	public HouseOwner createHouseOwner(JSONObject jsonObject) {
		return new HouseOwner(
				this.jsonHandler.getString(jsonObject, "name"),
				this.jsonHandler.getString(jsonObject, "surname"),
				this.createAddress(this.jsonHandler.getJSON(jsonObject, "address"))
				);
	}
	
	public HouseOwner createHouseOwner(HouseOwners houseOwnersEntry) {
		HouseOwner houseOwner = new HouseOwner();
		if (houseOwnersEntry != null) {
			houseOwner.setAddress(createAddress(houseOwnersEntry.getAddress()));
			houseOwner.setName(houseOwnersEntry.getName());
			houseOwner.setSurname(houseOwnersEntry.getSurname());
		}
		return houseOwner;
	}
	
	public HouseOwner createHouseOwner(int key) {
		HouseOwners houseOwnersEntry = dbm.getDatabaseEntry(HouseOwners.class, key);
		return createHouseOwner(houseOwnersEntry);
	}
	
	public HouseOwners saveHouseOwnerToDB(HouseOwner houseOwnerModel) throws DBSavingException {
		HouseOwners houseOwnersEntry = new HouseOwners(
				houseOwnerModel.getName(),
				houseOwnerModel.getSurname()
				);
		Addresses addressesEntry = this.saveAddressToDB(houseOwnerModel.getAddress());
		houseOwnersEntry.setAddress(addressesEntry);
		if (this.dbm.setDatabaseEntry(houseOwnersEntry)) {
			return houseOwnersEntry;
		} else {
			throw new DBSavingException(HouseOwner.class.getSimpleName());
		}	
	}
	
	public HouseProvider createHouseProvide(String name, String surname, Address address) {
		return new HouseProvider(name, surname, address);
	}
	
	public HouseProvider createHouseProvider(JSONObject jsonObject) {
		return new HouseProvider(
				this.jsonHandler.getString(jsonObject, "name"),
				this.jsonHandler.getString(jsonObject, "surname"),
				this.createAddress(this.jsonHandler.getJSON(jsonObject, "address"))
				);
	}
	
	public HouseProvider createHouseProvider(HouseProviders houseProvidersEntry) {
		HouseProvider houseProvider = new HouseProvider();
		if (houseProvidersEntry != null) {
			houseProvider.setAddress(createAddress(houseProvidersEntry.getAddress()));
			houseProvider.setName(houseProvidersEntry.getName());
			houseProvider.setSurname(houseProvidersEntry.getSurname());
		}
		return houseProvider;
	}
	
	public HouseProvider createHouseProvider(int key) {
		HouseProviders houseProvidersEntry = dbm.getDatabaseEntry(HouseProviders.class, key);
		return createHouseProvider(houseProvidersEntry);
	}
	
	public HouseProviders saveHouseProviderToDB(HouseProvider houseProviderModel) throws DBSavingException {
		HouseProviders houseProvidersEntry = new HouseProviders(
				houseProviderModel.getName(),
				houseProviderModel.getSurname()
				);
		Addresses addressesEntry = this.saveAddressToDB(houseProviderModel.getAddress());
		houseProvidersEntry.setAddress(addressesEntry);
		if (this.dbm.setDatabaseEntry(houseProvidersEntry)) {
			return houseProvidersEntry;
		} else {
			throw new DBSavingException(HouseProvider.class.getSimpleName());
		}
		
	}
	
	public Identification createIdentification(String iDNumber, String issuingAuthority, Date dateOfIssuing, Date expiryDate) {
		return new Identification(iDNumber, issuingAuthority, dateOfIssuing, expiryDate);
	}
	
	public Identification createIdentification(JSONObject jsonObject) {
		return new Identification(
				this.jsonHandler.getString(jsonObject, "IDNumber"),
				this.jsonHandler.getString(jsonObject, "issuingAuthority"),
				this.jsonHandler.getDate(jsonObject, "dateOfIssuing"),
				this.jsonHandler.getDate(jsonObject, "expiryDate")
				);
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
	
	public Identifications saveIdentificationToDB(Identification identificationModel) throws DBSavingException {
		Identifications identificationsEntry = new Identifications(
				identificationModel.getIDNumber(),
				identificationModel.getIssuingAuthority(),
				identificationModel.getDateOfIssuing(),
				identificationModel.getExpiryDate()
				);
		
		// Update Identification if already present
		try {
			if (!this.dbm.setDatabaseEntry(identificationsEntry)) {
				throw new DBSavingException(Identification.class.getSimpleName());
			}
		} catch (RollbackException re) {
			if (!this.dbm.updateDatabaseEntry(identificationsEntry)) {
				throw new DBSavingException(Identification.class.getSimpleName());
			}
		}
		
		return identificationsEntry;
	}
	
	public Person createPerson(String name, String surname, String gender, Address address, Date dateOfBirth, String placeOfBirth,
			String maritalStatus, Date dateOfMarriage, String placeOfMarriage, String citizinship, Identification identification) {
		return new Person(name,surname, gender, address, dateOfBirth, placeOfBirth, maritalStatus, dateOfMarriage, placeOfMarriage,
			citizinship, identification);
	}
	
	public Person createPerson(JSONObject jsonObject) {
		return new Person(
				this.jsonHandler.getString(jsonObject, "name"),
				this.jsonHandler.getString(jsonObject, "surname"),
				this.jsonHandler.getString(jsonObject, "gender"),
				this.createAddress(this.jsonHandler.getJSON(jsonObject, "address")),
				this.jsonHandler.getDate(jsonObject, "dateOfBirth"),
				this.jsonHandler.getString(jsonObject, "placeOfBirth"),
				this.jsonHandler.getString(jsonObject, "maritalStatus"),
				this.jsonHandler.getDate(jsonObject, "dateOfMarriage"),
				this.jsonHandler.getString(jsonObject, "placeOfMarriage"),
				this.jsonHandler.getString(jsonObject, "citizinship"),
				this.createIdentification(this.jsonHandler.getJSON(jsonObject, "identification"))
				);
	}
	
	public Person createPerson(Persons personsEntry) {
		Person person = new Person();
		if (personsEntry != null) {
			person.setAddress(createAddress(personsEntry.getAddress()));
			person.setCitizinship(personsEntry.getCitizenship());
			person.setDateOfBirth(personsEntry.getDateOfBirth());
			person.setDateOfMarriage(personsEntry.getDateOfMarriage());
			person.setGender(personsEntry.getGender());
			person.setIdentification(createIdentification(personsEntry.getIdentification()));
			person.setMaritalStatus(personsEntry.getMaritalStatus());
			person.setName(personsEntry.getName());
			person.setPlaceOfBirth(personsEntry.getPlaceOfBirth());
			person.setPlaceOfMarriage(personsEntry.getPlacOfMarriage());
			person.setSurname(personsEntry.getSurname());
		}
		return person;
	}
	
	public Person createPerson(int key) {
		Persons personsEntry = dbm.getDatabaseEntry(Persons.class, key);
		return createPerson(personsEntry);
	}
	
	public Persons savePersonToDB(Person personModel) throws DBSavingException {
		Persons personsEntry = new Persons(
				personModel.getName(),
				personModel.getSurname(),
				personModel.getGender(),
				personModel.getDateOfBirth(),
				personModel.getPlaceOfBirth(),
				personModel.getMaritalStatus(),
				personModel.getDateOfMarriage(),
				personModel.getPlaceOfMarriage(),
				personModel.getCitizinship()
				);
		Addresses addressesEntry = this.saveAddressToDB(personModel.getAddress());
		personsEntry.setAddress(addressesEntry);
		Identifications identificationsEntry = this.saveIdentificationToDB(personModel.getIdentification());
		personsEntry.setIdentification(identificationsEntry);
		if (this.dbm.setDatabaseEntry(personsEntry)) {
			return personsEntry;
		} else {
			throw new DBSavingException(Person.class.getSimpleName());
		}
	}
	
	public StageOfCOA createStageOfCOA(Boolean received, boolean dataProcessing, boolean readyForMeeting) {
		return new StageOfCOA(received, dataProcessing, readyForMeeting);
	}
	
	public StageOfCOA createStageOfCOA(StagesOfCOA stagesEntry) {
		StageOfCOA stageOfCOA = new StageOfCOA();
		if (stagesEntry != null) {
			stageOfCOA.setReceived(stagesEntry.getReceived());
			stageOfCOA.setDataProcessing(stagesEntry.getDataProcessing());
			stageOfCOA.setReadyForMeeting(stagesEntry.getReadyForMeeting());
		}
		return stageOfCOA;
	}
	
	public StageOfCOA createStageOfCOA(int key) {
		StagesOfCOA stagesEntry = dbm.getDatabaseEntry(StagesOfCOA.class, key);
		return createStageOfCOA(stagesEntry);
	}
	
	public StagesOfCOA saveStageOfCOAToDB(StageOfCOA stagesModel) throws DBSavingException {
		StagesOfCOA stagesEntry = new StagesOfCOA(
				stagesModel.getChangesOfAddresses(),
				stagesModel.getReceived(),
				stagesModel.getDataProcessing(),
				stagesModel.getReadyForMeeting()
				);
		if (this.dbm.setDatabaseEntry(stagesEntry)) {
			return stagesEntry;
		} else {
			throw new DBSavingException(StageOfCOA.class.getSimpleName());
		}
		
	}
	
	public JSONObject modelToJSON(Class model) {
		JSONObject json = new JSONObject();
		Field[] fields = model.getDeclaredFields();
		for (Field field: fields) {
			JSONObject value = null;
			try {
				Class<?> fieldClass = Class.forName(field.getType().getName());
				
				if (Model.class.isAssignableFrom(fieldClass)) {
					value = modelToJSON(fieldClass);
				};
			} catch (ClassNotFoundException cnfe) {
				// TODO logger
			}

			json.put(field.getName(), value);
		}
		return json;
	}
}
