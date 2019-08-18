/** 
 * Die Klasse <b>WetterUI</b> ist die UI-Klasse  
 * f�r die Klasse <b>Wetter</b>.<br/>
 * <hr/>
 * @author Helmut Balzert
 * @version 1.0 
 */
public class WetterUI
{
 /** 
  * Startmethode f�r die Ausf�hrung dieses Programms
  *
  * @param args Argumente f�r das Programm
  */
 public static void main(String args[])
 {
    Wetter ersteStation = new Wetter("Ort A");
    Wetter zweiteStation = new Wetter("Ort B");
    ersteStation.setTemperatur(23);
    zweiteStation.setTemperatur(23);
    vergleicheTemp(ersteStation, zweiteStation);
 }

 /** 
  * Vergleicht Temperaturen von zwei Wetterstationen
  * auf Gleichheit und gibt das Ergebnis auf Konsole aus.
  *
  * @param station1 erste zu vergleichende Station
  * @param station1 zweite zu vergleichende Station
  */
 private static void 
   vergleicheTemp(Wetter station1, Wetter station2)
 {
    System.out.print("Die Temperatur zwischen " 
      + station1.getStation() + " und " 
      + station2.getStation() + " ist ");
    if (station1.getTemperatur() == 
         station2.getTemperatur())
      System.out.println("gleich");
    else 
      System.out.println("ungleich");
 }
}