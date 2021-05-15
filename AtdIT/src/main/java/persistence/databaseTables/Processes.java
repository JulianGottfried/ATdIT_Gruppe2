package main.java.persistence.databaseTables;

import javax.persistence.DiscriminatorColumn;
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
@DiscriminatorColumn(name = "Type")
public class Processes extends AbstractEntry {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int		ProcessID;
	private String	Type;

	public Processes() {
		super();
	}

	public Processes(int processID, String type) {
		super();
		ProcessID = processID;
		Type = type;
	}

	public int getProcessID() {
		return ProcessID;
	}

	public void setProcessID(int processID) {
		ProcessID = processID;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}
}
