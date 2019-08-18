import java.util.ArrayList;
import java.util.List;

public class Flug 
{
    //Objektattribut
    private int flugnr;

    //Assoziation zu Buchung
    private List<Buchung> buchungen = new ArrayList<>();
    //Assoziation zu Sitzplatz
    private static final Sitzplatz[][] sitzplaetze;
    //Initialisierung der Sitzplaetze
    static 
    {
        //Einmalig pro Flug-Klasse wird gespeichert, welche
        //Sitzplaetze vorhanden sind (Reihe 13 ist nicht vorhanden)
        sitzplaetze = new Sitzplatz[18][];
        for(int i=1;i<=19;i++)
        {
            if(i==13) continue;
            if(i==19) 
            {   //Sonderfall: nur 2 Sitzplätze
                sitzplaetze[i-(i/14)-1] = new Sitzplatz[] 
                {
                    new Sitzplatz(i,'D'),
                    new Sitzplatz(i,'F')
                };
            }
            else 
            {
                sitzplaetze[i-(i/14)-1] = new Sitzplatz[] 
                {
                    new Sitzplatz(i,'A'),
                    new Sitzplatz(i,'C'),
                    new Sitzplatz(i,'D'),
                    new Sitzplatz(i,'F')
                };
            }
        }
    }
    
    public Flug(int flugnr)
    {
        this.flugnr = flugnr;
    }
    
    // /10/ Alle freien Plaetze ausgeben
    public String[] gibFreiePlaetze()
    {
        List<Sitzplatz> tmp = new ArrayList<>();
        for(int i=0;i<Flug.sitzplaetze.length;i++)
        {
            for(int ii=0;ii<Flug.sitzplaetze[i].length;ii++)
            {
                if(pruefeBuchungVorhanden(Flug.sitzplaetze[i][ii])==null)
                {
                    //Es wird das vorhandene Sitzplatz-Objekt genutzt
                    tmp.add(Flug.sitzplaetze[i][ii]);
                }
            }
        }
        return konvertiereSitzplatzZuString(tmp);
    }
       
    // /20/ Alle belegten Plaetze ausgeben
    public String[] gibBelegtePlaetze()
    {
        List<Sitzplatz> tmp = new ArrayList<>();
        for(Buchung b : buchungen) tmp.add(b.getSitzplatz());
        return konvertiereSitzplatzZuString(tmp);
    }
    
    // /30/ Sitzplatz buchen
    public boolean bucheSitzplatz(String sitzplatz)
    {
        Sitzplatz s = ermittleSitzplatz(sitzplatz);
        if(s==null){ return false; }
        if(pruefeBuchungVorhanden(s)==null)
        {
            buchungen.add(new Buchung(s));
            return true; 
        }
        return false;
    }
    
    // /40/ Sitzplatz stornieren
    public boolean storniereSitzplatz(String sitzplatz)
    {
        Sitzplatz s = ermittleSitzplatz(sitzplatz);
        if(s==null){ return false; }
        Buchung b = pruefeBuchungVorhanden(s);
        if(b!=null)
        {
            buchungen.remove(b);
            return true;
        }
        return false;
    }
    
    //Hilfsmethode fuer /10/
    private Buchung pruefeBuchungVorhanden(Sitzplatz sitzplatz)
    {
        for(Buchung b : buchungen) {
            if(b.getSitzplatz().equals(sitzplatz)) return b;
        }
        return null;
    }
    
    //Hilfsmethode fuer /10/ und /20/
    private String[] konvertiereSitzplatzZuString(List<Sitzplatz> sitzplaetze)
    {        
        //In String-Array kopieren
        String[] ergebnis = new String[sitzplaetze.size()];
        for(int i=0;i<sitzplaetze.size();i++) ergebnis[i] = sitzplaetze.get(i).toString();
        return ergebnis;
    }
    
    //Hilfsmethode fuer /30/ und /40/
    private Sitzplatz ermittleSitzplatz(String sitzplatz)
    {
        int reihe = 0;
        char buchstabe = 0;
        try
        {
            reihe = ermittleReihe(sitzplatz);
            buchstabe = ermittleBuchstabe(sitzplatz);
        }
        catch(Exception e){ return null; }
        
        //Grundsaetzlich pruefen, ob der Sitzplatz im Flugzeug vorhanden ist
        Sitzplatz tmp = new Sitzplatz(reihe, buchstabe);
        for(int i=0;i<Flug.sitzplaetze.length;i++) {
            for(int ii=0;ii<Flug.sitzplaetze[i].length;ii++) {
                if(Flug.sitzplaetze[i][ii].equals(tmp)) {
                    return Flug.sitzplaetze[i][ii];
                }
            }
        }
        return null;
    }
    
    //Hilfsmethode fuer /30/ und /40/
    private int ermittleReihe(String sitzplatz)
    {
        if(sitzplatz.length()==2) {
            return (Integer.valueOf(sitzplatz.substring(0,1)));
        }
        return (Integer.valueOf(sitzplatz.substring(0,2)));
    }
    
    //Hilfsmethode fuer /30/ und /40/
    private char ermittleBuchstabe(String sitzplatz)
    {
        return sitzplatz.toUpperCase().charAt(sitzplatz.length()-1);
    }
}
