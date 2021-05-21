package main.java.model;

import main.java.persistence.databaseTables.ChangesOfAddresses;
import main.java.persistence.databaseTables.StagesOfCOA;

public class StageOfCOA implements Model {
	private ChangesOfAddresses changesOfAddresses;
	private boolean received;
	private boolean dataProcessing;
	private boolean readyForMeeting;
	
	public StageOfCOA() {
	}

	public StageOfCOA(Boolean received, boolean dataProcessing, boolean readyForMeeting) {
		this.received = received;
		this.dataProcessing = dataProcessing;
		this.readyForMeeting = readyForMeeting;
	}

	public ChangesOfAddresses getChangesOfAddresses() {
		return changesOfAddresses;
	}

	public void setChangesOfAddresses(ChangesOfAddresses changesOfAddresses) {
		this.changesOfAddresses = changesOfAddresses;
	}

	public boolean getReceived() {
		return received;
	}

	public void setReceived(Boolean received) {
		this.received = received;
	}

	public boolean getDataProcessing() {
		return dataProcessing;
	}

	public void setDataProcessing(Boolean dataProcessing) {
		this.dataProcessing = dataProcessing;
	}

	public boolean getReadyForMeeting() {
		return readyForMeeting;
	}

	public void setReadyForMeeting(Boolean readyForMeeting) {
		this.readyForMeeting = readyForMeeting;
	}
}
