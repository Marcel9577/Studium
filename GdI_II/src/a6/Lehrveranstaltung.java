package a6;

/**
 * Mittels dieser Klasse k�nnen Lehrveranstalungen angelegt werden
 * 
 * @author Marcel Harmsen, 01.08.2019
 *
 */
public class Lehrveranstaltung implements CreditPointI {

	// Attribute
	private String name;
	private int cps;

	// Konstruktor
	public Lehrveranstaltung(String name, int cps) {
		this.name = name;
		this.cps = cps;
	}

	// �berschriebene Methoden aus dem Interface
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getCPs() {
		return this.cps;
	}

}
