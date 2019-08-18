package a4;

/**
 * Diese Klasse speichert die Daten eines Telefons
 * 
 * @author Marcel Harmsen, 29.07.2019
 *
 */
public class Telefon {

	// Attribute
	private String nummer;
	private int typ;

	// Konstruktor
	public Telefon(String nummer, int typ) {
		this.nummer = nummer;
		this.typ = typ;
	}

	// Methoden
	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public int getTyp() {
		return typ;
	}

	public void setTyp(int typ) {
		this.typ = typ;
	}

	public void waehlen() {
		// Wählenmethode
	}

}
