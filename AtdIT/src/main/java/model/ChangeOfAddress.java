package main.java.model;

import java.util.Date;
/**
 * Used for coa creation and change.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class ChangeOfAddress implements Model {
	private int 			processID;
	private Person			person;
	private Date			moveInDate;
	private Address			oldAddress;
	private Address			newAddress;
	private HouseProvider	houseProvider;
	private HouseOwner		houseOwner;
	private Assignee		assignee;
	
	public ChangeOfAddress() {
	}
	
	public ChangeOfAddress(Person person, Date moveInDate, Address oldAddress, Address newAddress,
			HouseProvider houseProvider, HouseOwner houseOwner, Assignee assignee) {
		this.person = person;
		this.moveInDate = moveInDate;
		this.oldAddress = oldAddress;
		this.newAddress = newAddress;
		this.houseProvider = houseProvider;
		this.houseOwner = houseOwner;
		this.assignee = assignee;
	}
	
	public int getProcessID() {
		return processID;
	}

	public void setProcessID(int processID) {
		this.processID = processID;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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
