import java.util.*;

public class KundeUI
{
 public static void main(String args[])
 {
  //Kunde mit Konto anlegen und initialisieren
  Kunde einKunde = 
    new Kunde("Schubert");
  Konto einKonto = new Konto(einKunde);
  einKunde.setMeinKonto(einKonto);
  einKonto.buchen(2000);
  System.out.println("Kunde " + einKunde.getName() +
  " hat ein Konto mit der Kontonr " 
  + einKunde.getMeinKonto().getKontonr() +
  " mit dem Kontostand " 
  + einKunde.getMeinKonto().getKontostand());
  
  //f�r selben Kunden Sparkonto anlegen
  Sparkonto einSparbuch = new Sparkonto(einKunde);
  einKunde.setMeinSparkonto(einSparbuch);
  einSparbuch.buchen(500);
  System.out.println("Kunde " + einKunde.getName() +
  " hat ein Sparkonto mit der Kontonr " + 
  einKunde.getMeinSparkonto().getKontonr() +
  " mit dem Kontostand " 
  + einKunde.getMeinSparkonto().getKontostand());
  
  //2. Kunden mit Sparbuch anlegen
  einKunde = new Kunde("K�nig");
  Sparkonto nocheinKonto = new Sparkonto(einKunde);
  //einKunde.setMeinSparkonto(nocheinKonto);
  einKunde.setMeinKonto(nocheinKonto);
  nocheinKonto.buchen(1000);
  System.out.println("Kunde " + einKunde.getName() +
  " hat ein Sparkonto mit der Kontonr " + 
  //einKunde.getMeinSparkonto().getKontonr() +
  einKunde.getMeinKonto().getKontonr() +
  " mit dem Kontostand " 
  //+ einKunde.getMeinSparkonto().getKontostand());
  + einKunde.getMeinKonto().getKontostand());
  //�ber Sparkonto des ersten Kunden auf 
  //dessen Namen zugreifen
  System.out.println("Das Sparbuch mit der Kontonr. " +
  einSparbuch.getKontonr() + " geh�rt dem Kunden " +
  einSparbuch.getMeinKunde().getName());
 }
}