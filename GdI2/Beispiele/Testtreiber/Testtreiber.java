import inout.Console;
public class Testtreiber
{
  static int bestimmeMax (int a, int b)
 {
  if (a > b)
	 return a;
  else
	 return b;
 }
 public static void main(String args[])
 {
    System.out.print("Wert f�r a: ");
    int a = Console.readInt();
    System.out.print("Wert f�r b: ");
    int b = Console.readInt();
    //Aufruf des Testlings
    System.out.println
     ("Max: " + bestimmeMax(a,b));
 }
}
