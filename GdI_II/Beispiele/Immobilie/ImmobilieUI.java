import java.util.*;

public class ImmobilieUI
{
 public static void main(String args[])
 {
  Einfamilienhaus einHaus = 
    new Einfamilienhaus("K�ster", 300000, "Stadthaus");
  Geschaeftshaus nocheinHaus = 
    new Geschaeftshaus("M�ller", 1500000, 10);
  System.out.println("Daten zum Einfamilienhaus");
  System.out.println("Haustyp: " + einHaus.getHaustyp());
  System.out.println
   ("Besitzer: " + einHaus.getBesitzer());
  System.out.println
   ("Verkaufspreis: " + einHaus.getVerkaufspreis());
  
  System.out.println("Daten zum Gesch�ftshaus");
  System.out.println
   ("Anzahl B�ror�ume: " + nocheinHaus.getAnzahlBueroraeume());
  System.out.println
  ( "Besitzer: " + nocheinHaus.besitzer);
  System.out.println(
  "Verkaufspreis: " + nocheinHaus.getVerkaufspreis());
 }
}