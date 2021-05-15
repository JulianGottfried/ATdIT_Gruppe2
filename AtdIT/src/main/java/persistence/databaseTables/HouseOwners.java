package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HouseOwners")
public class HouseOwners extends AbstractEntry {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int 	OwnerID;
	private String 	Name;
	private String 	Surname;
	@ManyToOne
	private Addresses AddressID;
	
	public HouseOwners() {
		super();
	}
	
	public HouseOwners(int ownerID, String name, String surname) {
		super();
		OwnerID = ownerID;
		Name = name;
		Surname = surname;
	}
	
	public int getOwnerID() {
		return OwnerID;
	}
	
	public void setOwnerID(int ownerID) {
		OwnerID = ownerID;
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
		return AddressID;
	}
	
	public void setAddress(Addresses address) {
		AddressID = address;
	}
}
