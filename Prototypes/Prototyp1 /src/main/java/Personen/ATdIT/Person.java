package Personen.ATdIT;

public class Person {
	
	String PersonenID;
	String VorName;
	String NachName;
	String GeburtsDatum;
	String PLZ;
	String Wohnort;
	String StraßeUndHausnummer;
	
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

	public String getStraßeUndHausnummer() {
		return StraßeUndHausnummer;
	}

	public void setStraßeUndHausnummer(String straßeUndHausnummer) {
		StraßeUndHausnummer = straßeUndHausnummer;
	}
	
	public Person(String PersonenID, String VorName,String NachName, String GeburtsDatum, String PLZ, String Wohnort, String StraßeUndHausnummer) {
		this.PersonenID = PersonenID;
		this.VorName = VorName;
		this.NachName = NachName;
		this.GeburtsDatum = GeburtsDatum;
		this.PLZ = PLZ;
		this.Wohnort = Wohnort;
		this.StraßeUndHausnummer = StraßeUndHausnummer;
	}
}