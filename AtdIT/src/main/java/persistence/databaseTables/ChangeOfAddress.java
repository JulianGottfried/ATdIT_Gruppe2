package main.java.persistence.databaseTables;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ChangeOfAddress")
public class ChangeOfAddress {
	@Id
	int ProcessID;
	int PersonID;
	Date MoveInDate;
	int OldAddressID;
	int NewAddressID;
	int HouseOwnerID;
	int HouseProviderID;
	int AssigneeID;
}
