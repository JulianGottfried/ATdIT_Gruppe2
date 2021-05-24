package main.java.persistence.databaseTables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * The StagesOfCOA table structure.
 * 
 * @author weilichsoheisse
 * @version 17.05.2021
 *
 */
@Entity
@Table(name = "StagesOfCOA")
public class StagesOfCOA implements AbstractEntry, Serializable {
	@Id @OneToOne 
	private ChangesOfAddresses	ChangesOfAddress;
	private boolean				Received;
	private boolean				DataProcessing;	
	private boolean				ReadyForMeeting;

	public StagesOfCOA() {
		super();
	}

	public StagesOfCOA(ChangesOfAddresses changesOfAddress, boolean received, boolean dataProcessing, boolean readyForMeeting) {
		super();
		ChangesOfAddress = changesOfAddress;
		Received = received;
		DataProcessing = dataProcessing;
		ReadyForMeeting = readyForMeeting;
	}

	public ChangesOfAddresses getChangesOfAddress() {
		return ChangesOfAddress;
	}

	public void setChangesOfAddress(ChangesOfAddresses changesOfAddress) {
		ChangesOfAddress = changesOfAddress;
	}

	public boolean getReceived() {
		return Received;
	}

	public void setReceived(boolean received) {
		Received = received;
	}

	public boolean getDataProcessing() {
		return DataProcessing;
	}

	public void setDataProcessing(boolean dataProcessing) {
		DataProcessing = dataProcessing;
	}

	public boolean getReadyForMeeting() {
		return ReadyForMeeting;
	}

	public void setReadyForMeeting(boolean readyForMeeting) {
		ReadyForMeeting = readyForMeeting;
	}
}
