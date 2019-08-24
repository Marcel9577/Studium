package a9;

/**
 * Diese Klasse ermöglicht die Erstellung von Personen
 * 
 * @author Marcel Harmsen, 24.08.2019
 *
 */
public class Person {

	// Attribute
	private String name;
	private int alter;

	// Konstruktor
	public Person(String name, int alter) {
		this.name = name;
		this.alter = alter;
	}

	// Operationen
	@Override
	public String toString() {
		return this.name + ", " + this.alter;
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return alter;
	}

}
