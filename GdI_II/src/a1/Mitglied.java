package a1;

import java.util.Date;

public class Mitglied {
	
	//Attribute
	private String vorname, nachname, strasse, hausNr, ort, gebOrt, kontoNr, telefonNr;
	private int mitgliedsNr, blz, jahreImVerein;
	private boolean aktiv;
	private Date gebDatum;
	
	//Methoden
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getHausNr() {
		return hausNr;
	}
	public void setHausNr(String hausNr) {
		this.hausNr = hausNr;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getGebOrt() {
		return gebOrt;
	}
	public void setGebOrt(String gebOrt) {
		this.gebOrt = gebOrt;
	}
	public String getKontoNr() {
		return kontoNr;
	}
	public void setKontoNr(String kontoNr) {
		this.kontoNr = kontoNr;
	}
	public String getTelefonNr() {
		return telefonNr;
	}
	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}
	public int getMitgliedsNr() {
		return mitgliedsNr;
	}
	public void setMitgliedsNr(int mitgliedsNr) {
		this.mitgliedsNr = mitgliedsNr;
	}
	public int getBlz() {
		return blz;
	}
	public void setBlz(int blz) {
		this.blz = blz;
	}
	public int getJahreImVerein() {
		return jahreImVerein;
	}
	public void setJahreImVerein(int jahreImVerein) {
		this.jahreImVerein = jahreImVerein;
	}
	public boolean isAktiv() {
		return aktiv;
	}
	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}
	public Date getGebDatum() {
		return gebDatum;
	}
	public void setGebDatum(Date gebDatum) {
		this.gebDatum = gebDatum;
	}

}
