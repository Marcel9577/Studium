package a5;

/**
 * Diese Klasse dient der Simulation der Beladung einer Fähre mit zufällig
 * erstellten Fahrzeugen
 * 
 * @author Marcel Harmsen, 09.08.2019
 *
 */
public class BeladungFaehreUI {

	// Wertebereich PKW
	private static final double MINBREITEPKW = 3;
	private static final double MAXBREITEPKW = 4;
	private static final double MINLAENGEPKW = 3;
	private static final double MAXLAENGEPKW = 7;
	private static final double MINGEWICHTPKW = 1000;
	private static final double MAXGEWICHTPKW = 2800;

	// Wertebereich LKW
	private static final double MINBREITELKW = 3;
	private static final double MAXBREITELKW = 4.5;
	private static final double MINLAENGELKW = 8;
	private static final double MAXLAENGELKW = 40;
	private static final double MINGEWICHTLKW = 7500;
	private static final double MAXGEWICHTLKW = 20000;

	// Wertebereich Motorrad
	private static final double MINBREITEMOTORRAD = 1;
	private static final double MAXBREITEMOTORRAD = 3;
	private static final double MINLAENGEMOTORRAD = 1.5;
	private static final double MAXLAENGEMOTORRAD = 4;
	private static final double MINGEWICHTMOTORRAD = 150;
	private static final double MAXGEWICHTMOTORRAD = 400;

	// Wertebereich Fahrrad
	private static final double MINBREITEFAHRRAD = 0.5;
	private static final double MAXBREITEFAHRRAD = 1.5;
	private static final double MINLAENGEFAHRRAD = 1;
	private static final double MAXLAENGEFAHRRAD = 3;
	private static final double MINGEWICHTFAHRRAD = 5;
	private static final double MAXGEWICHTFAHRRAD = 20;

	// Wertebereich
	private static final double MINGEWICHTGEPAECKPKW = 100;
	private static final double MAXGEWICHTGEPAECKPKW = 300;
	private static final double MINGEWICHTGEPAECKLKW = 500;
	private static final double MAXGEWICHTGEPAECKLKW = 2000;
	private static final double MINGEWICHTGEPAECKMOTORRAD = 10;
	private static final double MAXGEWICHTGEPAECKMOTORRAD = 50;
	private static final double MINGEWICHTGEPAECKFAHRRAD = 1;
	private static final double MAXGEWICHTGEPAECKFAHRRAD = 30;

	// Wertebereich
	private static final double MINGEWICHTPERSON = 40;
	private static final double MAXGEWICHTPERSON = 120;

	// Wahrscheinlichkeit, ob auf einem Platz im Fahrzeug ein Beifahrer sitzt
	// (notwendig um die Gewichte dynamisch zu gestalten)
	private static final double BEIFAHRERWAHRSCHEINLICHKEIT = 0.5;

	public static void main(String[] args) {

		// Initialisierung der Fähre mit M=13, H=8 -> 13+8=25 (Fläche = 25*1000 und
		// Gewicht = 25*100000
		Faehre faehre = new Faehre((25 * 100000), (25 * 1000));

		// Schleife, welche solange läuft bis laut Prognose kein Fahrzeug mehr auf die
		// Fähre passt.
		while (faehre.getPrognoseFahrzeuge() != 0) {
			// Fahrer mit zufälligem Gewicht für das zu erstellende Fahrzeug anlegen
			Person fahrer = new Person(erstelleDoubleZufallszahl(MINGEWICHTPERSON, MAXGEWICHTPERSON));
			double breite = 0;
			double laenge = 0;
			double gewicht = 0;

			// Random int-Wert zwischen 1 und 4 erzeugen um einen zufälligen Fahrzeugtyp
			// anzulegen (1=Pkw, 2=Lkw, 3=Motorrad und 4=Fahrrad)
			switch (erstelleIntZufallszahl(1, 4)) {
			case 1: // Pkw
				// Zufällige Werte für Breite, Länge und Gewicht ermitteln
				breite = erstelleDoubleZufallszahl(MINBREITEPKW, MAXBREITEPKW);
				laenge = erstelleDoubleZufallszahl(MINLAENGEPKW, MAXLAENGEPKW);
				gewicht = erstelleDoubleZufallszahl(MINGEWICHTPKW, MAXGEWICHTPKW);

				// PKW erstellen
				Pkw pkw = new Pkw(fahrer, breite, laenge, gewicht);
				// Gepäck hinzufügen
				pkw.setGepaeck(new Gepaeck(erstelleDoubleZufallszahl(MINGEWICHTGEPAECKPKW, MAXGEWICHTGEPAECKPKW)));

				// Dynamisch erstellte Beifahrer hinzufügen
				for (int i = 0; i < pkw.getMaxBeifahrer(); i++) {
					if (auslosenBeifahrer()) {
						pkw.addBeifahrer(new Person(erstelleDoubleZufallszahl(MINGEWICHTPERSON, MAXGEWICHTPERSON)));
					}
				}

				// Fahrzeug der Fähre hinzufügen
				faehre.addFahrzeug(pkw);

			case 2: // Lkw
				// Zufällige Werte für Breite, Länge und Gewicht ermitteln
				breite = erstelleDoubleZufallszahl(MINBREITELKW, MAXBREITELKW);
				laenge = erstelleDoubleZufallszahl(MINLAENGELKW, MAXLAENGELKW);
				gewicht = erstelleDoubleZufallszahl(MINGEWICHTLKW, MAXGEWICHTLKW);

				// LKW erstellen
				Lkw lkw = new Lkw(fahrer, breite, laenge, gewicht);
				// Gepäck hinzufügen
				lkw.setGepaeck(new Gepaeck(erstelleDoubleZufallszahl(MINGEWICHTGEPAECKLKW, MAXGEWICHTGEPAECKLKW)));

				// Dynamisch erstellte Beifahrer hinzufügen
				for (int i = 0; i < lkw.getMaxBeifahrer(); i++) {
					if (auslosenBeifahrer()) {
						lkw.addBeifahrer(new Person(erstelleDoubleZufallszahl(MINGEWICHTPERSON, MAXGEWICHTPERSON)));
					}
				}

				// Fahrzeug der Fähre hinzufügen
				faehre.addFahrzeug(lkw);
			case 3: // Motorrad
				// Zufällige Werte für Breite, Länge und Gewicht ermitteln
				breite = erstelleDoubleZufallszahl(MINBREITEMOTORRAD, MAXBREITEMOTORRAD);
				laenge = erstelleDoubleZufallszahl(MINLAENGEMOTORRAD, MAXLAENGEMOTORRAD);
				gewicht = erstelleDoubleZufallszahl(MINGEWICHTMOTORRAD, MAXGEWICHTMOTORRAD);

				// Motorrad erstellen
				Motorrad motorrad = new Motorrad(fahrer, breite, laenge, gewicht);
				// Gepäck hinzufügen
				motorrad.setGepaeck(
						new Gepaeck(erstelleDoubleZufallszahl(MINGEWICHTGEPAECKMOTORRAD, MAXGEWICHTGEPAECKMOTORRAD)));

				// Dynamisch erstellte Beifahrer hinzufügen
				for (int i = 0; i < motorrad.getMaxBeifahrer(); i++) {
					if (auslosenBeifahrer()) {
						motorrad.addBeifahrer(
								new Person(erstelleDoubleZufallszahl(MINGEWICHTPERSON, MAXGEWICHTPERSON)));
					}
				}

				// Fahrzeug der Fähre hinzufügen
				faehre.addFahrzeug(motorrad);

			case 4: // Fahrrad
				// Zufällige Werte für Breite, Länge und Gewicht ermitteln
				breite = erstelleDoubleZufallszahl(MINBREITEFAHRRAD, MAXBREITEFAHRRAD);
				laenge = erstelleDoubleZufallszahl(MINLAENGEFAHRRAD, MAXLAENGEFAHRRAD);
				gewicht = erstelleDoubleZufallszahl(MINGEWICHTFAHRRAD, MAXGEWICHTFAHRRAD);

				// Fahrrad erstellen
				Fahrrad fahrrad = new Fahrrad(fahrer, breite, laenge, gewicht);
				// Gepäck hinzufügen
				fahrrad.setGepaeck(
						new Gepaeck(erstelleDoubleZufallszahl(MINGEWICHTGEPAECKFAHRRAD, MAXGEWICHTGEPAECKFAHRRAD)));

				// Fahrzeug der Fähre hinzufügen
				faehre.addFahrzeug(fahrrad);

			}

			// Daten der Fähre ausgeben
			ausgebenFaehre(faehre);
		}

	}

	/**
	 * Diese Operation erstellt eine zufällige Zahl im übergebenen Bereich vom Typ
	 * Double
	 * 
	 * @param min - Untere Grenze des Bereichs aus dem eine zufällige Zahl ermittelt
	 *            wird
	 * @param max - Obere Grenze des Bereichs aus dem eine zufällige Zahl ermittelt
	 *            wird
	 * @return
	 */
	private static double erstelleDoubleZufallszahl(double min, double max) {
		return min + (Math.random() * ((max - min) + 1));
	}

	/**
	 * Diese Operation erstellt eine zufällige Zahl im übergebenen Bereich vom Typ
	 * Integer
	 * 
	 * @param min - Untere Grenze des Bereichs aus dem eine zufällige Zahl ermittelt
	 *            wird
	 * @param max - Obere Grenze des Bereichs aus dem eine zufällige Zahl ermittelt
	 *            wird
	 * @return
	 */
	private static int erstelleIntZufallszahl(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	/**
	 * Diese Funktion dient zur Auslosung, ob auf einem Platz ein Beifahrer sitzt
	 * oder nicht. Dadurch kann das Gesamtgewicht der Fahrzeuge dynamisch gehalten
	 * werden
	 * 
	 * @return - true, wenn ein Beifahrer auf dem Platz sitzen soll
	 */
	private static boolean auslosenBeifahrer() {
		return Math.random() <= BEIFAHRERWAHRSCHEINLICHKEIT;
	}

	/**
	 * Ausgabe der Daten der übergebenen Fähre auf der Konsole
	 * 
	 * @param faehre - Fähre deren Daten auf der Konsole ausgegeben werden sollen
	 */
	private static void ausgebenFaehre(Faehre faehre) {
		System.out.println("Aktuelle Daten der Fähre:");
		ausgebenAufgeladeneFahrzeuge(faehre);
		System.out.println("\tAktuelle Nutzfläche: " + faehre.getAktNutzflaeche() + " m2");
		System.out.println("\tAktuelles Nutzgewicht: " + faehre.getAktNutzgewicht() + " kg");
		System.out.println("\tDurchschnittliche Nutzfläche: " + faehre.getDurchschnNutzflaeche() + " m2");
		System.out.println("\tDurchschnittliches Fahrzeuggewicht: " + faehre.getDurchschnNutzgewicht() + " kg");
		System.out.println("\tAnzahl Fahrzeuge (Prognose): " + faehre.getPrognoseFahrzeuge());
	}

	/**
	 * Ausgabe der Zeile mit den Anzahlen der jeweils aufgeladenen Fahrzeugtypen
	 * 
	 * @param faehre - Fähre deren Daten auf der Konsole ausgegeben werden sollen
	 */
	private static void ausgebenAufgeladeneFahrzeuge(Faehre faehre) {
		System.out.print("\tBeladene Fahrzeuge: ");
		System.out.print(faehre.getAnzahlLKW() + "x LKW / ");
		System.out.print(faehre.getAnzahlPKW() + "x PKW / ");
		System.out.print(faehre.getAnzahlMotorraeder() + "x Motorrad / ");
		System.out.println(faehre.getAnzahlFahrraeder() + "x Fahrrad");
	}

}
