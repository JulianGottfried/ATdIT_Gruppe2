package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HouseProviders")
public class HouseProviders extends AbstractEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ProviderID;
	private String Name;
	private String Surname;
	@ManyToOne
	private Addresses Address;

	public HouseProviders() {
		super();
	}

	public HouseProviders(int providerID, String name, String surname) {
		super();
		ProviderID = providerID;
		Name = name;
		Surname = surname;
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

	public Addresses getAddress() {
		return Address;
	}

	public void setAddress(Addresses address) {
		Address = address;
	}
}
