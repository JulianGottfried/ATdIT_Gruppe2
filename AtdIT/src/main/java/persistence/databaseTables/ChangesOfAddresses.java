package main.java.persistence.databaseTables;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ChangesOfAddresses")
@PrimaryKeyJoinColumn(referencedColumnName = "ProcessID")
@DiscriminatorValue("ChangesOfAddresses")
public class ChangesOfAddresses extends Processes implements Serializable {
	@OneToMany (targetEntity=Persons.class)
	private List<Persons>	PersonList;
	private Date			MoveInDate;
	@ManyToOne
	private Addresses 		OldAddress;
	@ManyToOne
	private Addresses 		NewAddress;
	@ManyToOne
	private HouseOwners 	HouseOwner;
	@ManyToOne
	private HouseProviders 	HouseProvider;
	@ManyToOne
	private Assignees		Assignee;
	
	public ChangesOfAddresses() {
		super();
	}
	
	public ChangesOfAddresses(Date moveInDate) {
		super();
		MoveInDate = moveInDate;
	}

	public List<Persons> getPersonList() {
		return PersonList;
	}

	public void setPersonList(List<Persons> personList) {
		PersonList = personList;
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

	public Assignees getAssignee() {
		return Assignee;
	}

	public void setAssignee(Assignees assignee) {
		Assignee = assignee;
	}
}
