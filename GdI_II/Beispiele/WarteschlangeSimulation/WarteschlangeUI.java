/* Programmname: WarteschlangeUI
* Aufgabe: Ermöglicht die Simulation und 
* Ausgabe einer Warteschlange 
*/
public class WarteschlangeUI
{
//Attribute
private static char zchn = 'A';
private static String getNeuenNamen()
{
  String name = Character.toString(zchn++);
  return name;
}

private static void ausgebenWarteschlange
   (Warteschlange eineWarteschlange)
{
  for (int i = 0; 
    i < eineWarteschlange.getAnzahlElemente(); i++)
      System.out.print(
     eineWarteschlange.getPerson(i).getName() + " ");
  System.out.println();  
}

public static void main(String args[])
{
    Person einePerson;
    Warteschlange eineWarteschlange = new Warteschlange();
    //10 Objekte der Klasse Person in die 
    //Warteschlange eintragen 
    System.out.println
      ("Initialisierung der Warteschlange");
    for (int i = 0; i < 10; i++)
    {
        einePerson = new Person(getNeuenNamen());
        System.out.print(einePerson.getName() + " ");
        eineWarteschlange.anstellen(einePerson);
    }
    System.out.println();
    
    System.out.println("Kontrollausgabe");
    //Warteschlange ausgeben 
    WarteschlangeUI.ausgebenWarteschlange
       (eineWarteschlange);

    System.out.println("Start Simulation");
    for (int i = 0; i < 20; i++) //Anzahl Simulationen
    {
        if(Math.random() < 0.5f)
               eineWarteschlange.anstellen
                 (new Person(getNeuenNamen()));
        else 
               eineWarteschlange.bedienen();
        //Ausgabe der Warteschlange
        System.out.print("Sim " + (i + 1) + ": ");
        WarteschlangeUI.ausgebenWarteschlange
             (eineWarteschlange);
   } //Ende Simulation
}
}