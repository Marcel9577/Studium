package a5;

/**
 * Diese Klasse ermöglicht die Erstellung eines Fahrrads
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public class Fahrrad extends Fahrzeug {

	// Attribute
	private static final int MAXBEIFAHRER = 0;

	// Konstruktor
	public Fahrrad(Person fahrer, double breite, double laenge, double gewicht) {
		super(fahrer, breite, laenge, gewicht);
		super.setMaxBeifahrer(MAXBEIFAHRER);
	}

	// Operationen
}
