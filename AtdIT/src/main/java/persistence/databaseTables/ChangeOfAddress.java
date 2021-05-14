package main.java.persistence.databaseTables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ChangeOfAddress")
public class ChangeOfAddress extends AbstractEntry {
	@Id
	private int 	ProcessID;
	private int 	PersonID;
	private Date	MoveInDate;
	private int 	OldAddressID;
	private int 	NewAddressID;
	private int 	HouseOwnerID;
	private int 	HouseProviderID;
	private int 	AssigneeID;
	
	public ChangeOfAddress() {
	}
	
	public ChangeOfAddress(int processID, int personID, Date moveInDate, int oldAddressID, int newAddressID,
			int houseOwnerID, int houseProviderID, int assigneeID) {
		ProcessID = processID;
		PersonID = personID;
		MoveInDate = moveInDate;
		OldAddressID = oldAddressID;
		NewAddressID = newAddressID;
		HouseOwnerID = houseOwnerID;
		HouseProviderID = houseProviderID;
		AssigneeID = assigneeID;
	}
	
	public int getProcessID() {
		return ProcessID;
	}
	
	public void setProcessID(int processID) {
		ProcessID = processID;
	}
	
	public int getPersonID() {
		return PersonID;
	}
	
	public void setPersonID(int personID) {
		PersonID = personID;
	}
	
	public Date getMoveInDate() {
		return MoveInDate;
	}
	
	public void setMoveInDate(Date moveInDate) {
		MoveInDate = moveInDate;
	}
	
	public int getOldAddressID() {
		return OldAddressID;
	}
	
	public void setOldAddressID(int oldAddressID) {
		OldAddressID = oldAddressID;
	}
	
	public int getNewAddressID() {
		return NewAddressID;
	}
	
	public void setNewAddressID(int newAddressID) {
		NewAddressID = newAddressID;
	}
	
	public int getHouseOwnerID() {
		return HouseOwnerID;
	}
	
	public void setHouseOwnerID(int houseOwnerID) {
		HouseOwnerID = houseOwnerID;
	}
	
	public int getHouseProviderID() {
		return HouseProviderID;
	}
	
	public void setHouseProviderID(int houseProviderID) {
		HouseProviderID = houseProviderID;
	}
	
	public int getAssigneeID() {
		return AssigneeID;
	}
	
	public void setAssigneeID(int assigneeID) {
		AssigneeID = assigneeID;
	}
}
