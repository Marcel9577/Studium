//Klasse Artikel verwaltet
//n Anbieter-Referenzen

import java.util.*;

public class Artikel
{
    private int artikelnr;
    //Verwaltung der Assoziation
    //anbieter ist Rollenname
    //des Lieferanten in der Assoziation
    private ArrayList<Lieferant> anbieter = new ArrayList<>();

    public Artikel(int artikelnr)
    {
        this.artikelnr = artikelnr;
    }
    public int getArtikelnr()
    {
        return artikelnr;
    }

    //Assoziationsoperationen
    //Verbindung zu Anbieter herstellen
    public void setLinkAnbieter(Lieferant einAnbieter)
    {
        if (!anbieter.contains(einAnbieter))
        { 
          //Einen Anbieter hinzuf�gen
          anbieter.add(einAnbieter);
          //Beim Anbieter daf�r sorgen, dass
          //dort der Artikel eingetragen wird
          einAnbieter.setLinkArtikel(this);
        } 
    }
    //Verbindung zu Anbieter l�schen
    public void removeLinkAnbieter(Lieferant einAnbieter)
    {
       anbieter.remove(einAnbieter);
    }
    //Liefert alle Anbieter eines Artikels
    public ArrayList<Lieferant> gibAlleAnbieter()
    {
        return anbieter;
    }
}