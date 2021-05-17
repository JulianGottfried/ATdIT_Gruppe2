package main.java.persistence.databaseTables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* This class is a basic data model for the house providers table. 
* @author weilichsoheisse
* @version 16.05.2021
*
*/

@Entity
@Table(name = "HouseProviders")
public class HouseProviders implements AbstractEntry, Serializable {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int ProviderID;
	private String Name;
	private String Surname;
	@ManyToOne
	private Addresses Address;
	
	public HouseProviders() {
		super();
	}
	
	public HouseProviders(String name, String surname) {
		super();
		Name = name;
		Surname = surname;
	}

	public int getProviderID() {
		return ProviderID;
	}

	public void setProviderID(int providerID) {
		ProviderID = providerID;
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
