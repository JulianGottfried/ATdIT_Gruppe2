package main.java.model;

import java.util.Date;

public class Person implements Model {
	private String			name;
	private String			surname;
	private String			gender;
	private Address 		address;
	private Date			dateOfBirth;
	private String			placeOfBirth;
	private String			maritalStatus;
	private Date			dateOfMarriage;
	private String			placeOfMarriage;
	private String			citizinship;
	private Identification 	identification;
	
	public Person() {
	}
	
	public Person(String name, String surname, String gender, Address address, Date dateOfBirth, String placeOfBirth,
			String maritalStatus, Date dateOfMarriage, String placeOfMarriage, String citizinship, Identification identification) {
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.placeOfBirth = placeOfBirth;
		this.maritalStatus = maritalStatus;
		this.dateOfMarriage = dateOfMarriage;
		this.placeOfMarriage = placeOfMarriage;
		this.citizinship = citizinship;
		this.identification = identification;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Date getDateOfMarriage() {
		return dateOfMarriage;
	}

	public void setDateOfMarriage(Date dateOfMarriage) {
		this.dateOfMarriage = dateOfMarriage;
	}

	public String getPlaceOfMarriage() {
		return placeOfMarriage;
	}

	public void setPlaceOfMarriage(String placeOfMarriage) {
		this.placeOfMarriage = placeOfMarriage;
	}

	public String getCitizinship() {
		return citizinship;
	}

	public void setCitizinship(String citizinship) {
		this.citizinship = citizinship;
	}
	
	public Identification getIdentification() {
		return identification;
	}

	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
}
