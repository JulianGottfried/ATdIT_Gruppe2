package main.java.persistence.databaseTables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
* This class is a basic data model for the Stages of COA table. 
* @author weilichsoheisse
* @version 16.05.2021
*
*/

@Entity
@Table(name = "StagesOfCOA")
public class StagesOfCOA implements AbstractEntry, Serializable {
	@Id @OneToOne 
	private ChangesOfAddresses	ChangeOfAddress;
	private boolean				Received;
	private boolean				DataProcessing;	
	private boolean				ReadyForMeeting;

	public StagesOfCOA() {
		super();
	}

	public StagesOfCOA(boolean received, boolean dataProcessing, boolean readyForMeeting) {
		super();
		Received = received;
		DataProcessing = dataProcessing;
		ReadyForMeeting = readyForMeeting;
	}

	public ChangesOfAddresses getProcessID() {
		return ChangeOfAddress;
	}

	public void setProcessID(ChangesOfAddresses changeOfAddress) {
		ChangeOfAddress = changeOfAddress;
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
