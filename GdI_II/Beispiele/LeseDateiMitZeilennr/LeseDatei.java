//Liest einen Text aus einer Textdatei
//und gibt die Zeilennummern mit aus 

import java.io.*;

class LeseDatei
{
 public static void main (String args[])
 {
   try (FileReader eineEingabeDatei = 
     new FileReader("Lesedatei.java");
    LineNumberReader eingabeDaten = 
     new LineNumberReader(eineEingabeDatei))
  {
    String zeile = eingabeDaten.readLine();
    while (zeile  != null)
    {
     System.out.println
      (eingabeDaten.getLineNumber() + ": " + zeile);
     zeile = eingabeDaten.readLine();
    }
  } 
  catch(IOException eineAusnahme)
  {
     System.out.println
       ("Fehlermeldung: " + eineAusnahme);
  }
 }
}