 

public class WetterUI
{
    public static void main(String[] args)
    {
    }
    
    public static void ausfuehrenWettervorhersage1()
    {
        Wettervorhersage1 w1 = new Wettervorhersage1("Dortmund");
        WetterUI.ausgebenVorhersage(w1.gibVorhersage());
        WetterUI.ausgebenDurchschnittswerte(w1.gibDurchschnittswerte());
        
        w1.neueVorhersage(3, 10, 55, 66, 11);
        WetterUI.ausgebenVorhersage(w1.gibVorhersage());
        WetterUI.ausgebenDurchschnittswerte(w1.gibDurchschnittswerte());
    }

    public static void ausfuehrenWettervorhersage2()
    {
        Wettervorhersage2 w2 = new Wettervorhersage2("Dortmund");
        WetterUI.ausgebenVorhersage(w2.gibVorhersage());
        WetterUI.ausgebenDurchschnittswerte(w2.gibDurchschnittswerte());
        
        w2.neueVorhersage(3, 10, 55, 66, 11);
        WetterUI.ausgebenVorhersage(w2.gibVorhersage());
        WetterUI.ausgebenDurchschnittswerte(w2.gibDurchschnittswerte());
    }
    
    public static void ausfuehrenWettervorhersage3()
    {
        Wettervorhersage3 w3 = new Wettervorhersage3("Dortmund");
        WetterUI.ausgebenVorhersage(w3.gibVorhersage());
        WetterUI.ausgebenDurchschnittswerte(w3.gibDurchschnittswerte());
        
        w3.neueVorhersage(3, 10, 55, 66, 11);
        WetterUI.ausgebenVorhersage(w3.gibVorhersage());
        WetterUI.ausgebenDurchschnittswerte(w3.gibDurchschnittswerte());
    }
    
     public static void ausfuehrenWettervorhersage4()
    {
         Wettervorhersage4 w4 = new Wettervorhersage4("Dortmund");
         WetterUI.ausgebenVorhersage(w4.gibVorhersage());
         WetterUI.ausgebenDurchschnittswerte(w4.gibDurchschnittswerte());
         
         w4.neueVorhersage(3, 10, 55, 66, 11);
         WetterUI.ausgebenVorhersage(w4.gibVorhersage());
         WetterUI.ausgebenDurchschnittswerte(w4.gibDurchschnittswerte());
    }
    
    private static void ausgebenVorhersage(int[][] vorhersage)
    {
        System.out.println("Vorhersage");
        for(int i=0;i<vorhersage.length;i++)
        {
            System.out.print("Tag " + (i+1));
            System.out.print("\t"+vorhersage[i][0]+"°C");
            System.out.print("\t"+vorhersage[i][1]+"°C");
            System.out.print("\t"+vorhersage[i][2]+"% Niederschlag");
            System.out.print("\t"+vorhersage[i][3]+"% Luft");
            System.out.println("\t"+vorhersage[i][4]+"km/h Wind");
            
        }
    }
    
    private static void ausgebenDurchschnittswerte(double[] werte)
    {
        System.out.println("------------------------------------");
        System.out.println("Minimale Durchschnittstemperatur: " + werte[0]);
        System.out.println("Maximale Durchschnittstemperatur: " + werte[1]);
        System.out.println("Durchschnittliche Niederschlagswahrscheinlichkeit: " + werte[2]);
        System.out.println("Durchschnittliche Luftfeuchtigkeit: "+ werte[3]);
        System.out.println("Durchschnittliche Windgeschwindigkeit: " + werte[4]);
    }
}
