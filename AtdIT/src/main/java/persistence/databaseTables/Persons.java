package main.java.persistence.databaseTables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Persons")
public class Persons extends AbstractEntry {
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
}