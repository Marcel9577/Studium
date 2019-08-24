package a9;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Diese Klasse realisiert die Funktionen aus MainUI_b mittels funktionaler
 * Programmierung
 * 
 * @author Marcel Harmsen, 24.08.2019
 *
 */
public class MainUI_c {

	private static List<Person> liste = PersonContainer.getListe();

	public static void main(String[] args) {
		// Filtern: Alle Personen ausgeben, deren Name auf "er" endet
		for (Person p : filtern1())
			System.out.println(p);
		System.out.println("");

		// Filtern: Alle Personen ausgeben, deren Name mit "M" beginnt
		for (Person p : filtern2())
			System.out.println(p);
		System.out.println("");

		// Sortieren: Nach Name aufsteigend
		for (Person p : sortieren1())
			System.out.println(p);
		System.out.println("");

		// Sortieren: Nach Alter aufsteigend
		for (Person p : sortieren2())
			System.out.println(p);
		System.out.println("");

		// Reduzieren: Älteste Person
		System.out.println(reduzieren1());
		System.out.println("");

		// Reduzieren: Person mit längstem Namen
		System.out.println(reduzieren2());
		System.out.println("");
	}

	/**
	 * Diese Operation dient zur Filterung aller Personen, deren Name auf "er"
	 * endet.
	 * 
	 * @return - Liste mit allen Personen deren Name auf "er" endet
	 */
	private static List<Person> filtern1() {
		List<Person> tempList = new ArrayList<>();

		liste.stream().filter(person -> person.getName().endsWith("er")).forEach(person -> tempList.add(person));

		return tempList;
	}

	/**
	 * Diese Operation dient zur Filterung aller Personen, deren Name mit "M"
	 * beginnt.
	 * 
	 * @return - Liste mit allen Personen deren Name mit "M" beginnt
	 */
	private static List<Person> filtern2() {
		List<Person> tempList = new ArrayList<>();

		liste.stream().filter(person -> person.getName().startsWith("M")).forEach(person -> tempList.add(person));

		return tempList;
	}

	/**
	 * Diese Operation dient zur Sortierung der Liste von Personen nach Name
	 * aufsteigend
	 * 
	 * @return - Die sortierte Liste
	 */
	private static List<Person> sortieren1() {
		List<Person> tempList = liste.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
				.collect(toList());

		return tempList;
	}

	/**
	 * Diese Operation dient zur Sortierung der Liste von Personen nach Alter
	 * aufsteigend
	 * 
	 * @return - Die sortierte Liste
	 */
	private static List<Person> sortieren2() {
		List<Person> tempList = liste.stream().sorted((p1, p2) -> p1.getAlter() - p2.getAlter()).collect(toList());

		return tempList;
	}

	/**
	 * Diese Operation dient zur Ermittlung der ältesten Person
	 * 
	 * @return - Die älteste Person
	 */
	private static Person reduzieren1() {

		Optional<Person> person = liste.stream().reduce((p1, p2) -> p1.getAlter() >= p2.getAlter() ? p1 : p2);

		return person.get();
	}

	/**
	 * Diese Operation dient zur Ermittlung der Person mit dem längsten Namen
	 * 
	 * @return - Die Person mit dem längsten Namen
	 */
	private static Person reduzieren2() {
		Optional<Person> persLaengsterName = liste.stream()
				.reduce((p1, p2) -> p1.getName().length() >= p2.getName().length() ? p1 : p2);

		return persLaengsterName.get();
	}
}
