package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assignees")
public class Assignees extends AbstractEntry {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) 
	private int 		AssigneeID;
	private String 		Name;
	private String 		Surname;
	@ManyToOne
	private Addresses 	Address;
}
