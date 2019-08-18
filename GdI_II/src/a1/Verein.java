package a1;

public class Verein {
	
	//Attribute
	private String name, strasse, hausNr, ort, telefonNr, kontoNr;
	private int blz;
	
	//Methoden
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getHausnummer() {
		return hausNr;
	}
	public void setHausnummer(String hausnummer) {
		this.hausNr = hausnummer;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getTelefonNr() {
		return telefonNr;
	}
	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}
	public String getKontonummer() {
		return kontoNr;
	}
	public void setKontonummer(String kontonummer) {
		this.kontoNr = kontonummer;
	}
	public int getBlz() {
		return blz;
	}
	public void setBlz(int blz) {
		this.blz = blz;
	}

}
