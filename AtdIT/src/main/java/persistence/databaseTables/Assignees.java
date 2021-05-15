package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assignees")
public class Assignees extends AbstractEntry {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private int 		AssigneeID;
	private String 		Name;
	private String 		Surname;
	@ManyToOne
	private Addresses 	Address;
	
	public Assignees() {
		super();
	}
	
	public Assignees(String name, String surname, Addresses address) {
		super();
		Name = name;
		Surname = surname;
		Address = address;
	}

	public int getAssigneeID() {
		return AssigneeID;
	}

	public void setAssigneeID(int assigneeID) {
		AssigneeID = assigneeID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public Addresses getAddress() {
		return Address;
	}

	public void setAddress(Addresses address) {
		Address = address;
	}
}
