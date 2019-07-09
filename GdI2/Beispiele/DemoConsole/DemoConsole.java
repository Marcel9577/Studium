import inout.Console;
import java.time.LocalDate;

public class DemoConsole
{
  public static void main(String args[])
  {
    System.out.println("Text eingeben: ");
    String text = Console.readString();
    System.out.println("Gelesener Text: " + text);
        
    System.out.println("Text eingeben: ");
    char [] ca = Console.readCharArray();
    System.out.println("Gelesenes char-Feld: ");
    for (char celement: ca)
      System.out.print(celement);
    System.out.println();
         
    System.out.println("Boolean eingeben: ");
    boolean b = Console.readBoolean();
    System.out.println("Gelesener Wert: " + b);
        
    System.out.println("Ganze Zahl eingeben: ");
    int i = Console.readInt();
    System.out.println("Gelesener Wert: " + i);
        
    System.out.println("Long-Zahl eingeben: ");
    long l = Console.readLong();
    System.out.println("Gelesener Wert: " + l);
        
    System.out.println("Gleitpunktzahl eingeben: ");
    float f = Console.readFloatPoint();
    System.out.println("Gelesener Wert: " + f);
        
    System.out.println("Gleitkommazahl eingeben: ");
    float fc = Console.readFloatComma();
    System.out.println("Gelesener Wert: " + fc);
        
    System.out.println("Gleitpunktzahl double eingeben: ");
    double d = Console.readDoublePoint();
    System.out.println("Gelesener Wert: " + d);
        
    System.out.println("Gleitkommazahl double eingeben: ");
    double dc = Console.readDoubleComma();
    System.out.println("Gelesener Wert: " + fc);
        
    System.out.println("Zeichen eingeben: ");
    char c = Console.readChar();
    System.out.println("Gelesener Wert: " + c);

   System.out.println("Datum eingeben tt.mm.jjjj: ");
   LocalDate datum = Console.readDate();
   System.out.println("Gelesener Wert: " + datum);
  }
}