package a8;

/**
 * Diese Klasse dient zur Erstellung von Patienten mit allgemeingültigen
 * Personendaten, sowie spezifischen Eigenschaften (z.B. Pflegestufe)
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class Patient extends Person {

	// Attribute
	private Pflegestufe pflegestufe;
	private Helfer helfer;

	// Konstruktor
	public Patient(int nummer, String name, String strasse, String ort, Pflegestufe pflegestufe) {
		super(nummer, name, strasse, ort);
		this.pflegestufe = pflegestufe;
	}

	// Operationen
	public void setHelfer(Helfer helfer) {
		this.helfer = helfer;
	}

	public Helfer getHelfer() {
		return this.helfer;
	}

	public Pflegestufe getPflegestufe() {
		return this.pflegestufe;
	}

	public boolean hatHelfer() {
		return this.helfer != null;
	}

}
