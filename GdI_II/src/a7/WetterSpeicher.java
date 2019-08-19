package a7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Diese Klasse dient zur Speicherung von Messwerten in einer Textdatei, sowie
 * zum Auslesen der Messwerte aus einer Textdatei
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class WetterSpeicher {

	// Attribute
	private static final String DATEIPFAD = "messungen.txt";

	// Operationen
	/**
	 * Diese Operation ließt die Messwerte aus einer Datei aus und gibt diese auf
	 * der Konsole aus
	 */
	public void leseWerte() {

		try (FileReader eingabeDatei = new FileReader(DATEIPFAD);
				BufferedReader eingabeDaten = new BufferedReader(eingabeDatei)) {
			// Erste Zeile lesen
			String zeile = eingabeDaten.readLine();
			// Wenn eine Zeile gelesen wurde, gib sie aus
			// und lese die restlichen Zeilen
			while (zeile != null) {
				System.out.println(zeile);
				zeile = eingabeDaten.readLine();
			}
		} catch (IOException eineAusnahme) {
			System.out.println("Fehlermeldung: " + eineAusnahme);
		}

	}

	/**
	 * Diese Operation schreibt die Messwerte aus der übergebenen ArrayList in eine
	 * Textdatei
	 * 
	 * @param werte - Die ArrayList mit den zu speichernden Messwerten
	 */
	public void speichereWerte(ArrayList<Messwert> werte) {

		try (FileWriter ausgabeDatei = new FileWriter(DATEIPFAD)) {
			for (Messwert einMesswert : werte) {
				ausgabeDatei.write(einMesswert.getTag() + "." + einMesswert.getMonat() + "." + einMesswert.getJahr()
						+ ", " + einMesswert.getTemperatur() + ";\n");
			}
			ausgabeDatei.close();
		} catch (IOException eineAusnahme) {
			System.out.println("Fehlermeldung: " + eineAusnahme);
		}

	}

}
