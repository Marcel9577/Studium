package a7;

import java.util.ArrayList;

/**
 * Diese Container-Klasse dient zur Verwaltung aller Messwerte in einer
 * ArrayList
 * 
 * @author Marcel Harmsen, 19.08.2019
 *
 */
public class WetterContainer {

	// Attribute
	private ArrayList<Messwert> messwerte = new ArrayList<>();

	// Operationen
	/**
	 * Diese Operation fügt der ArrayList einen neuen Messwert hinzu
	 * 
	 * @param messwert - Der hinzuzufügende Messwert
	 */
	public void addMesswert(Messwert messwert) {
		this.messwerte.add(messwert);
	}

	/**
	 * Diese Operation gibt die ArrayList mit den Messwerten zurück
	 * 
	 * @return - Die ArrayList mit den Messwerten
	 */
	public ArrayList<Messwert> getMesswerte() {
		return this.messwerte;
	}

}
