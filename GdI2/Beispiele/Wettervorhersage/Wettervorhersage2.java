 

import java.util.ArrayList;
import java.util.List;

public class Wettervorhersage2
{
	//Klassenattribute
	private double minTempDurch=0.0, maxTempDurch=0.0, niederschlagDurch=0.0, luftDurch=0.0, windDurch=0.0;
    //Objektattribute
	private ArrayList<int[]> vorhersage = null;
	private String ort;
    
    public Wettervorhersage2(String ort)
    {
    	this.ort = ort;
        //14-Tage-Trend
    	vorhersage = new ArrayList<int[]>();
       
       //Einzelne Tage initialisieren
    	for(int i=0;i<14;i++)
    	{
    		vorhersage.add(new int[]
    		{
    			zufall(-15, 15), //Mindesttemperatur
    			zufall(16, 35), //Hoechsttemperatur
    			zufall(0, 100), //Niederschlagswahrscheinlichkeit
    			zufall(10, 85), //Luftfeuchtigkeit
    			zufall(0, 100) //Windgeschwindigkeit
    		});
    	}
       berechneDurchschnittswerte();
    }
    
    private void berechneDurchschnittswerte()
    {
       for(int i=0;i<vorhersage.size();i++)
        {
            minTempDurch = minTempDurch + vorhersage.get(i)[0];  //Mindesttemperatur
            maxTempDurch = maxTempDurch + vorhersage.get(i)[1]; //Hoechsttemperatur
            niederschlagDurch = niederschlagDurch + vorhersage.get(i)[2]; //Niederschlagswahrscheinlichkeit
            luftDurch = luftDurch + vorhersage.get(i)[3]; //Luftfeuchtigkeit
            windDurch = windDurch + vorhersage.get(i)[4]; //Windgeschwindigkeit
        }
        minTempDurch = minTempDurch / 14;
        maxTempDurch = maxTempDurch / 14;
        niederschlagDurch = niederschlagDurch / 14;
        luftDurch = luftDurch / 14;
        windDurch = windDurch / 14;
    }
    
    //Naechste Vorhersage (Naechster Tag nach den 14 vorhandenen Vorhersagen) 
    public void neueVorhersage
      (int minTemp, int maxTemp, int niederschlag, int luft, int wind)
    {
    	//Ersten Eintrag entfernen
    	vorhersage.remove(0);
    	//Neuen Eintrag ans Ende haengen
    	vorhersage.add(new int[]{minTemp, maxTemp, niederschlag, luft, wind});
        //Durchschnittwerte neu berechnen
        berechneDurchschnittswerte();
    }

     public int[][] gibVorhersage()
     {
         return vorhersage.toArray(new int[14][5]);
     }
     
     public double[] gibDurchschnittswerte()
     {
       return new double[]{minTempDurch, maxTempDurch, niederschlagDurch, luftDurch, windDurch};   
     }

     //Zufallszahl in einem Bereich ermitteln
     private int zufall(int min, int max)
     {
         return min+(int)(Math.floor(Math.random()*(max-min)));
     }
}
