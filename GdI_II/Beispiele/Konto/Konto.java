public class Konto
{
 //Attribute
 private Kunde meinKunde = null;
 //zum Merken der n�chsten nr
 private static int kontonrglobal = 1; 
 private int kontostand = 0; //in Cent
 private int kontonr = 0; //f�r jedes Objekt
 
 //Konstruktor
 public Konto(Kunde meinKunde)
 {
     this.meinKunde = meinKunde;
     this.kontonr = kontonrglobal;
     kontonrglobal++;
     
 }
 public int getKontonr()
 {
  return kontonr;
 }
 public int getKontostand()
 {
  return kontostand;
 }
 public Kunde getMeinKunde()
 {
  return meinKunde;
  
 }
 public void buchen(int betrag)
 {
     kontostand = kontostand + betrag;
  }
}