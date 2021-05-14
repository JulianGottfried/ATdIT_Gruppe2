package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PersonenDaten")
public class Person extends AbstractEntry {
	
	String VorName;
	String NachName;
	String GeburtsDatum;
	String PLZ;
	String Wohnort;
	String Strasse;
	String HausNr;
	@Id
	String PersonenID;
	
	public String getStrasse() {
		return Strasse;
	}

	public void setStrasse(String Strasse) {
		this.Strasse = Strasse;
	}

	public String getHausNr() {
		return HausNr;
	}

	public void setHausNr(String hausNr) {
		HausNr = hausNr;
	}

	public String getPersonenID() {
		return PersonenID;
	}

	public void setPersonenID(String personenID) {
		PersonenID = personenID;
	}
	
	public String getVorName() {
		return VorName;
	}

	public void setVorName(String vorName) {
		VorName = vorName;
	}

	public String getNachName() {
		return NachName;
	}

	public void setNachName(String nachName) {
		NachName = nachName;
	}

	public String getGeburtsDatum() {
		return GeburtsDatum;
	}

	public void setGeburtsDatum(String geburtsDatum) {
		GeburtsDatum = geburtsDatum;
	}

	public String getPLZ() {
		return PLZ;
	}

	public void setPLZ(String pLZ) {
		PLZ = pLZ;
	}

	public String getWohnort() {
		return Wohnort;
	}

	public void setWohnort(String wohnort) {
		Wohnort = wohnort;
	}
}