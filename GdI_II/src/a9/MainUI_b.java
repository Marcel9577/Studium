package a9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Diese Klasse realisiert die einzelnen Funktionalitäten imperativ
 * 
 * @author Marcel Harmsen, 24.08.2019
 *
 */
public class MainUI_b {

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

		for (Person einePerson : liste) {
			if (einePerson.getName().endsWith("er"))
				tempList.add(einePerson);
		}

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

		for (Person einePerson : liste) {
			if (einePerson.getName().startsWith("M"))
				tempList.add(einePerson);
		}

		return tempList;
	}

	/**
	 * Diese Operation dient zur Sortierung der Liste von Personen nach Name
	 * aufsteigend
	 * 
	 * @return - Die sortierte Liste
	 */
	private static List<Person> sortieren1() {
		List<Person> tempList = new ArrayList<Person>(liste);

		class SortierenName implements Comparator<Person> {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}

		}
		;

		Collections.sort(tempList, new SortierenName());

		return tempList;
	}

	/**
	 * Diese Operation dient zur Sortierung der Liste von Personen nach Alter
	 * aufsteigend
	 * 
	 * @return - Die sortierte Liste
	 */
	private static List<Person> sortieren2() {
		List<Person> tempList = new ArrayList<Person>(liste);

		class SortierenAlter implements Comparator<Person> {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAlter() - p2.getAlter();
			}

		}
		;

		Collections.sort(tempList, new SortierenAlter());

		return tempList;
	}

	/**
	 * Diese Operation dient zur Ermittlung der ältesten Person
	 * 
	 * @return - Die älteste Person
	 */
	private static Person reduzieren1() {
		Person aeltestePerson = null;

		for (Person einePerson : liste) {
			if (aeltestePerson != null) {
				if (aeltestePerson.getAlter() < einePerson.getAlter())
					aeltestePerson = einePerson;
			} else {
				aeltestePerson = einePerson;
			}
		}

		return aeltestePerson;
	}

	/**
	 * Diese Operation dient zur Ermittlung der Person mit dem längsten Namen
	 * 
	 * @return - Die Person mit dem längsten Namen
	 */
	private static Person reduzieren2() {
		Person persLaengsterName = null;

		for (Person einePerson : liste) {
			if (persLaengsterName != null) {
				if (persLaengsterName.getName().length() < einePerson.getName().length())
					persLaengsterName = einePerson;
			} else {
				persLaengsterName = einePerson;
			}
		}

		return persLaengsterName;
	}

}
