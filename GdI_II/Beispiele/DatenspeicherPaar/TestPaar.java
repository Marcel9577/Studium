public class TestPaar
{
  public static void main(String args[])
  {
    //Speicher f�r String und Double
    DatenspeicherPaar <String, Double> 
      einArtikelPlusPreis = 
         new DatenspeicherPaar<String, Double>();
    einArtikelPlusPreis.setPaar
       ("Java - Anwendungen programmieren", 29.90);
    System.out.println("Artikel: " + 
       einArtikelPlusPreis.getWert1());
    System.out.println("Preis in Euro: " + 
       einArtikelPlusPreis.getWert2());

    //Speicher f�r Character und Integer
    DatenspeicherPaar <Character, Integer>
       kundenanzahlProBuchstabe = 
         new DatenspeicherPaar<Character, Integer>();
    kundenanzahlProBuchstabe.setPaar('A', 367);
    System.out.println("Buchstabe: " + 
        kundenanzahlProBuchstabe.getWert1());
    System.out.println("Kundenanzahl: " + 
        kundenanzahlProBuchstabe.getWert2());
  }
}
