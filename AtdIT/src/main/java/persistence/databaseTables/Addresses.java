package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Addresses")
public class Addresses extends AbstractEntry {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private int 	AddressID;
	private String	Street;
	private int		StreetNumber;
	private String	SecondLine;
	private int		Postcode;
	private String	City;
	private String	Country;
}
