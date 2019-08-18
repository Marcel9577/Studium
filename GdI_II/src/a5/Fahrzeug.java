package a5;

import java.util.ArrayList;

/**
 * Diese abstrakte Klasse dient als Oberklasse der speziellen Fahrzeugtypen. Bei
 * der Erzeugung eines Fahrzeug-Objektes müssen der Fahrer, die Breite, die
 * Länge und das Fahrzeuggewicht bekannt sein.
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public abstract class Fahrzeug {

	// Attribute
	private Person fahrer;
	private Gepaeck gepaeck;
	private double breite;
	private double laenge;
	private double gewicht;
	private int maxBeifahrer;
	private ArrayList<Person> beifahrer = new ArrayList<>(this.getMaxBeifahrer());

	// Konstruktor
	protected Fahrzeug(Person fahrer, double breite, double laenge, double gewicht) {
		this.fahrer = fahrer;
		this.breite = breite;
		this.laenge = laenge;
		this.gewicht = gewicht;
	}

	// Operationen
	public void setGepaeck(Gepaeck gepaeck) {
		this.gepaeck = gepaeck;
	}

	/**
	 * Berechnung der benötigten Nutzfläche des Fahrzeugs
	 * 
	 * @return - Die benötigte Nutzfläche des Fahrzeugs
	 */
	public double berechneNutzflaeche() {
		return (this.breite * this.laenge) * 1.5;
	}

	/**
	 * Berechnung des Gesamtgewichts des Fahrzeugs
	 * 
	 * @return - Das Gesamtgewicht des Fahrzeugs
	 */
	public double berechneGesamtgewicht() {

		double gesGewicht = this.gewicht + this.fahrer.getGewicht() + this.gepaeck.getGewicht();

		for (Person einBeifahrer : beifahrer) {
			gesGewicht += einBeifahrer.getGewicht();
		}

		return gesGewicht;
	}

	public void setMaxBeifahrer(int maxBeifahrer) {
		this.maxBeifahrer = maxBeifahrer;
	}

	public int getMaxBeifahrer() {
		return maxBeifahrer;
	}

	/**
	 * Dem Fahrzeug einen Beifahrer hinzufügen
	 * 
	 * @param beifahrer - Der hinzuzufügende Beifahrer
	 */
	public void addBeifahrer(Person beifahrer) {
		if (this.beifahrer.size() < this.getMaxBeifahrer()) {
			this.beifahrer.add(beifahrer);
		}
	}

}
