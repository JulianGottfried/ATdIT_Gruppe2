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
	private List<Integer>	PersonList;
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
}
