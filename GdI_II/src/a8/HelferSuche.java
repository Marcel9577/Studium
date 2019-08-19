package a8;

import java.util.ArrayList;

/**
 * Diese Klasse dient als Hilfsklasse, um zu einer Menge an Patienten geeignete
 * Helfer zu finden, sodass (wenn möglich) jeder Patient einen Helfer zugewiesen
 * bekommt, der im gleichen Ort wohnt und wenn nötig eine zur Pflegestufe
 * passende Ausbildung hat. Sollte kein passender Helfer gefunden werden, wird
 * keiner zugeordnet
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class HelferSuche {

	private HelferSuche() {
	}

	public static void setHelfer(ArrayList<Patient> patienten, ArrayList<Helfer> helfer) {
		for (Patient einPatient : patienten) {
			for (Helfer einHelfer : helfer) {
				boolean istGeeignet = true;
				// Prüfung auf Eignung durch Ausbildung ab Pflegestufe II
				if (brauchtAusgebildetenHelfer(einPatient)) {
					istGeeignet = einHelfer.getHatAusbildung();
				}

				// Suche nach geeignetem Helfer und Zuordnung
				if (einPatient.getOrt().equals(einHelfer.getOrt()) && !einHelfer.hatPatient() && istGeeignet) {
					einPatient.setHelfer(einHelfer);
					einHelfer.setPatient(einPatient);
					break;
				}
			}
		}
	}

	private static boolean brauchtAusgebildetenHelfer(Patient einPatient) {
		return einPatient.getPflegestufe() != Pflegestufe.I;
	}

}
