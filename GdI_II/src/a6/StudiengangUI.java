package a6;

/**
 * Diese Klasse simuliert die Verwaltung eines Studiengangs. Es werden Module
 * und zugehörige Lehrveranstaltungen angelegt und auf der Konsole ausgegeben
 * 
 * @author Marcel Harmsen, 01.08.2019
 *
 */
public class StudiengangUI {

	public static void main(String[] args) {

		// Objekt "Modul: Grundlagen der Informatik" erzeugen
		Modul gdi = new Modul("Grundlagen der Informatik");
		gdi.addLehrveranstaltung(new Lehrveranstaltung("Grundlagen der Informatik I", 5));
		gdi.addLehrveranstaltung(new Lehrveranstaltung("Grundlagen der Informatik II", 5));

		// Objekt "Modul: Mathematik" erzeugen
		Modul mathe = new Modul("Mathematik");
		mathe.addLehrveranstaltung(new Lehrveranstaltung("Algebra", 5));
		mathe.addLehrveranstaltung(new Lehrveranstaltung("Analysis", 5));
		mathe.addLehrveranstaltung(new Lehrveranstaltung("Statistik", 5));
		mathe.addLehrveranstaltung(new Lehrveranstaltung("Diskrete Mathe", 5));

		// Personalisiertes Modul inkl. Lehrveranstaltungen anlegen
		Modul pers = new Modul("Eigenes Modul");
		pers.addLehrveranstaltung(new Lehrveranstaltung("M_Webprogrammierung", 5));
		pers.addLehrveranstaltung(new Lehrveranstaltung("H_Web-Design", 5));
		// Ausgabe des gesamten persönlichen Moduls
		System.out.println(pers.toString());

		// Ausgabe der anderen Module und deren CPs
		ausgeben(gdi);
		ausgeben(mathe);
	}

	/**
	 * Diese Methode gibt ein Modul samt seinen CPs auf der Konsole aus
	 * 
	 * @param cpi - Das auszugebende Objekt
	 */
	public static void ausgeben(CreditPointI cpi) {
		System.out.println("Modul \"" + cpi.getName() + "\" (" + cpi.getCPs() + " CPs)");
	}

}
