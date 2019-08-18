
public class Wettervorhersage4
{
	//Klassenattribute
	private double minTempDurch=0.0, maxTempDurch=0.0, niederschlagDurch=0.0, luftDurch=0.0, windDurch=0.0;
    //Objektattribute
    private Tagesvorhersage[] vorhersage;
    private String ort;
    //Zeigt auf den Index des ersten Tages
    private int ersterTag = 0;
    
    public Wettervorhersage4(String ort)
    {
    	this.ort = ort;
        //14-Tage-Trend
        vorhersage = new Tagesvorhersage[14];
        
        //Einzelne Tage initialisieren
        for(int i=0;i<vorhersage.length;i++)
        {
            vorhersage[i] = new Tagesvorhersage(zufall(-15, 15),zufall(16, 35),zufall(0, 100),zufall(10, 85),zufall(0, 100)); 
        }
    }

    //Naechste Vorhersage (Naechster Tag nach den 14 vorhandenen Vorhersagen) 
    public void neueVorhersage
      (int minTemp, int maxTemp, int niederschlag, int luft, int wind)
    {
        //Temporaer einen Eintrag erstellen
        Tagesvorhersage vorhersageTag = 
          new Tagesvorhersage(minTemp, maxTemp, niederschlag, luft, wind);       
        //Ersten Tag ueberschreiben
        vorhersage[ersterTag] = vorhersageTag;
        //Index erhoehen (Maximal bis Eintrag 13, daher Modulo 14)
        ersterTag = (ersterTag + 1) % 14;
        //Durchschnittwerte neu berechnen
        berechneDurchschnittswerte();
    }
    
    private void berechneDurchschnittswerte()
    {
       for(int i=0;i<vorhersage.length;i++)
        {
            minTempDurch = minTempDurch + vorhersage[i].getWerte()[0];  //Mindesttemperatur
            maxTempDurch = maxTempDurch + vorhersage[i].getWerte()[1]; //Hoechsttemperatur
            niederschlagDurch = niederschlagDurch + vorhersage[i].getWerte()[2]; //Niederschlagswahrscheinlichkeit
            luftDurch = luftDurch + vorhersage[i].getWerte()[3]; //Luftfeuchtigkeit
            windDurch = windDurch + vorhersage[i].getWerte()[4]; //Windgeschwindigkeit
        }
        minTempDurch = minTempDurch / 14;
        maxTempDurch = maxTempDurch / 14;
        niederschlagDurch = niederschlagDurch / 14;
        luftDurch = luftDurch / 14;
        windDurch = windDurch / 14;
    }
    
    public int[][] gibVorhersage()
    {
      int[][] temp = new int[14][5];
      for(int i=0;i<vorhersage.length;i++)
      {
        int index = (i+ersterTag)%14;
        temp[i] = new int[]{
    	  vorhersage[index].getWerte()[0],
          vorhersage[index].getWerte()[1],
          vorhersage[index].getWerte()[2],
          vorhersage[index].getWerte()[3],
          vorhersage[index].getWerte()[4]
        };
      }        
      return temp;
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
