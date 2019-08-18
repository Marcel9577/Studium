import java.io.*;

public class Index
{
    //Attribute
    private final int MAX = 10;
    private String dateiname = "Indexdatei.txt";
    private int indextabelle[]; //0..MAX-1
    private RandomAccessFile eineIndexDatei;
    //Konstruktor
    public Index()
    {
	indextabelle = new int[MAX];
	//Initialisierung der indextabelle
	for (int i = 0; i < MAX; i++) indextabelle[i] = -1; 
	//Kein Datensatz zum Schl�ssel vorhanden
    }
    //Methoden
    public void erzeugeEintrag(int schluessel, int index) 
	throws IOException
    {
	/**Speichert zu einem Schl�ssel den zugeh�rigen 
	 * Datensatz-Index in der indextabelle */
	if(schluessel < MAX) 
	    indextabelle[schluessel] = index;
	//Aktualisieren der Indexdatei, 
	//d.h. Abspeichern der Datei
	aktualisiereIndexDatei(schluessel);
    }
    public int gibIndexZuSchluessel(int schluessel)
    {
	//Gibt zu dem Schl�ssel den gefundenen 
	//Datensatz-Index zur�ck
	if(schluessel < MAX) 
	    return indextabelle[schluessel];
	// oder 0, wenn Schl�ssel zu gro� ist
	else 
	    return -1;
    }
    public void ladeIndexDatei() throws IOException
    {
	/**Liest die Indextabelle vollst�ndig aus einer Datei
	 * Dies geschieht nur beim Start des Programms */
	eineIndexDatei = new RandomAccessFile(dateiname, "r");
	int index;
	for(int schluessel = 0; schluessel < MAX; schluessel++)
	    {
		index = eineIndexDatei.readInt();
		indextabelle[schluessel] = index;
	    }
	eineIndexDatei.close();
    }
    public void speichereIndexDatei()throws IOException
    {
	/**Speichert die Indextabelle vollst�ndig in einer Datei
	 * Dies geschieht beim Beenden des Programms */
	eineIndexDatei = new RandomAccessFile(dateiname, "rw");
	for (int schluessel=0; schluessel < MAX; schluessel++)
	    eineIndexDatei.writeInt(indextabelle[schluessel]);
	eineIndexDatei.close();
    }
    private void aktualisiereIndexDatei(int schluessel)
	throws IOException
    {
	/** Aktualisiert die Indextabelle in der Indexdatei
	 * Dies geschieht beim Hinzuf�gen eines neuen 
	 * Indexes oder �ndern eines alten Indexes */
	eineIndexDatei = new RandomAccessFile(dateiname, "rw");
	//Positionieren auf den entsprechenden Eintrag; 
	//eine int-Zahl belegt 4 Bytes
	eineIndexDatei.seek((long)(schluessel*4)); 
	eineIndexDatei.writeInt(indextabelle[schluessel]);
	eineIndexDatei.close();
    }
    //Zum Testen
    public void gibIndextabelleAus()
    {
	int schluessel = 0;
	for (int element : indextabelle)
	    {
		System.out.println(schluessel + "  " + element);
		schluessel ++;
	    }
    }
}