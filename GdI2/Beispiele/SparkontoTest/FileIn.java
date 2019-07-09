//Methoden zum zeilenweisen Einlesen von 
//Informationen aus einer Textdatei 

import java.io.*;

public class FileIn
{
  private static FileReader infile;
  private static BufferedReader in;
  private static String filenameIn;

  public static void oeffneEingabedatei(String infilename)
  {
    try
    {
     filenameIn = infilename;
     infile = new FileReader(infilename);
     in = new BufferedReader(infile);
    }
    catch(IOException io)
    {
     System.out.println
     ("Fehler beim ÷ffnen der Datei " + infilename);
     System.exit(1);
    }
  }
  public static String gibNaechsteZeile()
  {
   String zeile = null;
   try
   {
    if((zeile = in.readLine()) != null)
    {
    //System.out.println
    //("Eingelesene Zeile: " + zeile);
    }
   }
   catch(IOException io)
   {
      System.out.println
      ("Fehler beim Lesen einer Zeile aus der Datei " 
        + filenameIn);
      System.exit(1);
    }
   return zeile;
  }
  public static void schliesseEingabedatei()
  {  
   try
   {
      in.close();
   }
   catch(IOException io)
   {
     System.out.println
     ("Fehler beim Schlieﬂen der Datei " 
      + filenameIn);
     System.exit(1);
    }
}
}
