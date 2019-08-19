package a8;

import java.util.ArrayList;

/**
 * Mittels dieser UI-Klasse wird die Anzeige und Ausgabe der
 * Personenverwaltung/Helfersuche vorgenommen
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class HelferSucheUI {

	public static void main(String args[]) {
		// Aufruf der Personenverwaltung
		Personenverwaltung personenverwaltung = Personenverwaltung.getPersonenverwaltungReferenz();

		// Hinzufügen einiger Beispiel-Patienten
		personenverwaltung.addPatient("Franz", "Morsstrasse", "Neuenhaus", Pflegestufe.I);
		personenverwaltung.addPatient("Steffen", "Dorfstrasse", "Neuenhaus", Pflegestufe.III);
		personenverwaltung.addPatient("Jürgen", "Dieselstrasse", "Veldhausen", Pflegestufe.II);
		personenverwaltung.addPatient("Dennis", "Heideweg", "Nordhorn", Pflegestufe.II);
		personenverwaltung.addPatient("Laura", "Buchenstrasse", "Laarwald", Pflegestufe.II);

		// Hinzufügen einiger Beispiel-Helfer
		personenverwaltung.addHelfer("Marcel Harmsen", "Lerchenweg", "Laarwald", false);
		personenverwaltung.addHelfer("Lisa Smoes", "Tannenstrasse", "Nordhorn", false);
		personenverwaltung.addHelfer("Marco Cebulla", "Blaubeerweg", "Nordhorn", true);
		personenverwaltung.addHelfer("Janette Droese", "Roggenweg", "Veldhausen", true);
		personenverwaltung.addHelfer("Michael Husmann", "Bahnhofsweg", "Neuenhaus", true);

		// Ermitteln einer Zuordnung von Helfern zu Patienten für alle gespeicherten
		// Patienten und Helfer
		ArrayList<Patient> patienten = personenverwaltung.getPatienten();
		ArrayList<Helfer> helfer = personenverwaltung.getHelfer();
		HelferSuche.setHelfer(patienten, helfer);

		System.out.println("Übersicht der Zuordnungen:");
		for (Patient einPatient : patienten) {
			druckePatientendaten(einPatient);
			if (einPatient.hatHelfer()) {
				druckeHelferdaten(einPatient.getHelfer());
			}
			System.out.println("");
		}
		System.out.println("");

		System.out.println("Freie Helfer:");
		for (Helfer einHelfer : helfer) {
			if (!einHelfer.hatPatient()) {
				druckeHelferdaten(einHelfer);
			}
			System.out.println("");
		}
		System.out.println("");
	}

	private static void druckePersonendaten(Person einePerson) {
		System.out.print("\t" + einePerson.getNummer() + "\t" + einePerson.getName() + "\t" + einePerson.getStrasse()
				+ "\t" + einePerson.getOrt());
	}

	private static void druckePatientendaten(Patient einPatient) {
		druckePersonendaten(einPatient);
		System.out.print("\t" + einPatient.getPflegestufe());
	}

	private static void druckeHelferdaten(Helfer einHelfer) {
		druckePersonendaten(einHelfer);
		if (einHelfer.getHatAusbildung()) {
			System.out.print("\tAusbildung vorhanden");
		} else {
			System.out.print("\tKeine Ausbildung");
		}
	}

}
