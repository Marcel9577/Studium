/* Programmname: Kundenverwaltung mit Datenhaltung
* Container-Klasse: KundenContainer
* Aufgabe: Verwaltung von Objekten der Klasse Kunde
* Datenhaltung: Indizierte Organisation mit physisch sortiertem Index
* Muster: Singleton
* Iterator: Interface Iterator
* Annahmen: Der Aufrufer muss selbst pr�fen, ob ein �bergebenes Objekt
* vom Typ Kunde null ist oder nicht
*/
import java.io.*;
import java.util.*;

class KundenContainer implements Iterator
{
 //Attribute f�r den Iterator
 private int aktuelleNr = 0;
 private final int NR_MAX = 1000;
 //Attribute f�r die Datenhaltung
 private Index derIndex;
 private Datei dieDatei;
 //Klassen-Attribut
 private static KundenContainer 
   einKundenContainer = null; 
 //Speichert Referenz auf das einzige Objekt
 
 //Konstruktor, von au�en nicht zugreifbar
 private KundenContainer()
 { 
   oeffneDateien();
 }
 //Klassen-Operation, die die Objektreferenz liefert
 //Wenn Objekt noch nicht vorhanden, dann wird es erzeugt
 public static KundenContainer getObjektreferenz()
 {
  if (einKundenContainer == null)
	 einKundenContainer = new KundenContainer(); 
	 //Konstruktor, kann nur einmal aufgerufen werden
	 return einKundenContainer;
 }
 //-----------------------------------------------
 //�ffentliche Methoden
  public void einfuegeKunde
   (Kunde einKunde, int kdnnr)
  {
    //Aufbau eines Datensatzes als Zeichenkette
    //Die einzelnen Teile sind durch Tab getrennt
    //kdnnr = kundennummer
    String datensatz = 
     Integer.toString(kdnnr) + "\t"
      + einKunde.getName() + "\t"
      + einKunde.getTelefon() + "\t"
      + Integer.toString(einKunde.getBlz())+ "\t"
      + Integer.toString(einKunde.getKontonr());
      
    int index = derIndex.gibIndexZuSchluessel(kdnnr);
    System.out.println("einfuege Kunde: Index = " + index);
    if (index != -1)
    {
        System.out.println
        ("Datensatz schon vorhanden: " + kdnnr + " " + index);
        //�berschreibt den vorhandenen Datensatz in der Hauptdatei
        try
        {
          dieDatei.speichereSatz(datensatz, index);
        }
        catch (IOException e)
        {
         System.out.println("Fehler bei speichereSatz: " + e);
        }
    }
    else //Datenatz ist neu, hinten anh�ngen
    {
      //Anzahl Datens�tze in Datei ermitteln, 
      //daraus neuen Index ermitteln
      index = dieDatei.gibAnzahlDatensaetze();
      System.out.println
      ("schreibeDatensatz: AnzahlDatens�tze = Index: " + index);
      //Schreibt den Index in die Indexdatei
      //Die nr ist der Schl�ssel
      try
      {
       derIndex.erzeugeEintrag(kdnnr, index);
      }
      catch (IOException e)
      {
        System.out.println("Fehler bei erzeugeEintrag: " + e);
      }
      //Speichert einen Datensatz in der Hauptdatei
      try
      {
        dieDatei.speichereSatz(datensatz, index);
      }
      catch (IOException e)
      {
        System.out.println
        ("Fehler bei speichereSatz: " + e);
      }
    }
  }
 //-----------------------------------------------
 public Kunde gibKunde(int kdnnr)
 {
    
    String einKundensatz = "";
    einKundensatz = leseDatensatz(kdnnr);
    if(einKundensatz==null)return null;
    Scanner einScanner = 
         new Scanner(einKundensatz).useDelimiter("\\t");
        String nr = einScanner.next();
        //identisch mit Kundennr, daher �berlesen
        String name = einScanner.next();
        String telefon = einScanner.next();
        String blz = einScanner.next();
        Integer blzInt = new Integer(blz);
        String kontonr = einScanner.next();
        Integer kontonrInt = new Integer(kontonr);
        //Neues Objekt mit den gespeicherten Daten erzeugen
        return new Kunde(kdnnr, name, telefon, blzInt.intValue(), 
         kontonrInt.intValue());
 }
 //-----------------------------------------------
 public void endeAnwendung()
 {
        schliesseDateien();
 }
 
 //Implementierung der Schnittstelle Iterator
 public boolean hasNext()
 {
    //Pr�fen, ob in der Indexdatei noch Datensatz-Indizes 
    //gespeichert sind
    //L�cken sind m�glich; gekennzeichnet durch Index = -1
    while (aktuelleNr < NR_MAX)
    {
       int index = derIndex.gibIndexZuSchluessel(aktuelleNr);
       aktuelleNr++;
       if (index != -1)
            return true;
    }
    aktuelleNr = 0;
    return false;
 }
 public Object next()
 {
    //Voraussetzung: es wurde mit hasNext gepr�ft, 
    //dass noch ein Element da ist
    return gibKunde(aktuelleNr-1);
 }
 public void remove()
 {
     throw new UnsupportedOperationException();
 }
 //Private Methoden f�r die Datenhaltung
 //Nehmen die Methoden der Klassen Datei und Index in Anspruch
 private void oeffneDateien()
 {
	//Deklarieren und Initialisieren der Indextabelle
    derIndex = new Index();
	try
	{
	 //Indexdatei �ffnen und Indextabelle laden
	 derIndex.ladeIndexDatei();
    }
	catch (IOException e)
    {
     try //Wenn nicht vorhanden, dann neu anlegen
     {
       derIndex.speichereIndexDatei();
     }
     catch (IOException e1)
     {
        System.out.println
         ("Fehler beim Anlegen der Indexdatei");
     }
     System.out.println
      ("Indexdatei nicht vorhanden, wird neu angelegt");
    }
     //Hauptdatei �ffnen
     dieDatei = new Datei();
  }
 //-----------------------------------------------
  private void schliesseDateien()
  {
    if(derIndex != null)
    {
        try
        {
            //Indexdatei speichern
            derIndex.speichereIndexDatei();
        }
        catch(IOException e)
        {
            System.out.println
            ("Probleme beim Schlie�en der Indexdatei " + e);
        }
        //Schlie�en der Hauptdatei
        if (dieDatei != null)
            dieDatei.schliesseDatei();
    }
  }
 //-----------------------------------------------
 private String leseDatensatz(int kdnnr)
 {
    String datensatz = "";
    int index = derIndex.gibIndexZuSchluessel(kdnnr);
    if (index != -1)//Ein Datensatz-Index ist vorhanden
    {
        try
        {
            datensatz = dieDatei.leseSatz(index);
        }
        catch (IOException e)
        {
            System.out.println
            ("leseDatensatz: Kein Datensatz vorhanden: Index = " 
             + index);
        }
        return datensatz;
    }
    else
        return null;
 }
 //Zum Testen
 public void gibIndexAus()
 {
     derIndex.gibIndextabelleAus();
 }
 //Zum Testen
 public void gibKundenAus()
 {
     dieDatei.gibDatensaetzeAus();
 }
}
