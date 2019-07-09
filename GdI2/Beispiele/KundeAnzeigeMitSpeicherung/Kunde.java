/* Programmname: Kundenverwaltung
* Fachkonzept-Klasse: Kunde
* Aufgabe: Kundenobjekte erzeugen
*/
import java.util.*;

public class Kunde 
{   
 //Attribute
 private int kundennr;
 private String name;
 private String telefon;
 private int blz;
 private int kontonr;
 //Klasse Kunde verwaltet
 //n Anzeigen-Referenzen
 private ArrayList<Anzeige> anzeigen = new ArrayList<>();

 //Konstruktoren
 public Kunde() {
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

 //Schreibende Methoden
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
 
 public void setKundennr(int kundennr) 
 {
    this.kundennr = kundennr;
 }
 public int getKundennr() 
 {
    return kundennr;
 }
 
 
 public ArrayList<Anzeige> getAnzeigen() 
 {
    return anzeigen;    
 }
 
 public void setAnzeigen(ArrayList<Anzeige> anzeigen) 
 {
    this.anzeigen = anzeigen;    
 }
 
 //Assoziationsoperationen
 //Verbindung zu Anzeigen herstellen
 public void setLinkAnzeige(Anzeige eineAnzeige)
 {
    //Eine Anzeige hinzufügen
    anzeigen.add(eineAnzeige);
    //Bei Anzeige dafür sorgen, dass
    //dort ein Kunde eingetragen wird
    eineAnzeige.setLinkKunde(this);
 }
 //Verbindung zu Anzeige löschen
 public void removeLinkAnzeige(Anzeige eineAnzeige)
 {
   anzeigen.remove(eineAnzeige);
   eineAnzeige.removeLinkKunde(this);
 }
 //Liefert alle Anzeigen eines Kunden
 public ArrayList<Anzeige> alleAnzeigen()
 { 
    return anzeigen; 
 }

}
