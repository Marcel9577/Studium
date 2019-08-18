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
     ("Testf�lle A bis F ********************");  
   //�bernahme des Namens der Eingabedatei von args[0]
   String filenameIn = args[0];
   //�bernahme des Namens der Ausgabedatei von args[1]
   String filenameOut = args[1];

   //Dateien �ffnen
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
      //F�r jeden Testfall Objekt neu anlegen
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
    zeile = FileIn.gibNaechsteZeile(); //n�chster Testfall
   }//Ende while
   int [] ueberdeckung = Konto.getDurchlauf();
   for (int i = 0; i < ueberdeckung.length; i++)
     System.out.println
       ("Test�berdeckung Zweig " + i 
         + ": " + ueberdeckung[i]);

    FileIn.schliesseEingabedatei();
  
    System.out.println
      ("Testf�lle G bis J f�r buchen() von Sparkonto********************");
    //�bernahme des Namens der Eingabedatei von args[2]
    filenameIn = args[2];
    //Datei �ffnen
    FileIn.oeffneEingabedatei(filenameIn);
    zeile = FileIn.gibNaechsteZeile();
   
    while (zeile != null)
    {
      try
      {
        sc = new Scanner(zeile);
        testfall = sc.next();
        int betrag = sc.nextInt(); //Einlesen Testfall 
        //F�r jeden Testfall erneut Objekt anlegen
        //Feste Werte f�r Konto-Objekt, kontonr = 22
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
       ("Test�berdeckung Zweig " + i 
        + ": " + ueberdeckung[i]);
    ueberdeckung = Sparkonto.getDurchlauf();
    for (int i = 0; i < ueberdeckung.length; i++)
      System.out.println
       ("Test�berdeckung Zweig Spar " + i 
        + ": " + ueberdeckung[i]);
    FileOut.schliesseAusgabedatei();
    FileIn.schliesseEingabedatei();
  }
}