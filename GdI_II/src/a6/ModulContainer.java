package a6;

import java.util.ArrayList;

/**
 * Dieser Container dient zur Speicherung aller Module als ArrayList. Zudem wird
 * durch das Singleton-Muster sichergestellt, dass nur ein Objekt von diesem
 * Container erstellt werden kann.
 * 
 * @author Marcel Harmsen, 01.08.2019
 *
 */
public class ModulContainer {

	// Attribute
	private ArrayList<Modul> module = new ArrayList<>();
	private static ModulContainer einModulContainer = null;

	// Konstruktor, von außen nicht zugreifbar
	private ModulContainer() {

	}

	// Operationen
	/**
	 * Diese Klassenoperation liefert die Objektreferenz. Wenn das Objekt noch nicht
	 * vorhanden ist, dann wird es erzeugt
	 * 
	 * @return die Objektreferenz auf den ModulContainer
	 */
	public static ModulContainer getObjektreferenz() {
		if (einModulContainer == null) {
			einModulContainer = new ModulContainer();
		}
		return einModulContainer;
	}

	/**
	 * Diese Operation fügt der ArrayList der Module das übergebene Modul hinzu
	 * 
	 * @param modul - Das hinzuzufügende Modul
	 */
	public void addModul(Modul modul) {
		this.module.add(modul);
	}

	/**
	 * Diese Operation liefert die Liste mit allen erstellten Modulen
	 * 
	 * @return - Die ArrayList mit allen erstellten Modulen
	 */
	public ArrayList<Modul> getModule() {
		return this.module;
	}

}
