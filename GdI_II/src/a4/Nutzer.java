package a4;

import java.util.ArrayList;

/**
 * Diese Klasse speichert die Daten eines Nutzers und seine Endgeräte. Die
 * Anzahl der Endgeräte ist auf 2 beschränkt.
 *
 * @author Marcel Harmsen, 29.07.2019
 *
 */
public class Nutzer {

	// Attribute
	private String name;
	private ArrayList<Telefon> telefone = new ArrayList<>(2);

	// Konstruktor
	public Nutzer(String name) {
		this.name = name;
	}

	// Methoden
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Telefon> getTelefone() {
		return telefone;
	}

	public void setTelefone(ArrayList<Telefon> telefone) {
		this.telefone = telefone;
	}

}
