//Liest einen Text aus einer Textdatei 

import java.io.*;

class LeseDatei
{
 public static void main (String args[])
 {
   FileReader eineEingabeDatei = null;
   try
   {
     eineEingabeDatei = 
       new FileReader("LeseDatei.java");
     int c;
     while ( (c = eineEingabeDatei.read()) != -1 )
     System.out.print((char) c);                    
   }
   catch(IOException eineAusnahme)
   {
     System.out.println("Fehlermeldung: " + eineAusnahme);
   }
   finally //Schlieﬂen der Datei
   {
     if (eineEingabeDatei != null)
     try
     {
       eineEingabeDatei.close();
     }
     catch (IOException eineAusnahme)
     {
      System.out.println("Fehlermeldung: " + eineAusnahme);
     }
   }
 }
}