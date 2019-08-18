package a2;

/**
 * @author Marcel Harmsen, 24.07.2019
 * 
 * Diese Klasse beschreibt einen Artikel, samt Eigenschaften und Methoden
 *
 */
public class Artikel {
	
	//Attribute
	private int artikelNr;
	private String artikelBez, sprache = "Java", beschreibung;
	private double vkPreis = 0.0;

	//Methoden
	public int getArtikelNr() {
		return artikelNr;
	}
	public void setArtikelNr(int artikelNr) {
		this.artikelNr = artikelNr;
	}
	public String getArtikelBez() {
		return artikelBez;
	}
	public void setArtikelBez(String artikelBez) {
		this.artikelBez = artikelBez;
	}
	public String getSprache() {
		return sprache;
	}
	public void setSprache(String sprache) {
		this.sprache = sprache;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public double getVkPreis() {
		return vkPreis;
	}
	public void setVkPreis(double vkPreis) {
		this.vkPreis = vkPreis;
	}	

}
