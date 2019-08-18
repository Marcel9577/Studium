package a2;

/**
 * @author Marcel Harmsen, 24.07.2019
 * 
 * In dieser Klasse wird das Programm ausgeführt. Es werden Artikel erstellt und ausgegeben
 *
 */ 
public class ArtikelUI {

	public static void main(String[] args) {
		
		//Spaltenüberschriften ausgeben
		System.out.println("Artikelnr\tBezeichnung\tSprache\tBeschreibung\tVerkaufspreis");
		System.out.println("----------------------------------------------------------------------");
		
		//Artikel anlegen
		Artikel diashow = new Artikel();
		diashow.setArtikelNr(4711);
		diashow.setArtikelBez("Diashow");
		diashow.setBeschreibung("Dia-Show auf HTML-Seite");
		diashow.setVkPreis(29.90);
		printArtikel(diashow);
		
		Artikel bildbeschriftung = new Artikel();
		bildbeschriftung.setArtikelNr(4712);
		bildbeschriftung.setArtikelBez("Bildbeschriftung");
		bildbeschriftung.setBeschreibung("Erlaubt Beschriftung von Bildern");
		bildbeschriftung.setVkPreis(99.90);
		printArtikel(bildbeschriftung);
		
		Artikel piktos100 = new Artikel();
		piktos100.setArtikelNr(8726);
		piktos100.setArtikelBez("100 Piktos");
		piktos100.setBeschreibung("100 Piktogramme für HTML-Seite");
		piktos100.setVkPreis(54.50);
		printArtikel(piktos100);
		
		Artikel marcelHarmsen = new Artikel();
		marcelHarmsen.setArtikelNr(23);
		marcelHarmsen.setArtikelBez("Marcel Harmsen");
		marcelHarmsen.setBeschreibung("Eigener Artikel");
		marcelHarmsen.setVkPreis(100.00);
		printArtikel(marcelHarmsen);

	}
	
	/**
	 * Diese Methode gibt den übergebenen Artikel auf der Console aus
	 * 
	 * @param artikel - Artikel, der ausgegeben werden soll
	 */
	private static void printArtikel(Artikel artikel) 
	{
		
		System.out.println(artikel.getArtikelNr() + "\t" + artikel.getArtikelBez() + "\t" + artikel.getSprache() + "\t" + artikel.getBeschreibung() + "\t" + artikel.getVkPreis());
		
	}

}
