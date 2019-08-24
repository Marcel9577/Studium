package a9;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * Diese Klasse realisiert die Funktionalitäten aus MainUI_c, fasst jedoch die
 * Methoden zur Filterung, Sortierung und Reduzierung in jeweils eine Methode
 * zusammen.
 * 
 * @author Marcel Harmsen, 24.08.2019
 *
 */
public class MainUI_d {

	private static List<Person> liste = PersonContainer.getListe();

	public static void main(String[] args) {

		// Filtern: Alle Personen ausgeben, deren Name auf "er" endet
		for (Person p : filterMethod(person -> person.getName().endsWith("er")))
			System.out.println(p);
		System.out.println("");

		// Filtern: Alle Personen ausgeben, deren Name mit "M" beginnt
		for (Person p : filterMethod(person -> person.getName().startsWith("M")))
			System.out.println(p);
		System.out.println("");

		// Sortieren: Nach Name aufsteigend
		for (Person p : sortedMethod((p1, p2) -> p1.getName().compareTo(p2.getName())))
			System.out.println(p);
		System.out.println("");

		// Sortieren: Nach Alter aufsteigend
		for (Person p : sortedMethod((p1, p2) -> p1.getAlter() - p2.getAlter()))
			System.out.println(p);
		System.out.println("");

		// Reduzieren: Älteste Person
		System.out.println(reduceMethod((p1, p2) -> p1.getAlter() >= p2.getAlter() ? p1 : p2));
		System.out.println("");

		// Reduzieren: Person mit längstem Namen
		System.out.println(reduceMethod((p1, p2) -> p1.getName().length() >= p2.getName().length() ? p1 : p2));
		System.out.println("");
	}

	/**
	 * Diese Operation filtert die Liste von Persoen auf Basis des übergebenen
	 * Predicate
	 * 
	 * @param predicate - Basis für die Filterung
	 * @return - Die gefilterte Liste
	 */
	private static List<Person> filterMethod(Predicate<Person> predicate) {
		List<Person> tempList = new ArrayList<>();

		liste.stream().filter(predicate).forEach(person -> tempList.add(person));

		return tempList;
	}

	/**
	 * Diese Operation sortiert die Liste von Persoen auf Basis des übergebenen
	 * Comparators
	 * 
	 * @param comparator - Basis für die Sortierung
	 * @return - Die sortierte Liste
	 */
	private static List<Person> sortedMethod(Comparator<Person> comparator) {
		List<Person> tempList = liste.stream().sorted(comparator).collect(toList());

		return tempList;
	}

	/**
	 * Diese Operation reduziert die Liste von Persoen auf Basis des übergebenen
	 * BinaryOperators
	 * 
	 * @param op - Basis für die Reduzierung
	 * @return - Die ermittelte Person
	 */
	private static Person reduceMethod(BinaryOperator<Person> op) {
		Optional<Person> person = liste.stream().reduce(op);

		return person.get();
	}

}
