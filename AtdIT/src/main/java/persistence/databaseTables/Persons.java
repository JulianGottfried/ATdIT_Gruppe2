package main.java.persistence.databaseTables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Persons")
public class Persons extends AbstractEntry {
	@Id
	private int 	PersonID;
	private String	Name;
	private String	Surname;
	private String	Gender;
	private int		AddressID;
	private Date	DateOfBirth;
	private String	PlaceOfBirth;
	private String	MaritalStatus;
	private Date	DateOfMarriage;
	private String	PlacOfMarriage;
	private String	Citizenship;
	private String	IDNumber;
	
	public Persons() {
	}
	
	public Persons(int personID, String name, String surname, String gender, int address, Date dateOfBirth,
			String placeOfBirth, String maritalStatus, Date dateOfMarriage, String placOfMarriage, String citizenship,
			String iDNumber) {
		PersonID = personID;
		Name = name;
		Surname = surname;
		Gender = gender;
		AddressID = address;
		DateOfBirth = dateOfBirth;
		PlaceOfBirth = placeOfBirth;
		MaritalStatus = maritalStatus;
		DateOfMarriage = dateOfMarriage;
		PlacOfMarriage = placOfMarriage;
		Citizenship = citizenship;
		IDNumber = iDNumber;
	}
	
	public int getPersonID() {
		return PersonID;
	}
	
	public void setPersonID(int personID) {
		PersonID = personID;
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
	
	public String getGender() {
		return Gender;
	}
	
	public void setGender(String gender) {
		Gender = gender;
	}
	
	public int getAddressID() {
		return AddressID;
	}
	
	public void setAddressID(int addressID) {
		AddressID = addressID;
	}
	
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	
	public String getPlaceOfBirth() {
		return PlaceOfBirth;
	}
	
	public void setPlaceOfBirth(String placeOfBirth) {
		PlaceOfBirth = placeOfBirth;
	}
	
	public String getMaritalStatus() {
		return MaritalStatus;
	}
	
	public void setMaritalStatus(String maritalStatus) {
		MaritalStatus = maritalStatus;
	}
	
	public Date getDateOfMarriage() {
		return DateOfMarriage;
	}
	
	public void setDateOfMarriage(Date dateOfMarriage) {
		DateOfMarriage = dateOfMarriage;
	}
	
	public String getPlacOfMarriage() {
		return PlacOfMarriage;
	}
	
	public void setPlacOfMarriage(String placOfMarriage) {
		PlacOfMarriage = placOfMarriage;
	}
	
	public String getCitizenship() {
		return Citizenship;
	}
	
	public void setCitizenship(String citizenship) {
		Citizenship = citizenship;
	}
	
	public String getIDNumber() {
		return IDNumber;
	}
	
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
}