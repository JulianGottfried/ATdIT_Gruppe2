package main.java.persistence.databaseTables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * The persons table structure.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
@Entity
@Table(name = "Persons")
public class Persons implements AbstractEntry, Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int 			PersonID;
	private String			Name;
	private String			Surname;
	private String			Gender;
	@ManyToOne
	private Addresses		Address;
	private Date			DateOfBirth;
	private String			PlaceOfBirth;
	private String			MaritalStatus;
	private Date			DateOfMarriage;
	private String			PlacOfMarriage;
	private String			Citizenship;
	@OneToOne
	private Identifications	Identification;

	public Persons() {
		super();
	}

	public Persons(String name, String surname, String gender, Date dateOfBirth,
			String placeOfBirth, String maritalStatus, Date dateOfMarriage, String placOfMarriage, String citizenship) {
		super();
		Name = name;
		Surname = surname;
		Gender = gender;
		DateOfBirth = dateOfBirth;
		PlaceOfBirth = placeOfBirth;
		MaritalStatus = maritalStatus;
		DateOfMarriage = dateOfMarriage;
		PlacOfMarriage = placOfMarriage;
		Citizenship = citizenship;
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

	public Addresses getAddress() {
		return Address;
	}

	public void setAddress(Addresses address) {
		Address = address;
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

	public Identifications getIdentification() {
		return Identification;
	}

	public void setIdentification(Identifications identification) {
		Identification = identification;
	}
}