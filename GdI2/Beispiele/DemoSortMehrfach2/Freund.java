import java.util.Comparator;

public class Freund 
 implements Comparable<Freund>
{
	private String nachname, vorname;
	private int alter;
	
    public Freund(String nachname, String vorname, int alter)
	{
	    this.nachname = nachname;
	    this.vorname = vorname;
	    this.alter = alter;
	}
	public String getNachname()
	{
	    return nachname;
	}
	public String getVorname()
	{
	    return vorname;
	}
	public int getAlter()
	{
	    return alter;
	}
	//Standardsortierung nach Nachname
    public int compareTo(Freund einFreund)throws ClassCastException
    {
       if (this.nachname.compareTo(einFreund.getNachname()) > 0)
         return 1;
       else 
         return -1;
   }    

   //Anonyme eingeschachtelte Klassen ------------------
   public static final Comparator<Freund> vornameComparator =
    new Comparator<Freund>()
   {
    public int compare(Freund freund1, Freund freund2) 
    {
     String vorname1 = freund1.getVorname();
     String vorname2 = freund2.getVorname();
     return vorname1.compareTo(vorname2);
    }
   };
   public static final Comparator<Freund> alterComparator =
    new Comparator<Freund>()
   {
	public int compare(Freund freund1, Freund freund2) 
	{
      int alter1 = freund1.getAlter();
      int alter2 = freund2.getAlter();
      return alter1 - alter2;
    }
   };
}
