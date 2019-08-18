/* Programmname: Kundenverwaltung
* Fachkonzept-Klasse: Kunde
* Aufgabe: Kundenobjekte erzeugen
*/

public class Kunde
{	
 //Attribute
 private int kundennr;
 private String name;
 private String telefon;
 private int blz;
 private int kontonr;
 //Konstruktoren
    public Kunde()  {
    }
 public Kunde(int kundennr, String name, String telefon, 
   int blz, int kontonr)
 {
	this.kundennr = kundennr;
    this.name = name;
	this.telefon = telefon;
	this.blz = blz;
	this.kontonr = kontonr;
 }
 //Lesende Methoden
 public int getNummer()
 {
     return kundennr;
 }
 public String getName()
 {
  return name;
 }
 public String getTelefon()
 {
  return telefon;
 }
 public int getBlz()
 {
  return blz;
 }
 public int getKontonr()
 {
  return kontonr;
 }
 public int getKundennr() 
 {
    return kundennr;
 }
 
 
 //Schreibende Methoden
 public void setKundennr(int kundennr) 
 {
    this.kundennr = kundennr;
 }
 public void setName(String kundenname)
 {
  name = kundenname;
 }
 public void setTelefon(String nummer)
 {
  telefon = nummer;
 }
 public void setBlz(int bankleitzahl)
 {
  blz = bankleitzahl;
 }
 public void setKontonr(int kontonummer)
 {
  kontonr = kontonummer;
 }
}
