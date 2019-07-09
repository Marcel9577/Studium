public class Kunde
{
 //Attribute
 private String name, telefon;
 private int blz, kontonr;
 //Klassenattribut
 private static int kundenanzahl;
 
 //Konstruktor
 public Kunde()
 {
     Kunde.erhoeheKundenanzahl();
 }
 //Lesende Objektoperationen
 public String getName()
 {
  return name;
 }
 public String getTelefon()
 {
  return telefon;
 }
 public int getBLZ()
 {
  return blz;
 }
 public int getKontonr()
 {
  return kontonr;
 }
 //Schreibende Objektoperationen
 public void setName(String kundenname)
 {
  name = kundenname;
 }
 public void setTelefon(String nummer)
 {
  telefon = nummer;
 }
 public void setBLZ(int bankleitzahl)
 {
  blz = bankleitzahl;
 }
 public void setKontonr(int kontonummer)
 {
  kontonr = kontonummer;
 }
 //Lesende Klassenoperation
 public static int getKundenanzahl()
 {
  return Kunde.kundenanzahl;
 }
 //Schreibende Klassenoperationen
 public static void setKundenanzahl(int anzahl)
 {
     Kunde.kundenanzahl = anzahl;
 }
 public static void erhoeheKundenanzahl()
 {
     Kunde.kundenanzahl++;
 }    
}