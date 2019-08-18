package a4;

/**
 * Diese Klasse verwaltet Nutzer und ihre Zuordnung zu Endgeräten. Die Daten
 * werden auf der Konsole ausgegeben.
 * 
 * @author Marcel Harmsen, 29.07.2019
 *
 */
public class TelefonUI {

	public static void main(String[] args) {

		// Nutzer erstellen
		Nutzer harmsen = new Nutzer("Marcel Harmsen");
		// Telefone erstellen und zuweisen
		harmsen.getTelefone().add(new Telefon("12345", 0));
		harmsen.getTelefone().add(new Telefon("67890", 1));
		// Ausgabe
		if (harmsen.getTelefone().size() > 0) {
			System.out.println("Nutzer " + harmsen.getName());
			int zaehler = 0;
			for (Telefon einTelefon : harmsen.getTelefone()) {
				zaehler++;
				System.out.println("Endgerät " + zaehler + ": Nummer " + einTelefon.getNummer() + " und Typ "
						+ einTelefon.getTyp());
			}
		}

		// Nutzer erstellen
		Nutzer smoes = new Nutzer("Lisa Smoes");
		// Telefone erstellen und zuweisen
		smoes.getTelefone().add(new Telefon("34567", 0));
		// Ausgabe
		if (smoes.getTelefone().size() > 0) {
			System.out.println("Nutzer " + smoes.getName());
			int zaehler = 0;
			for (Telefon einTelefon : smoes.getTelefone()) {
				zaehler++;
				System.out.println("Endgerät " + zaehler + ": Nummer " + einTelefon.getNummer() + " und Typ "
						+ einTelefon.getTyp());
			}
		}
	}

}
