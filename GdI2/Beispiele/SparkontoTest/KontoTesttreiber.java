import java.io.*;
import java.util.*;

class KontoTesttreiber
{ 
   static int kontostand; //Angaben in Cent
   static Sparkonto einKonto = null; //Sparkonto
 
  public static void main (String args[]) 
  { 
   int kontonr;
   int ersteZahlung;
   System.out.println
     ("Testfälle A bis F ********************");  
   //Übernahme des Namens der Eingabedatei von args[0]
   String filenameIn = args[0];
   //Übernahme des Namens der Ausgabedatei von args[1]
   String filenameOut = args[1];

   //Dateien öffnen
   FileIn.oeffneEingabedatei(filenameIn);
   FileOut.oeffneAusgabedatei(filenameOut);
   //Einlesen 1. Testfall
   String zeile = FileIn.gibNaechsteZeile();
   Scanner sc; 
   String testfall = " ";
   
   while (zeile != null)
   {
     sc = new Scanner(zeile);
     //Separieren der Textzeile
     testfall = sc.next();
     kontonr = sc.nextInt();
     ersteZahlung = sc.nextInt();
     try
     {
      //Für jeden Testfall Objekt neu anlegen
      einKonto = new Sparkonto(kontonr, ersteZahlung);
      kontostand = einKonto.getKontostand();
      String testergebnis = 
       testfall + ": " + Integer.toString(kontostand);
      //Ergebnis in Datei schreiben
      FileOut.schreibeNaechsteZeile(testergebnis);
     
      System.out.println("Testfall: " + testfall 
       + " -------------");
      System.out.print("Kontonr: " + kontonr);
      System.out.print(" | 1. Zahlung: " + ersteZahlung);
      System.out.println(" | Kontostand: " + kontostand);
    }
    catch (Exception e)
    {
     FileOut.schreibeNaechsteZeile(testfall + ": Fehler");
     System.out.println("Testfall: " + testfall 
        + " -------------");
     System.out.print("Kontonr: " + kontonr);
     System.out.print(" | 1. Zahlung: " + ersteZahlung);
     System.out.println(" | Fehler: \n" + e.getMessage());
    }
    zeile = FileIn.gibNaechsteZeile(); //nächster Testfall
   }//Ende while
   int [] ueberdeckung = Konto.getDurchlauf();
   for (int i = 0; i < ueberdeckung.length; i++)
     System.out.println
       ("Testüberdeckung Zweig " + i 
         + ": " + ueberdeckung[i]);

    FileIn.schliesseEingabedatei();
  
    System.out.println
      ("Testfälle G bis J für buchen() von Sparkonto********************");
    //Übernahme des Namens der Eingabedatei von args[2]
    filenameIn = args[2];
    //Datei öffnen
    FileIn.oeffneEingabedatei(filenameIn);
    zeile = FileIn.gibNaechsteZeile();
   
    while (zeile != null)
    {
      try
      {
        sc = new Scanner(zeile);
        testfall = sc.next();
        int betrag = sc.nextInt(); //Einlesen Testfall 
        //Für jeden Testfall erneut Objekt anlegen
        //Feste Werte für Konto-Objekt, kontonr = 22
        //ersteZahlung = 100 Cent
        einKonto = new Sparkonto(22, 100);
        einKonto.buchen(betrag);
        kontostand = einKonto.getKontostand();
        String testergebnis = testfall + ": " 
         + Integer.toString(kontostand);
        FileOut.schreibeNaechsteZeile(testergebnis);
        System.out.print("Testfall: " 
         + testfall + " -------------");
        System.out.println("Kontostand: " 
         + kontostand);
       }
       catch (Exception e)
       {
         FileOut.schreibeNaechsteZeile
           (testfall + ": Fehler");
         System.out.print
           ("Testfall: " + testfall + " -------------");
         System.out.println
           ("Fehler: \n" + e.getMessage());
       }
       zeile = FileIn.gibNaechsteZeile();
    } //Ende while
    ueberdeckung = Konto.getDurchlauf();
    for (int i = 0; i < ueberdeckung.length; i++)
      System.out.println
       ("Testüberdeckung Zweig " + i 
        + ": " + ueberdeckung[i]);
    ueberdeckung = Sparkonto.getDurchlauf();
    for (int i = 0; i < ueberdeckung.length; i++)
      System.out.println
       ("Testüberdeckung Zweig Spar " + i 
        + ": " + ueberdeckung[i]);
    FileOut.schliesseAusgabedatei();
    FileIn.schliesseEingabedatei();
  }
}