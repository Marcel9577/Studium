package a5;

/**
 * Diese Klasse ermöglicht die Erstellung eines LKWs
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public class Lkw extends Fahrzeug {

	// Attribute
	private static final int MAXBEIFAHRER = 2;

	// Konstruktor
	public Lkw(Person fahrer, double breite, double laenge, double gewicht) {
		super(fahrer, breite, laenge, gewicht);
		super.setMaxBeifahrer(MAXBEIFAHRER);
	}

	// Operationen

}
