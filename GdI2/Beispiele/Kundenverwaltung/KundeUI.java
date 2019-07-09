import java.util.*;

public class KundeUI
{
 public static void main(String args[])
 {
  KundenContainer meinContainer = new KundenContainer();
  Kunde einKunde = new Kunde("K�ster");
  //Erzeugtes Objekt im Kundencontainer 
  //verwalten
  meinContainer.insertKunde(einKunde);
  einKunde = new Kunde("Siebert");
  meinContainer.insertKunde(einKunde);
  einKunde = new Kunde("K�hn");
  meinContainer.insertKunde(einKunde);
  //Kundenliste ausgeben
  druckeKundenliste(meinContainer);
  }
      
 private static void druckeKundenliste
    (KundenContainer einContainer)
 {
  for (Kunde k : einContainer.gibAlleKunden())
  {
       System.out.println(k.getName()); 
  }
}
}