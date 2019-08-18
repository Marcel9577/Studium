package a6;

import java.util.ArrayList;

/**
 * Diese Klasse erm�glicht es Module anzulegen und diesen bis zu 4
 * Lehrveranstaltungen hinzuzuf�gen
 * 
 * @author Marcel Harmsen, 01.08.2019
 *
 */
public class Modul implements CreditPointI {

	// Attribute
	private String name;
	private ArrayList<Lehrveranstaltung> lehrveranstaltungen;

	// Konstruktor
	public Modul(String name) {
		this.name = name;
		this.lehrveranstaltungen = new ArrayList<Lehrveranstaltung>(4);

		// Jedes erstellte Objekt soll dem Modulcontainer hinzugef�gt werden
		ModulContainer.getObjektreferenz().addModul(this);
	}

	// Operationen
	/**
	 * Diese Operation f�gt einem Modul eine �bergebene Lehrverstaltung hinzu
	 * 
	 * @param lehrveranstaltung - Die hinzuzf�gende Lehrveranstaltung
	 */
	public void addLehrveranstaltung(Lehrveranstaltung lehrveranstaltung) {
		lehrveranstaltungen.add(lehrveranstaltung);
	}

	/**
	 * Diese Operation gibt den Modulnamen zur�ck
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * Diese Operation gibt die CreditPoints des Moduls zur�ck. Diese ergeben sich
	 * aus der Summe aller zugeordneten Lehrveranstaltungen
	 */
	@Override
	public int getCPs() {

		int summeCPs = 0;

		// Ermittlung der Summe der CPs anhand der zugeordneten Lehrverstaltungen
		for (Lehrveranstaltung eineLehrveranstaltung : this.lehrveranstaltungen) {
			summeCPs = summeCPs + eineLehrveranstaltung.getCPs();
		}

		return summeCPs;
	}

	/**
	 * Diese Operation baut eine Ausgabe des kompletten Moduls f�r die Console
	 * zusammen
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Modul: ");
		str.append(this.name + "\n");
		str.append("\tLehrveranstaltungen:\n");
		for (Lehrveranstaltung eineLehrveranstaltung : this.lehrveranstaltungen) {
			str.append("\t\t- " + eineLehrveranstaltung.getName() + "(" + eineLehrveranstaltung.getCPs() + " CPs)\n");
		}

		return str.toString();
	}

}
