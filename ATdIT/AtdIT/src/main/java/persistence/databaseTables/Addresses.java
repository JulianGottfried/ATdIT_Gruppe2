package main.java.persistence.databaseTables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * The address table structure.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
@Entity
@Table(name = "Addresses")
public class Addresses implements AbstractEntry, Serializable  {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private int 	AddressID;
	private String	Street;
	private int		StreetNumber;
	private String	SecondLine;
	private int		Postcode;
	private String	City;
	private String	Country;
	
	public Addresses() {
		super();
	}
	
	public Addresses(String street, int streetNumber, String secondLine, int postcode, String city, String country) {
		super();
		Street = street;
		StreetNumber = streetNumber;
		SecondLine = secondLine;
		Postcode = postcode;
		City = city;
		Country = country;
	}

	public int getAddressID() {
		return AddressID;
	}

	public void setAddressID(int addressID) {
		AddressID = addressID;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getStreetNumber() {
		return StreetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		StreetNumber = streetNumber;
	}

	public String getSecondLine() {
		return SecondLine;
	}

	public void setSecondLine(String secondLine) {
		SecondLine = secondLine;
	}

	public int getPostcode() {
		return Postcode;
	}

	public void setPostcode(int postcode) {
		Postcode = postcode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}
}
