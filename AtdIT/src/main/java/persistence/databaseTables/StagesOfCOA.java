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

	public StagesOfCOA() {
		super();
	}

	public StagesOfCOA(int processID, boolean received, boolean dataProcessing, boolean readyForMeeting) {
		super();
		ProcessID = processID;
		Received = received;
		DataProcessing = dataProcessing;
		ReadyForMeeting = readyForMeeting;
	}

	public int getProcessID() {
		return ProcessID;
	}

	public void setProcessID(int processID) {
		ProcessID = processID;
	}

	public boolean isReceived() {
		return Received;
	}

	public void setReceived(boolean received) {
		Received = received;
	}

	public boolean isDataProcessing() {
		return DataProcessing;
	}

	public void setDataProcessing(boolean dataProcessing) {
		DataProcessing = dataProcessing;
	}

	public boolean isReadyForMeeting() {
		return ReadyForMeeting;
	}

	public void setReadyForMeeting(boolean readyForMeeting) {
		ReadyForMeeting = readyForMeeting;
	}
}
