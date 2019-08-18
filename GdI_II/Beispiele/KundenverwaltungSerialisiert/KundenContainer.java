/* Programmname: Kundenverwaltung
* Container-Klasse: KundenContainer
* Aufgabe: Verwaltung von Objekten der Klasse Kunde
* Verwaltungsmechanismus: ArrayList
* Muster: Singleton
* Iterator: integriert
* Annahmen: Der Aufrufer muss selbst prüfen, ob ein übergebenes Objekt
* vom Typ Kunde null ist oder nicht
*/

import java.util.*;

public class KundenContainer implements Iterable
{
	//Attribut 
	private ArrayList<Kunde> meineKunden;
	private ObjektDatei eineObjektDatei;
	
	//Klassen-Attribut
	private static KundenContainer einKundenContainer = null; 
	
    //Konstruktor, von außen nicht zugreifbar
	private KundenContainer()
	{
	   eineObjektDatei = new ObjektDatei("Kundendatei.xml");
	   Thread.currentThread().setContextClassLoader(getClass().getClassLoader()); 
	   //ArrayList-Objekt einlesen
	   meineKunden = (ArrayList<Kunde>)eineObjektDatei.leseObjekt();
       //Wenn die Daten nicht eingelesen werden können,
       //dann wird mit einer leeren ArrayList begonnen
       if (meineKunden == null)
       {
           System.out.println("ArrayList neu anlegen"); 
           meineKunden = new ArrayList<>();
       }
	}
	//Klassen-Methode, die die Objektreferenz liefert
	//Wenn Objekt noch nicht vorhanden, dann wird es erzeugt
	public static KundenContainer getObjektreferenz()
	{
	    if (einKundenContainer == null)
	           einKundenContainer = new KundenContainer(); 
	    return einKundenContainer;
	}
	//Methoden
	public void einfuegeKunde(Kunde einKunde)
	{
	    meineKunden.add(einKunde);   
	}

	public Kunde gibKunde(int kundennr)
	{
	    System.out.println(meineKunden.size());
	   for(int i = 0; i <meineKunden.size(); i++)
		{
		    Kunde kunde = meineKunden.get(i);
		   if(kunde.getNummer() == kundennr) return kunde;
		}   
	    return null;
	}
    
    public void endeAnwendung()
    {
        eineObjektDatei.speichereObjekt(meineKunden);
    }
  public Iterator iterator()
  {
    return meineKunden.iterator();
  }
}   
