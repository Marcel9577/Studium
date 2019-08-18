import inout.Console;
import java.util.ArrayList;

import java.util.List;

public class ReservierungUI
{
    private static final List<Flug> fluege = new ArrayList<>();
    
    static
    {
        //366 Fluege initialisieren
        //Zugriff ueber Index {1..365}, Index 0 wird nicht verwendet
        for(int i=0;i<366;i++) fluege.add(new Flug(i));
    }
    
    public static void main(String[] args)
    {
        //Benutzereingaben
        char eingabeAuswahl = 0;
        String eingabePlatz = "";
        int eingabeTag = 0;

        //Weitere Variablen
        String[] diePlaetze;
        boolean erfolg;
    
        for(;;)
        {
            //Flugtag auswaehlen
            System.out.println("Bitte waehlen Sie einen Tag [1...365]");
            for(;;)
            {
                eingabeTag = Console.readInt();
                if(eingabeTag<1 || eingabeTag>365)
                {
                    System.out.println("Bitte nur Tage zwischen 1 und 365 eingeben.");
                }
                else
                {
                    break;
                }
            }

            //Funktion auswaehlen
            System.out.println("Bitte Funktion auswählen:"); 
            System.out.println("1: Alle freien Plätze anzeigen");
            System.out.println("2: Alle belegten Plätze anzeigen");
            System.out.println("3: Sitzplatz buchen");
            System.out.println("4: Sitzplatz stornieren");
            System.out.println("Abbruch: 9");
            System.out.println("Bitte Ziffer 1, 2, 3, 4 oder 9 eingeben:");
            eingabeAuswahl = Console.readChar();

            //Funktionseingabe verarbeiten
            if(eingabeAuswahl=='9') break;

            //Sitzplatz auswaehlen
            if(eingabeAuswahl=='3' || eingabeAuswahl=='4')
            {
                System.out.println("Reihe + Platzbuchstabe, z.B. 11C");
                eingabePlatz = Console.readString();
            }

            switch (eingabeAuswahl) 
            {  
                case '1': 
                {
                    diePlaetze = fluege.get(eingabeTag).gibFreiePlaetze();
                    druckePlaetze("Sitzplan ", diePlaetze);
                    break;
                }
                case '2': 
                {
                    diePlaetze = fluege.get(eingabeTag).gibBelegtePlaetze();
                    druckePlaetze("Sitzplan ", diePlaetze);
                    break;
                }
                case '3': 
                {
                    erfolg = fluege.get(eingabeTag).bucheSitzplatz(eingabePlatz);
                    if (erfolg)
                    {
                        System.out.println("Sitzplatz " + eingabePlatz + " erfolgreich reserviert");
                    }
                    else
                    {
                        System.out.println("Sitzplatz " + eingabePlatz + " konnte NICHT reserviert werden");
                    }
                    break;
                }
                case '4': 
                {
                    erfolg = fluege.get(eingabeTag).storniereSitzplatz(eingabePlatz);
                    if (erfolg)
                    {
                        System.out.println("Sitzplatz " + eingabePlatz + " erfolgreich storniert");
                    }
                    else
                    {
                        System.out.println("Sitzplatz " + eingabePlatz + " konnte NICHT storniert werden");
                    }
                    break;
                }
                default:
                    System.out.println("Fehlerhafte Eingabe: Bitte nur 1, 2, 3, 4 oder 9 eingeben"); 
            }
        }
        System.out.println("Ende des Programms");
    }

    private static void druckePlaetze(String ueberschrift, String[] diePlaetze)
    {
        System.out.println(ueberschrift);  
        for (String s : diePlaetze)
        {
            System.out.println(s);
        }
        System.out.println("----------------------------");
    }
}
