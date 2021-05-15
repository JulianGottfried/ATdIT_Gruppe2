package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StagesOfCOA")
public class StagesOfCOA extends AbstractEntry {
	@Id
	private int		ProcessID;
	private boolean	Received;
	private boolean	DataProcessing;	
	private boolean	ReadyForMeeting;
}
