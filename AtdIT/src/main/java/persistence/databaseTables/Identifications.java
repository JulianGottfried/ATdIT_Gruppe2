package main.java.persistence.databaseTables;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* This class is a basic data model for the identifications table. 
* @author weilichsoheisse
* @version 16.05.2021
*
*/

@Entity
@Table(name = "Identifications")
public class Identifications implements AbstractEntry, Serializable {
	@Id
	private String 	IDNumber;
	private String 	IssuingAuthority;
	private Date 	DateOfIssuing;
	private Date 	ExpiryDate;
	
	public Identifications() {
		super();
	}

	public Identifications(String iDNumber, String issuingAuthority, Date dateOfIssuing, Date expiryDate) {
		super();
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
