package a5;

/**
 * Diese Klasse erm�glicht die Erstellung eines Gep�ckst�cks
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public class Gepaeck {

	// Attribute
	private double gewicht;

	// Konstruktor
	public Gepaeck(double gewicht) {
		this.gewicht = gewicht;
	}

	// Operationen
	public double getGewicht() {
		return gewicht;
	}
}
