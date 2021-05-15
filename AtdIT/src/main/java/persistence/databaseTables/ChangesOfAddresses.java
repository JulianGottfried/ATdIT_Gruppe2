package main.java.persistence.databaseTables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "ProcessID")
@Table(name = "ChangesOfAddresses")
public class ChangesOfAddresses extends Processes {
	private int 	PersonID;
	private Date	MoveInDate;
	@ManyToOne
	private Addresses 	OldAddress;
	@ManyToOne
	private Addresses 	NewAddress;
	@ManyToOne
	private HouseOwners HouseOwner;
	@ManyToOne
	private HouseProviders 	HouseProvider;
	private int 	AssigneeID;
	
	public ChangesOfAddresses() {
		super();
	}
	
	public ChangesOfAddresses(int processID, int personID, Date moveInDate, int assigneeID) {
		super(processID);
		PersonID = personID;
		MoveInDate = moveInDate;
		AssigneeID = assigneeID;
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
	
	public Addresses getOldAddress() {
		return OldAddress;
	}
	
	public void setOldAddress(Addresses oldAddress) {
		OldAddress = oldAddress;
	}
	
	public Addresses getNewAddress() {
		return NewAddress;
	}
	
	public void setNewAddress(Addresses newAddress) {
		NewAddress = newAddress;
	}
	
	public HouseOwners getHouseOwner() {
		return HouseOwner;
	}
	
	public void setHouseOwner(HouseOwners houseOwner) {
		HouseOwner = houseOwner;
	}
	
	public HouseProviders getHouseProvider() {
		return HouseProvider;
	}
	
	public void setHouseProvider(HouseProviders houseProvider) {
		HouseProvider = houseProvider;
	}
	
	public int getAssigneeID() {
		return AssigneeID;
	}
	
	public void setAssigneeID(int assigneeID) {
		AssigneeID = assigneeID;
	}
}
