import inout.*;
public class DemoUeberdeckung
{
	public static void main (String args[])
	{
	    int x = 1;
	    if (x >= 1)
	       x = x + 1;
	       
	    boolean zweig1 = false,
	    zweig2 = false;
	    System.out.print("Zeichen = ");
	    char zchn = Console.readChar() ;
	    if (zchn == 'X')
	    {
	          System.out.println("X vorhanden");
	          zweig1 = true;
	    }
	    else
	    {
	     zweig2 = true;
	    }
	     
	    System.out.println("Zeichen = " + zchn);
	    System.out.println
	    ("Zweig 1 durchlaufen: " + zweig1);
	    System.out.println
	    ("Zweig 2 durchlaufen: " + zweig2);
	       
	}
	       
}
