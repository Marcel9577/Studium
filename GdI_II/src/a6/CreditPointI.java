package a6;

/**
 * Dieses Interface dient dazu die Schnittstelle bzgl. der Credit Points zu den
 * Lehrveranstaltungen und Modulen einheitlich zu halten. Hier werden die
 * Oprationen definiert, die sowohl Module als auch Lehrveranstaltungen
 * implementieren müssen
 * 
 * @author Narcel Harmsen, 01.08.2019
 *
 */
public interface CreditPointI {

	// Abstrakte Operationen
	public abstract String getName();

	public abstract int getCPs();

}
