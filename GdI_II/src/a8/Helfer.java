package a8;

/**
 * Diese Klasse ermöglicht die Erstellung eines Helfers mit allgemeingültigen
 * Personendaten, sowie spezifischen Eigenschaften (z.B. Ausbildung)
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class Helfer extends Person {

	// Attribute
	private boolean hatAusbildung;
	private Patient patient;

	// Konstruktor
	public Helfer(int nummer, String name, String strasse, String ort, boolean hatAusbildung) {
		super(nummer, name, strasse, ort);
		this.hatAusbildung = hatAusbildung;
	}

	// Operationen
	public boolean getHatAusbildung() {
		return this.hatAusbildung;
	}

	public Person getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public boolean hatPatient() {
		return this.patient != null;
	}

}
