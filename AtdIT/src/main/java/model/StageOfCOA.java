package main.java.model;

import main.java.persistence.databaseTables.ChangesOfAddresses;
import main.java.persistence.databaseTables.StagesOfCOA;

public class StageOfCOA implements Model {
	private ChangesOfAddresses changesOfAddresses;
	private Boolean received;
	private Boolean dataProcessing;
	private Boolean readyForMeeting;
	
	public StageOfCOA() {
	}

	public StageOfCOA(Boolean received, Boolean dataProcessing, Boolean readyForMeeting) {
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

	public Boolean getReceived() {
		return received;
	}

	public void setReceived(Boolean received) {
		this.received = received;
	}

	public Boolean getDataProcessing() {
		return dataProcessing;
	}

	public void setDataProcessing(Boolean dataProcessing) {
		this.dataProcessing = dataProcessing;
	}

	public Boolean getReadyForMeeting() {
		return readyForMeeting;
	}

	public void setReadyForMeeting(Boolean readyForMeeting) {
		this.readyForMeeting = readyForMeeting;
	}
}
