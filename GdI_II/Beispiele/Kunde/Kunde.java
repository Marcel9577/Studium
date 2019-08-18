public class Kunde
{
 //Attribute
 private String name;
 private String telefon;
 private int blz;
 private int kontonr;
 //Konstruktor
 public Kunde()
 {
 }
 //Lesende Methoden
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

 //Schreibende Methoden
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
}

