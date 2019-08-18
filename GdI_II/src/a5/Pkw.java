package a5;

/**
 * Diese Klasse ermöglicht die Erstellung eines PKWs
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public class Pkw extends Fahrzeug {

	// Attribute
	private static final int MAXBEIFAHRER = 3;

	// Konstruktor
	public Pkw(Person fahrer, double breite, double laenge, double gewicht) {
		super(fahrer, breite, laenge, gewicht);
		super.setMaxBeifahrer(MAXBEIFAHRER);
	}

	// Operationen
}