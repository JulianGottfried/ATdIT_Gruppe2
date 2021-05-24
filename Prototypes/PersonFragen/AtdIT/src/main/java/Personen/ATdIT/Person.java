package Personen.ATdIT;

public class Person {
	
	String PersonenID;
	String VorName;
	String NachName;
	String GeburtsDatum;
	String PLZ;
	String Wohnort;
	String Straße;
	String HausNr;
	
	public String getStraße() {
		return Straße;
	}

	public void setStraße(String straße) {
		Straße = straße;
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

	
	public Person(String PersonenID, String VorName,String NachName, String GeburtsDatum, String PLZ, String Wohnort, String Straße , String HausNr) {
		this.PersonenID = PersonenID;
		this.VorName = VorName;
		this.NachName = NachName;
		this.GeburtsDatum = GeburtsDatum;
		this.PLZ = PLZ;
		this.Wohnort = Wohnort;
		this.Straße = Straße;
		this.HausNr = HausNr;
	}
}