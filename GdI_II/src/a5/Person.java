package a5;

/**
 * Diese Klasse ermöglicht die Erstellung einer Person (z.B. Fahrer oder
 * Beifahrer)
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public class Person {

	// Attribute
	private double gewicht;

	// Konstruktor
	public Person(double gewicht) {
		this.gewicht = gewicht;
	}

	// Operationen
	public double getGewicht() {
		return gewicht;
	}

}
