package a7;

/**
 * Mittels dieser Klasse können Messwerte zu bestimmten Zeitpunkten (Datum)
 * erfasst werden
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class Messwert {

	// Attribute
	private double temperatur;
	private int tag, monat, jahr;

	// Konstruktor
	public Messwert(double temperatur, int tag, int monat, int jahr) {
		this.temperatur = temperatur;
		this.tag = tag;
		this.monat = monat;
		this.jahr = jahr;
	}

	// Operationen
	public double getTemperatur() {
		return temperatur;
	}

	public int getTag() {
		return tag;
	}

	public int getMonat() {
		return monat;
	}

	public int getJahr() {
		return jahr;
	}

}
