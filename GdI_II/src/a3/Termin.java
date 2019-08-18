package a3;

import java.time.LocalDate;

/**
 * Diese Klasse implementiert die Modellierung eines Termins mit Datum und zugehöriger
 * Beschreibung. Außerdem ermöglicht sie den Vergleich zweier Termin-Objekte.
 * 
 * @author Marcel Harmsen, 29.07.2019
 *
 */
public class Termin {

	// Attribute
	private LocalDate termin;
	private String beschreibung;

	// Konstruktor
	public Termin(int jahr, int monat, int tag, String beschreibung) {
		setTermin(LocalDate.of(jahr, monat, tag));
		setBeschreibung(beschreibung);
	}

	// Methoden

	/**
	 * Diese Methode ermöglicht das Auslesen des Attributs "termin" des konkreten
	 * Objekts
	 * 
	 * @return - Der Wert des Attributs "termin"
	 */
	public LocalDate getTermin() {
		return termin;
	}

	/**
	 * Diese Methode ermöglicht das Setzen des Wertes des Attributs "termin" des
	 * konkreten Objekts
	 * 
	 * @param termin - Der zu setzende Wert
	 */
	public void setTermin(LocalDate termin) {
		this.termin = termin;
	}

	/**
	 * Diese Methode ermöglicht das Auslesen des Attributs "beschreibung" des
	 * konkreten Objekts
	 * 
	 * @return - Der Wert des Attributs "beschreibung"
	 */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
	 * Diese Methode ermöglicht das Setzen des Wertes des Attributs "beschreibung"
	 * des konkreten Objekts
	 * 
	 * @param termin - Der zu setzende Wert
	 */
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	/**
	 * Diese Methode vergleicht den übergebenen Termin mit dem aufrufenden Termin
	 * 
	 * @param termin - Der zu vergleichende Termin
	 * @return - 0, wenn die Termine gleich sind, 
	 * 			 Positver Wert, wenn der übergebene Termin größer ist als der Aufrufende 
	 * 			 Negativer Wert, wenn der übergebene Termin kleiner ist als der Aufrufende
	 */
	public int vergleicheTermin(Termin termin) {
		return this.getTermin().compareTo(termin.getTermin());
	}

}
