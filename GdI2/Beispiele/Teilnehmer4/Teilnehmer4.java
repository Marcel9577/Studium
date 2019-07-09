 	

/**
 * Lambda-Ausdr�cke in Datenstr�men
 * Terminal Operations 
 */

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.Optional;


public class Teilnehmer4
{
  public static void main(String[] args) 
  {
    ArrayList<String> teilnehmerliste = new ArrayList<>(5);
    teilnehmerliste.add("Sommer");
    teilnehmerliste.add("Wenzel");
    teilnehmerliste.add("Mustermann");
    teilnehmerliste.add("Borschel");
    teilnehmerliste.add("Zink");
    
    System.out.println("(1) L�ngster Name?");

    Optional<String> laengsterName = 
      teilnehmerliste
          .stream()
          .reduce((name1, name2) -> 
             name1.length() >= name2.length() ? name1 : name2);
    laengsterName.ifPresent(name ->
      System.out.println("Der l�ngste Name ist: " + name));

    
    System.out.println();
    System.out.println("(2) Summe der L�nge aller Namen: " +
      teilnehmerliste
           .stream()
           .mapToInt(name -> name.length())
           .sum()
     );               
    
    System.out.println();               
    System.out.println(
      "(3) Durchschnittliche L�nge aller Namen: " +
      teilnehmerliste
           .stream()
           .mapToInt(name -> name.length())
           .average()
     );
  }
}
