package main.java.persistence.databaseTables;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
* This class is the basic data model for the process table.
* @author weilichsoheisse
* @version 16.05.2021
*
*/

@Entity
@Table(name = "Processes")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Type")
public class Processes implements AbstractEntry, Serializable {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int		ProcessID;

	public Processes() {
		super();
	}

	public Processes(String type) {
		super();
	}

	public int getProcessID() {
		return ProcessID;
	}

	public void setProcessID(int processID) {
		ProcessID = processID;
	}
}
