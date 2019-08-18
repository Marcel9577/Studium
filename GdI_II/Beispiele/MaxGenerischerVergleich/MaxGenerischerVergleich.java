public class MaxGenerischerVergleich
{
 //generische Methodendeklaration 
 public static  <T extends Comparable<T>>
     T gibMax(T wert1, T wert2)
 {
  if (wert1.compareTo(wert2) > 0) 
   return wert1;
  else 
   return wert2;
 }

public static void main (String args[])
{
   System.out.println
     ("Max " + gibMax(new Float(1.0f), new Float(2.0f)));
   System.out.println("Max "+ gibMax("Z", "A"));
   //Mit Autoboxing
   System.out.println("Max "+ gibMax(22, 99));
 }
}
