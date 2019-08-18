//Methoden zum zeilenweisen Schreiben 
//in eine Textdatei

import java.io.*;

public class FileOut
{
  private static FileWriter outfile;
  private static PrintWriter out;
  private static String filenameOut;

  public static void oeffneAusgabedatei
     (String outfilename)
  {
    try
    {
      filenameOut = outfilename;
      outfile = new FileWriter(outfilename,true);
      out = new PrintWriter(outfile,true);
    }
    catch(IOException io)
    {
        System.out.println
        ("Fehler beim Öffnen der Datei " 
         + outfilename);
        System.exit(1);
    }
  }
  public static void schreibeNaechsteZeile
    (String zeile)
  {
    out.println(zeile);
    //System.out.println
    //("Geschriebene Zeile: " + zeile);
  }
  public static void schliesseAusgabedatei()
  {  
  out.close();
  }
}

