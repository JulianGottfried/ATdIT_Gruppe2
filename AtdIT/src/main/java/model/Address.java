package main.java.model;
/**
 * Used for address creation and change.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class Address implements Model {
	private String	street;
	private int		streetNumber;
	private String	secondLine;
	private int		postcode;
	private String	city;
	private String	country;
	
	public Address() {
	}
	
	public Address(String street, int streetNumber, String secondLine, int postcode, String city, String country) {
		this.street = street;
		this.streetNumber = streetNumber;
		this.secondLine = secondLine;
		this.postcode = postcode;
		this.city = city;
		this.country = country;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getSecondLine() {
		return secondLine;
	}
	
	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}
	
	public int getPostcode() {
		return postcode;
	}
	
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
}
