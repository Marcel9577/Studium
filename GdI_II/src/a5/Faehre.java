package a5;

import java.util.ArrayList;

/**
 * Diese Klasse beinhaltet die Eigenschaften einer Fähre und besitzt zudem
 * einige Variablen zur Speicherung des aktuellen und durchschnittlichen
 * Beladungsstatus
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public class Faehre {

	// Attribute
	private double maxNutzgewicht;
	private double maxNutzflaeche;
	private double aktNutzgewicht;
	private double aktNutzflaeche;
	private double durchschnNutzgewicht;
	private double durchschnNutzflaeche;
	private int anzahlFahrzeuge;
	private int prognoseFahrzeuge = 1;
	private ArrayList<Fahrzeug> fahrzeuge;

	// Konstruktor
	public Faehre(double maxNutzgewicht, double maxNutzflaeche) {
		this.maxNutzgewicht = maxNutzgewicht;
		this.maxNutzflaeche = maxNutzflaeche;
		this.fahrzeuge = new ArrayList<>();
	}

	// Operationen
	public double getAktNutzgewicht() {
		return this.aktNutzgewicht;
	}

	public double getAktNutzflaeche() {
		return this.aktNutzflaeche;
	}

	public double getDurchschnNutzgewicht() {
		return this.durchschnNutzgewicht;
	}

	public double getDurchschnNutzflaeche() {
		return this.durchschnNutzflaeche;
	}

	public int getPrognoseFahrzeuge() {
		return this.prognoseFahrzeuge;
	}

	public double getMaxNutzflaeche() {
		return maxNutzflaeche;
	}

	public double getMaxNutzgewicht() {
		return maxNutzgewicht;
	}

	/**
	 * Ermittlung der Anzahl der Fahrzeuge vom Typ PKW auf der Fähre
	 * 
	 * @return - Anzahl der Fahrzeuge vom Typ PKW
	 */
	public int getAnzahlPKW() {
		int anzahlPKW = 0;
		for (Fahrzeug fahrzeug : fahrzeuge) {
			if (fahrzeug != null && fahrzeug instanceof Pkw)
				anzahlPKW++;
		}
		return anzahlPKW;
	}

	/**
	 * Ermittlung der Anzahl der Fahrzeuge vom Typ LKW auf der Fähre
	 * 
	 * @return - Anzahl der Fahrzeuge vom Typ LKW
	 */
	public int getAnzahlLKW() {
		int anzahlLKW = 0;
		for (Fahrzeug fahrzeug : fahrzeuge) {
			if (fahrzeug != null && fahrzeug instanceof Lkw)
				anzahlLKW++;
		}
		return anzahlLKW;
	}

	/**
	 * Ermittlung der Anzahl der Fahrzeuge vom Typ Motorrad auf der Fähre
	 * 
	 * @return - Anzahl der Fahrzeuge vom Typ Motorrad
	 */
	public int getAnzahlMotorraeder() {
		int anzahlMotorraeder = 0;
		for (Fahrzeug fahrzeug : fahrzeuge) {
			if (fahrzeug != null && fahrzeug instanceof Motorrad)
				anzahlMotorraeder++;
		}
		return anzahlMotorraeder;
	}

	/**
	 * Ermittlung der Anzahl der Fahrzeuge vom Typ Fahrrad auf der Fähre
	 * 
	 * @return - Anzahl der Fahrzeuge vom Typ Fahrrad
	 */
	public int getAnzahlFahrraeder() {
		int anzahlFahrraeder = 0;
		for (Fahrzeug fahrzeug : fahrzeuge) {
			if (fahrzeug != null && fahrzeug instanceof Fahrrad)
				anzahlFahrraeder++;
		}
		return anzahlFahrraeder;
	}

	/**
	 * Aktualisierung der aktuellen durchschnittlichen Nutzfläche der Fähre
	 */
	private void updateDurchschnNutzflaeche() {
		this.durchschnNutzflaeche = this.aktNutzflaeche / this.anzahlFahrzeuge;
	}

	/**
	 * Aktualisierung des aktuellen durchschnittlichen Nutzgewichts der Fähre
	 */
	private void updateDurchschnNutzgewicht() {
		this.durchschnNutzgewicht = this.aktNutzgewicht / this.anzahlFahrzeuge;
	}

	/**
	 * Aktualisierung der Prognose, wie viele Fahrzeuge noch auf die Fähre passen
	 */
	private void updatePrognoseFahrzeuge() {
		int prognoseFlaecheAnz = (int) ((this.maxNutzflaeche - this.aktNutzflaeche) / this.durchschnNutzflaeche);
		int prognoseGewichtAnz = (int) ((this.maxNutzgewicht - this.aktNutzgewicht) / this.durchschnNutzgewicht);
		this.prognoseFahrzeuge = Math.min(prognoseFlaecheAnz, prognoseGewichtAnz);
	}

	/**
	 * Überprüfung, ob das übergebene Fahrzeug noch auf die Fähre passt
	 * 
	 * @param fahrzeug - das Fahrzeug, dass auf die Fähre aufgeladen werden soll
	 * @return - True, wenn das Fahrzeug aufgeladen werden kann, sonst false
	 */
	private boolean aufladenMoeglich(Fahrzeug fahrzeug) {
		boolean gewicht = fahrzeug.berechneGesamtgewicht() <= this.maxNutzgewicht - this.aktNutzgewicht;
		boolean flaeche = fahrzeug.berechneNutzflaeche() <= this.maxNutzflaeche - this.aktNutzflaeche;
		return gewicht && flaeche;
	}

	/**
	 * Das Übergebe Fahrzeug der Fähre hinzufügen (aufladen)
	 * 
	 * @param fahrzeug - das aufzuladende Fahrzeug
	 */
	public void addFahrzeug(Fahrzeug fahrzeug) {
		// Prüfung, ob das Fahrzeug noch aufgeladen werden kann
		if (aufladenMoeglich(fahrzeug)) {
			this.fahrzeuge.add(fahrzeug);

			// Update Anzahl aufgeladene Fahrzeuge
			this.anzahlFahrzeuge++;

			// Update aktuelle Nutzfläche, aktuelles Nutzgewicht
			this.aktNutzflaeche += fahrzeug.berechneNutzflaeche();
			this.aktNutzgewicht += fahrzeug.berechneGesamtgewicht();

			// Update durchschnittliche Nutzfläche, durchschnittliches Nutzgewicht
			updateDurchschnNutzflaeche();
			updateDurchschnNutzgewicht();

			// Update Prognose
			updatePrognoseFahrzeuge();
		} else {
			System.out.println("Fahrzeug passt nicht mehr auf die Fähre!");
		}
	}

}
