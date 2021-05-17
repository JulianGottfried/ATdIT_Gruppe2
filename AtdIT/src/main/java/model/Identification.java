package main.java.model;

import java.util.Date;
/**
* This class is used for identification data model. Getters and setters included.
* @author weilichsoheisse
* @version 16.05.2021
*
*/
public class Identification {
	private String 	IDNumber;
	private String 	IssuingAuthority;
	private Date 	DateOfIssuing;
	private Date 	ExpiryDate;
	
	public Identification() {
	}
	
	public Identification(String iDNumber, String issuingAuthority, Date dateOfIssuing, Date expiryDate) {
		IDNumber = iDNumber;
		IssuingAuthority = issuingAuthority;
		DateOfIssuing = dateOfIssuing;
		ExpiryDate = expiryDate;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getIssuingAuthority() {
		return IssuingAuthority;
	}

	public void setIssuingAuthority(String issuingAuthority) {
		IssuingAuthority = issuingAuthority;
	}

	public Date getDateOfIssuing() {
		return DateOfIssuing;
	}

	public void setDateOfIssuing(Date dateOfIssuing) {
		DateOfIssuing = dateOfIssuing;
	}

	public Date getExpiryDate() {
		return ExpiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		ExpiryDate = expiryDate;
	}
}
