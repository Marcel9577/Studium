package a8;

import java.util.ArrayList;

/**
 * Diese Klasse speichert und verwaltet Patienten und Helfer
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class Personenverwaltung {

	private ArrayList<Patient> patienten = new ArrayList<>();
	private ArrayList<Helfer> helfer = new ArrayList<>();
	private static Personenverwaltung personenverwaltungReferenz = null;

	private int anzahlHelfer = 0;
	private int anzahlPatienten = 0;

	private Personenverwaltung() {
		// Leerer Konstruktor - Stichwort: Singleton
	}

	// Statische Methode, die eine Objektreferenz auf ein Objekt der eigenen Klasse
	// liefert (Singleton)
	public static Personenverwaltung getPersonenverwaltungReferenz() {
		if (personenverwaltungReferenz == null) {
			personenverwaltungReferenz = new Personenverwaltung();
		}
		return personenverwaltungReferenz;
	}

	public void addPatient(String name, String strasse, String ort, Pflegestufe pflegestufe) {
		Patient einPatient = new Patient(anzahlPatienten + 1, name, strasse, ort, pflegestufe);
		anzahlPatienten++;
		patienten.add(einPatient);
	}

	public void addHelfer(String name, String strasse, String ort, boolean hatAusbildung) {
		Helfer einHelfer = new Helfer(anzahlHelfer + 1, name, strasse, ort, hatAusbildung);
		anzahlHelfer++;
		helfer.add(einHelfer);
	}

	public ArrayList<Patient> getPatienten() {
		return patienten;
	}

	public ArrayList<Helfer> getHelfer() {
		return helfer;
	}

}
