package main.java.model;
/**
 * Used for house provider creation and change.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class HouseProvider implements Model {
	private String 	name;
	private String 	surname;
	private Address address;
	
	public HouseProvider() {
	}
	
	public HouseProvider(String name, String surname, Address address) {
		this.name = name;
		this.surname = surname;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
