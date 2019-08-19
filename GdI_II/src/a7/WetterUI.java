package a7;

/**
 * Diese Klasse dient als UI-Klasse. Hier werden Messwerte angelegt, der Liste
 * hinzugefügt, in einer Datei gespeichert und anschließend wieder eingelesen
 * und auf der Konsole ausgegeben
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class WetterUI {

	public static void main(String[] args) {

		// Container für die Messwerte anlegen
		WetterContainer wetterContainer = new WetterContainer();
		// Ersten Messwerte anlegen und der Liste hinzufügen (M=13)
		wetterContainer.addMesswert(new Messwert(13.0, 14, 12, 2012));
		// Zweiten Messwerte anlegen (H=8)
		wetterContainer.addMesswert(new Messwert(8.0, 15, 2, 2013));
		// Einige weitere Messwerte anlegen
		wetterContainer.addMesswert(new Messwert(13.4, 16, 2, 2013));
		wetterContainer.addMesswert(new Messwert(14.5, 17, 2, 2013));

		// Messwerte in Datei speichern
		WetterSpeicher wetterSpeicher = new WetterSpeicher();
		wetterSpeicher.speichereWerte(wetterContainer.getMesswerte());

		// Messwerte aus Datei auslesen und auf der Konsole ausgeben
		wetterSpeicher.leseWerte();

	}

}
