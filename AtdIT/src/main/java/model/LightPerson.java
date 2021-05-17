  package main.java.model;
  /**
  * This is the basic concept of a person. getters and setters included
  * @author weilichsoheisse
  * @version 16.05.2021
  *
  */
public class LightPerson {
	private String 	name;
	private String 	surname;
	private Address address;
	
	public LightPerson() {
	}
	
	public LightPerson(String name, String surname, Address address) {
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
