package main.java.model;

import java.util.ArrayList;
import java.util.Date;
/**
 * This class changes the address. getters and setters included.
 * @author weilichsoheisse
 * @version 16.05.2021
 *
 */
public class ChangeOfAddress {
	private ArrayList<Person>	persons;
	private Date			moveInDate;
	private Address			oldAddress;
	private Address			newAddress;
	private HouseProvider	houseProvider;
	private HouseOwner		houseOwner;
	private Assignee		assignee;
	
	public ChangeOfAddress() {
	}
	
	public ChangeOfAddress(ArrayList<Person> persons, Date moveInDate, Address oldAddress, Address newAddress,
			HouseProvider houseProvider, HouseOwner houseOwner, Assignee assignee) {
		this.persons = persons;
		this.moveInDate = moveInDate;
		this.oldAddress = oldAddress;
		this.newAddress = newAddress;
		this.houseProvider = houseProvider;
		this.houseOwner = houseOwner;
		this.assignee = assignee;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}

	public void setPersons(ArrayList<Person> persons) {
		this.persons = persons;
	}

	public Date getMoveInDate() {
		return moveInDate;
	}

	public void setMoveInDate(Date moveInDate) {
		this.moveInDate = moveInDate;
	}

	public Address getOldAddress() {
		return oldAddress;
	}

	public void setOldAddress(Address oldAddress) {
		this.oldAddress = oldAddress;
	}

	public Address getNewAddress() {
		return newAddress;
	}

	public void setNewAddress(Address newAddress) {
		this.newAddress = newAddress;
	}

	public HouseProvider getHouseProvider() {
		return houseProvider;
	}

	public void setHouseProvider(HouseProvider houseProvider) {
		this.houseProvider = houseProvider;
	}

	public HouseOwner getHouseOwner() {
		return houseOwner;
	}

	public void setHouseOwner(HouseOwner houseOwner) {
		this.houseOwner = houseOwner;
	}

	public Assignee getAssignee() {
		return assignee;
	}

	public void setAssignee(Assignee assignee) {
		this.assignee = assignee;
	}
}
