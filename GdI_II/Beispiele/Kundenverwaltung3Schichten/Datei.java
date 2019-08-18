/* Programmname: Verwalten einer Datei
* Datenhaltungs-Klasse: Direktzugriffsspeicher
* Aufgabe: Lesen und Schreiben von S�tzen fester L�nge
* in einem Direktzugriffsspeicher
*/

import java.io.*;

public class Datei
{
    private RandomAccessFile eineStammdatei;
	private int aktuell; //aktuelle Position des Dateizeigers
	private final int SATZLAENGE = 100;
    private String dateiname = "Stammdatei.txt"; // dateiname
	//Konstruktor
    public Datei()
    {
        oeffneDatei(dateiname);  
    }
    //Methoden
    public void speichereSatz(String satz, int index) throws IOException
	{
	    //Speichert einen Datensatz Satz an einer Position index in der Datei
	    if(eineStammdatei != null)
        {
            positioniereAufSatz(index); //interne Hilfsoperation
            writeFixedString(satz, SATZLAENGE); //interne Hilfsoperation
        }
	}
	public String leseSatz(int index)throws IOException
	{
	    //Liest den Datensatz index aus der Datei und gibt ihn als String zur�ck
        if(eineStammdatei != null)
        {
            positioniereAufSatz(index); //interne Hilfsoperation
            return readFixedString(SATZLAENGE); //interne Hilfsoperation
        }
        else return null;
	}

	public void oeffneDatei(String name)
	{
	    //�ffnen der Datei zum Lesen und Schreiben
        try
        {
            eineStammdatei = new RandomAccessFile(name, "rw");
        }
        catch (IOException e)
        {
            //Testausgabe
            System.out.println("Datei:oeffneDatei: " + e);
        }
    }
    public void schliesseDatei()
    {
	    // Schlie�en der Datei
        try
        {
            eineStammdatei.close();
        }
        catch (java.io.IOException e)
        {
            //Testausgabe
            System.out.println("Datei:schliesseDatei: " + e);  
        }
    }
    public int gibAnzahlDatensaetze()
    {
        // R�ckgabe der Dateil�nge in Datens�tzen (!)
        long anzahl=0;
        try 
        {
            anzahl = eineStammdatei.length();
        } 
        catch (IOException e)
        {
            //Testausgabe
            System.out.println("Datei:gibAnzahlDatensaetze: " + e);    
        }
        return (int)(anzahl / (long)(SATZLAENGE * 2));
        //Umrechnung auf Anzahl Datens�tze
    }
    //Hilfsoperationen ------------------------------------------
    private void positioniereAufSatz(int index)throws IOException
    {
        // Positioniert in der Datei auf den 
        // Datensatz mit der Position index
        if(eineStammdatei != null)
        {
            try
            {
                //f�r 1 char werden 2 bytes ben�tigt
                eineStammdatei.seek(index * SATZLAENGE * 2);
                
            }
            catch(IOException e)
            {
                //Testausgabe
                System.out.println(
                 "Datei:positioniereAufSatz: " + e); 
            }
        }
    }
    private String readFixedString(int laenge)
     throws IOException
    {
        // Liest einen String der festen L�nge laenge 
        //(Unicode = 1 Zeichen = 2 Byte) ein
        StringBuilder einPuffer = new StringBuilder(laenge);
        int i = 0;
        while(i < laenge)
        {
            char Zeichen = eineStammdatei.readChar();
            i++;
            if(Zeichen == 0) //Ende der Nutzdaten
            {
                //eineStammdatei.skipBytes(2*(laenge-i));
                //Rest mit 0 �berlesen
                //wird ben�tigt, wenn hinter dem String 
                //z.B. noch Zahlen kommen
                return einPuffer.toString();
            }
            else einPuffer.append(Zeichen);
            //Anh�ngen an den Puffer
        }
        return einPuffer.toString();
    }
    private void writeFixedString(String einDatensatz, int laenge) 
     throws IOException
    {
        // Schreibt einen String einDatensatz der 
        //festen L�nge laenge weg
        for(int i = 0; i < laenge; i++)
        {
            char Zeichen = 0;
            if(i < einDatensatz.length()) 
                Zeichen = einDatensatz.charAt(i); 
                //liefert das Zeichen an der i-ten Stelle
            //Der Rest wird mit 0 aufgef�llt
            eineStammdatei.writeChar(Zeichen); 
            //zeichenweises Schreiben in die Stammdatei
        }
    }
    // Zum Testen
    public void gibDatensaetzeAus()
    {
        int anzahl = gibAnzahlDatensaetze();
        System.out.println("Anzahl der Datens�tze: " + anzahl);
        for (int i = 0; i < anzahl; i++)
        {
            try
            {
            System.out.println(leseSatz(i));
            }
            catch (IOException e)
            {
                System.out.println
                 ("Fehler beim Satzlesen: " + e);
            }
        }
    }
}
