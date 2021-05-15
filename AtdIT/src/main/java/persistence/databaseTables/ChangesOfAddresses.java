package main.java.persistence.databaseTables;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ChangesOfAddresses")
@PrimaryKeyJoinColumn(referencedColumnName = "ProcessID")
@DiscriminatorValue("ChangesOfAddresses")
public class ChangesOfAddresses extends Processes {
	@OneToMany (targetEntity=Persons.class)
	private List	PersonList;
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
	@OneToOne
	private StagesOfCOA		Stages;
	
	public ChangesOfAddresses() {
		super();
	}
	
	public ChangesOfAddresses(List personList, Date moveInDate, Addresses oldAddress, Addresses newAddress,
			HouseOwners houseOwner, HouseProviders houseProvider, Assignees assignee, StagesOfCOA stages) {
		super();
		PersonList = personList;
		MoveInDate = moveInDate;
		OldAddress = oldAddress;
		NewAddress = newAddress;
		HouseOwner = houseOwner;
		HouseProvider = houseProvider;
		Assignee = assignee;
		Stages = stages;
	}

	public List getPersonList() {
		return PersonList;
	}

	public void setPersonList(List personList) {
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

	public StagesOfCOA getStages() {
		return Stages;
	}

	public void setStages(StagesOfCOA stages) {
		Stages = stages;
	}
}
