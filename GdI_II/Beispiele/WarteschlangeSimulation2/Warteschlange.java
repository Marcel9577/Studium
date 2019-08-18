/* Programmname: Warteschlange
* Fachkonzept-Klasse: Warteschlange 
* Aufgabe: Eine Warteschlange
* mit ArrayList realisieren
*/

import java.util.ArrayList;

class Warteschlange
{
 //Attribute 
 private ArrayList<Person> eineListe = new ArrayList<>();
 //Operationen
 boolean bedienen() //Entfernen
 { 
  if(eineListe.size() > 0)
  {
    eineListe.remove(0); 
    return true;
  }
  else
    return false;
 }
 void anstellen(Person einePerson) //Einfügen
 {
    eineListe.add(einePerson);
 }
 int getAnzahlElemente()
 {
    return eineListe.size();
 }
 public String toString() //Warteschlange ausgeben
 {
    StringBuilder str = new StringBuilder("");
    for(Person p : eineListe) 
    { 
      str = str.append(p.toString() + " "); 
    }
    return str.toString();
 }
}