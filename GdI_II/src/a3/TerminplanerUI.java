package a3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;

import inout.Console;

/**
 * Diese Klasse ermöglicht die Verwaltung eines Terminplaners. Es können Termine
 * angelegt, gespeichert und anschließend ausgegeben werden.
 * 
 * @author Marcel Harmsen, 29.07.2019
 *
 */
public class TerminplanerUI {

	// ArrayList zum Speichern der einzelnen Termine anlegen
	private static ArrayList<Termin> termine = new ArrayList<>();
	public static void main(String[] args) {

		boolean beenden = false;
		LocalDate heute = LocalDate.now();

		// Standardmäßigen persönlichen Termin hinzufügen
		hinzufuegenTermin(new Termin(2020, 9, 12, "Harmsen, Marcel"));

		// While Schleife, die solange läuft bis der Anwender angibt, dass das Programm
		// beendet werden soll
		while (!beenden) {

			// Menü anzeigen
			System.out.println("-----------------------------------------------");
			System.out.println("Bitte wählen Sie zwischen folgenden Optionen:");
			System.out.println();
			System.out.println("Neuer Termin: 1");
			System.out.println("Termine anzeigen: 2");
			System.out.println("Anwendung beenden: 3");
			System.out.println("-----------------------------------------------");

			try {
				// Wahl des Benutzers aus der Console einlesen
				int eingabe = Console.readInt();

				switch (eingabe) {

				case 1: // Neuen Termin anlegen
					System.out.println("Bitte geben Sie den Termin ein:");

					try {
						System.out.println("Jahr:");
						int jahr = Console.readInt();

						System.out.println("Monat:");
						int monat = Console.readInt();

						System.out.println("Tag:");
						int tag = Console.readInt();

						System.out.println("Terminbeschreibung:");
						String beschreibung = Console.readString();

						Termin neuerTermin = new Termin(jahr, monat, tag, beschreibung);

						// Prüfung, ob der Termin in der Zukunft liegt, ansonsten wird er nicht
						// gespeichert
						if (neuerTermin.getTermin().isBefore(heute)) {
							System.out.println(
									"Üngültige Eingabe: Es können nur Termine, die in der Zukunft liegen gespeichert werden!");
							break;
						}

						// Termin hinzufügen
						hinzufuegenTermin(neuerTermin);

					} catch (InputMismatchException e) {
						System.out.println("Fehlerhafte Eingabe: Bitte eine ganze Zahl eingeben!");
					}
					break;

				case 2: // Termine anzeigen
					int zaehler = 0;
					for (Termin einTermin : termine) {
						zaehler++;
						System.out.println("Termin: Nr. " + zaehler);
						System.out.println("Datum: " + einTermin.getTermin()
								.format(DateTimeFormatter.ofPattern("d.MMMM.Y", Locale.ENGLISH)));
						System.out.println("Beschreibung: " + einTermin.getBeschreibung());
						System.out.println();
					}
					break;

				case 3: // Anwendung beenden
					beenden = true;
					System.out.println("Die Anwendung wurde beendet.");
					break;
				default: // Default - Unzulässige Auswahl
					System.out.println("Diese Wahl ist nicht zulässig. Bitte gültigen Wert auswählen.");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Fehlerhafte Eingabe: Bitte eine ganze Zahl eingeben!");
			}

		}

	}

	/**
	 * Diese Methode fügt einen Termin in die ArrayList mit den Terminen ein und
	 * ruft anschließend die Methode zum Sortieren der Termine auf
	 * 
	 * @param termin - Der hinzuzufügende Termin
	 */
	private static void hinzufuegenTermin(Termin termin) {
		termine.add(termin);
		sortiereTerminplaner();
	}

	/**
	 * Diese Methode sortiert die ArrayList mit den Terminen (aufsteigend nach
	 * Termin)
	 */
	private static void sortiereTerminplaner() {
		for (int i = 0; i < termine.size(); i++) {
			Termin fruehesterTermin = termine.get(i);
			int positionMin = i;
			for (int j = i; j < termine.size(); j++) {
				if (termine.get(j).vergleicheTermin(fruehesterTermin) < 0) {
					fruehesterTermin = termine.get(j);
					positionMin = j;
				}
			}
			Termin merkeTermin = termine.get(i);
			termine.set(i, termine.get(positionMin));
			termine.set(positionMin, merkeTermin);
		}
	}
}
