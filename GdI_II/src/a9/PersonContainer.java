package a9;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse dient als Container-Klasse, die neben meinem Namen auch folgende
 * Personen-Objekte als Liste zurückliefert: [Meier,40] [Müller, 55] [Beyer, 37]
 * [Albrecht, 42] [Hansen, 56].
 * 
 * @author Marcel Harmsen, 24.08.2019
 *
 */
public class PersonContainer {

	// Attribute
	private static List<Person> personen = new ArrayList<>();

	// Operationen
	public static List<Person> getListe() {

		personen.add(new Person("Harmsen", 23));
		personen.add(new Person("Meier", 40));
		personen.add(new Person("Müller", 55));
		personen.add(new Person("Beyer", 37));
		personen.add(new Person("Albrecht", 42));
		personen.add(new Person("Hansen", 56));

		return personen;

	}

}
