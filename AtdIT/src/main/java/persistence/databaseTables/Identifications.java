package main.java.persistence.databaseTables;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Identifications")
public class Identifications extends AbstractEntry {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int 	IDNumber;
	private String 	IssuingAuthority;
	private Date 	DateOfIssuing;
	private Date 	ExpiryDate;
	
	public Identifications() {
		super();
	}
	
	public Identifications(int iDNumber, String issuingAuthority, Date dateOfIssuing, Date expiryDate) {
		super();
		IDNumber = iDNumber;
		IssuingAuthority = issuingAuthority;
		DateOfIssuing = dateOfIssuing;
		ExpiryDate = expiryDate;
	}

	public int getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(int iDNumber) {
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
