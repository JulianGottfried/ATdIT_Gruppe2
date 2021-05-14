package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HouseProviders")
public class HouseProviders extends AbstractEntry {
	@Id
	private int 	ProviderID;
	private String 	Name;
	private String 	Surname;
	private int 	AddressID;
	
	public HouseProviders() {
	}
	
	public HouseProviders(int providerID, String name, String surname, int addressID) {
		ProviderID = providerID;
		Name = name;
		Surname = surname;
		AddressID = addressID;
	}
	
	public int getProviderID() {
		return ProviderID;
	}
	
	public void setProviderID(int ownerID) {
		ProviderID = ownerID;
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
	
	public int getAddressID() {
		return AddressID;
	}
	
	public void setAddressID(int addressID) {
		AddressID = addressID;
	}
}
