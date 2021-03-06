package main.java.model;

import java.util.Date;
/**
 * Used for identification creation and change.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
public class Identification implements Model {
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
