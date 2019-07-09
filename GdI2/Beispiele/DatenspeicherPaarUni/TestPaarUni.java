public class TestPaarUni
{
  public static void main(String args[])
  {
    //Speicher f�r String und String
    DatenspeicherPaarUni<String> einName = 
        new DatenspeicherPaarUni<>();
    einName.setPaar("Helmut", "Balzert");
    System.out.println("Vorname: " + einName.getWert1());
    System.out.println("Nachname: " + einName.getWert2());
    einName.vertausche();
    System.out.println("Vorname: " + einName.getWert1());
    System.out.println("Nachname: " + einName.getWert2());

    //Speicher f�r Character und Integer
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
