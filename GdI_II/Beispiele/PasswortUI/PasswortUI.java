import inout.Console;

public class PasswortUI
{
 private final static int MIN_LAENGE_PASSWORT = 6;
 private static boolean pruefePasswortLaengeUndAufZiffer(String passwort)
 {
   boolean ok = false;
   if(passwort.length() < MIN_LAENGE_PASSWORT)
      System.out.println
          ("Ihr Passwort hat weniger als 6 Zeichen");
   else
     ok = true;
   if (ok) //Länge >= minimale Länge
   {
   
       for (int i = 0; i < passwort.length(); i++)
       {
         if(Character.isDigit(passwort.charAt(i)))
         {
            ok = true; break;
         }
         else
         {
            ok = false;
         }
       }//Ende for
       if (! ok)
         System.out.println
           ("Ihr Passwort hat keine Ziffer");
    }//Ende if
   return ok;    
 }
 
 public static void main(String args[])
 {
	System.out.println
	  ("Wählen Sie ein Passwort (mindestens 6 Zeichen und 1 Ziffer)");
	String passwort = Console.readString();
	
	boolean freigabe = pruefePasswortLaengeUndAufZiffer(passwort);
	if (freigabe)
	System.out.println("Ihr Passwort " + passwort 
	+ " entspricht unseren Vorgaben");
	//....
 }
}