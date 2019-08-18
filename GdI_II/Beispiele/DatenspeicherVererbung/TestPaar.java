public class TestPaar
{
  public static void main(String args[])
  {
    //Speicher für String und Float
    DatenspeicherPaar<String, Float> einArtikelPlusPreis = 
         new DatenspeicherPaar<>();
    einArtikelPlusPreis.setPaar
       ("JSP fuer Einsteiger", 34.95f);
    System.out.println
       ("Artikel: " + einArtikelPlusPreis.getWert1());
    System.out.println
       ("Preis in Euro: " + einArtikelPlusPreis.getWert2());

    //Speicher für Character und Integer
    DatenspeicherPaar<Character, Integer> 
      kundenanzahlProBuchstabe = 
         new DatenspeicherPaar<>();
    kundenanzahlProBuchstabe.setPaar('A', 367);
    System.out.println
      ("Buchstabe: " 
     + kundenanzahlProBuchstabe.getWert1());
    System.out.println
     ("Kundenanzahl: " 
      + kundenanzahlProBuchstabe.getWert2());
  }
}
