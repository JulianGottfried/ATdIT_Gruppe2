package main.java.persistence.databaseTables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Processes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Processes extends AbstractEntry {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int	ProcessID;
	
	public Processes() {
		super();
	}
	
	public Processes(int processID) {
		super();
		ProcessID = processID;
	}
	
	public int getProcessID() {
		return ProcessID;
	}
	
	public void setProcessID(int processID) {
		ProcessID = processID;
	}
}
