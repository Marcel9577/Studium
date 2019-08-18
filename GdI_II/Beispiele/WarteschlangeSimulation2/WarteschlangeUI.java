/* Programmname: WarteschlangeUI
* Aufgabe: Ermöglicht die Simulation und 
* Ausgabe einer Warteschlange 
*/
public class WarteschlangeUI
{
//Attribute
private static char zchn = 'A';
public static String getNeuenNamen()
{
  String name = Character.toString(zchn++);
  return name;
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
        System.out.print(einePerson.toString() + " ");
        eineWarteschlange.anstellen(einePerson);
    }
    System.out.println();
    
    System.out.println("Kontrollausgabe");
    //Warteschlange ausgeben 
    System.out.println(eineWarteschlange); 
    // entspricht: System.out.println(eineWarteschlange.toString());
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
        System.out.println(eineWarteschlange);
   } //Ende Simulation
}
}