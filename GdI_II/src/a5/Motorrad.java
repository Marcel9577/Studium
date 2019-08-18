package a5;

/**
 * Diese Klasse ermöglicht die Erstellung eines Motorrads
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public class Motorrad extends Fahrzeug {

	// Attribute
	private static final int MAXBEIFAHRER = 1;

	// Konstruktor
	public Motorrad(Person fahrer, double breite, double laenge, double gewicht) {
		super(fahrer, breite, laenge, gewicht);
		super.setMaxBeifahrer(MAXBEIFAHRER);
	}

	// Operationen

}
