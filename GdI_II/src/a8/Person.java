package a8;

/**
 * Diese abstrakte Klasse bündelt alle allgemeingültigen Informationen einer
 * Person und dient somit als Oberklasse für z.B. Helfer oder Patienten
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public abstract class Person {

	// Attribute
	private int nummer;
	private String name;
	private String strasse;
	private String ort;

	// Konstruktor
	public Person(int nummer, String name, String strasse, String ort) {
		this.nummer = nummer;
		this.name = name;
		this.strasse = strasse;
		this.ort = ort;
	}

	// Operationen
	public int getNummer() {
		return this.nummer;
	}

	public String getName() {
		return this.name;
	}

	public String getStrasse() {
		return this.strasse;
	}

	public String getOrt() {
		return this.ort;
	}

}
