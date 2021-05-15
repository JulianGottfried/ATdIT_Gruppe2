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
	private int 	IDNumber;
	private String 	IssuingAuthority;
	private Date 	DateOfIssuing;
	private Date 	ExpiryDate;
}
