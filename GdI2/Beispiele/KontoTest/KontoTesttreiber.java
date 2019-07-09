import java.util.*;

class KontoTesttreiber
{ 
  /**
  * Durchf�hrung einer Testreihe.
  * @param inFile
  * @param outFile
  * @param testfall Welcher Testfall soll ausgef�hrt werden.
  */
  private static void testreihe
    (FileIn inFile, FileOut outFile, String testfall)
  {    
    String zeile = inFile.gibNaechsteZeile();
    while (zeile != null)
    {
      if (testfall.equals("KontoKonstruktor"))
        KontoTesttreiber.testfallKonto(zeile, outFile);
      if (testfall.equals("KontoBuchen"))
        KontoTesttreiber.testfallBuchen(zeile, outFile);
      zeile = inFile.gibNaechsteZeile(); //n�chster Testfall
    } //Ende while
    int [] ueberdeckung = Konto.getDurchlauf();
    for (int i = 0; i < ueberdeckung.length; i++)
      System.out.println
        ("Test�berdeckung Zweig " + i 
        + ": " + ueberdeckung[i]);
  }
  
  /**
  * Durchf�hrung eines Testfalls f�r den Konstruktor 
  * Konto().
  * @param zeile
  * @param outFile
  */
  private static void testfallKonto
    (String zeile, FileOut outFile)
  {
    int kontonr, kontostand, ersteZahlung;
    Konto einKonto;
    Scanner sc;
    String testfall = " ";
    sc = new Scanner(zeile);
    //Separieren der Textzeile
    testfall = sc.next();
    kontonr = sc.nextInt();
    ersteZahlung = sc.nextInt();
    try
    {
      //F�r jeden Testfall Objekt neu anlegen
      einKonto = new Konto(kontonr, ersteZahlung);
      kontostand = einKonto.getKontostand();
      String testergebnis = testfall + ": " + kontostand;
      //Ergebnis in Datei schreiben
      outFile.schreibeNaechsteZeile(testergebnis);

      System.out.println("Testfall: " + testfall + " --");
      System.out.print("Kontonr: " + kontonr);
      System.out.print(" | 1. Zahlung: " + ersteZahlung);
      System.out.println(" | Kontostand: " + kontostand);
    } 
    catch (Exception e)
    {
      outFile.schreibeNaechsteZeile(testfall + ": Fehler");
      System.out.println("Testfall: " + testfall + " --");
      System.out.print("Kontonr: " + kontonr);
      System.out.print(" | 1. Zahlung: " + ersteZahlung);
      System.out.println(" | Fehler: \n" + e.getMessage());
    }
  }
    
  private static void testfallBuchen
    (String zeile, FileOut outFile)
  {
    int kontostand;
    Konto einKonto;
    Scanner sc;
    String testfall = " ";
    try
    {
      sc = new Scanner(zeile);
      testfall = sc.next();
      int betrag = sc.nextInt(); //Einlesen Testfall 
      //F�r jeden Testfall erneut Objekt anlegen
      //Feste Werte f�r Konto-Objekt, kontonr = 22
      //ersteZahlung = 100 Cent
      einKonto = new Konto(22, 100);
      einKonto.buchen(betrag);
      kontostand = einKonto.getKontostand();
      String testergebnis = testfall + ": " 
        + Integer.toString(kontostand);
      outFile.schreibeNaechsteZeile(testergebnis);
      System.out.print("Testfall: " 
        + testfall + " -------------");
      System.out.println("Kontostand: " 
        + kontostand);
    }
    catch (Exception e)
    {
      outFile.schreibeNaechsteZeile(testfall + ": Fehler");
      System.out.print("Testfall: " + testfall + " --");
      System.out.println("Fehler: \n" + e.getMessage());
    }
  }
   
  public static void main(String args[])
  {
    System.out.println("Testf�lle A bis F **************");

    //�bernahme des Namens der Eingabedatei von args[0]
    String filenameIn = args[0];
    //Eingabedatei �ffnen
    FileIn inFile = new FileIn(filenameIn);

    //�bernahme des Namens der Ausgabedatei von args[1]
    String filenameOut = args[1];
    // Ausgabedatei �ffnen
    FileOut outFile = new FileOut(filenameOut);

    //Testreihe aufrufen
    KontoTesttreiber.testreihe
      (inFile, outFile, "KontoKonstruktor");

    //Eingabedatei schlie�en
    inFile.schliesseEingabedatei();

    System.out.println("Testf�lle G bis J **************");

    //�bernahme des Namens der Eingabedatei von args[2]
    filenameIn = args[2];
    //Datei �ffnen
    inFile = new FileIn(filenameIn);

    //Testreihe aufrufen
    KontoTesttreiber.testreihe
      (inFile, outFile, "KontoBuchen");

    inFile.schliesseEingabedatei();
    outFile.schliesseAusgabedatei();
  }
}