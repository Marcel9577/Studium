public class ZaehlerUI
{
 public static void main(String args[])
 {
    //Attribute
    Zaehler einZaehler, klonZaehler =null; 
       
    Verbraucher einVerbraucher = new Verbraucher("Schulz"); 
    einZaehler = new Zaehler("Elektro", einVerbraucher, 123);
        
    //Klonen
    try
    {
     klonZaehler = einZaehler.clone();
    }
    catch(CloneNotSupportedException e)
    {
        System.out.println("Fehler");
    }
    System.out.println
    ("Z�hlerstand =  " 
     + einZaehler.getZaehlerstand()
     + " geh�rt zu Verbraucher " + 
     einZaehler.getMeinVerbraucher().getName());
        
    System.out.println
    ("Geklonter Z�hler: Z�hlerstand =  " 
     + klonZaehler.getZaehlerstand() 
     + " geh�rt zu Verbraucher " + 
     einZaehler.getMeinVerbraucher().getName());
     
     if (einZaehler.getMeinVerbraucher() == 
      klonZaehler.getMeinVerbraucher())
       System.out.println("Verbraucher identisch");
      else
       System.out.println("Verbraucher nicht identisch)");
     
    //----------------------------------------------
    
    Unterzaehler nocheinZaehler = 
     new Unterzaehler("Gas", einVerbraucher, 500);
    System.out.println
    ("Z�hlerstand =  " 
     + nocheinZaehler.getZaehlerstand()+
     " Unterz�hlerstand: " 
     + nocheinZaehler.getUnterzaehlerstand() 
     + " geh�rt zu Verbraucher " + 
     nocheinZaehler.getMeinVerbraucher().getName());
     
    //Klonen
    Unterzaehler klonUnterzaehler = null;
    try
    {
     klonUnterzaehler = nocheinZaehler.clone();
    }
    catch(CloneNotSupportedException e)
    {
        System.out.println("Fehler");
    }
    System.out.println
    ("GeklonterUnterz�hler: Z�hlerstand =  " 
     + nocheinZaehler.getZaehlerstand()+
    " Unterz�hlerstand: " 
    + nocheinZaehler.getUnterzaehlerstand() 
     + " geh�rt zu Verbraucher " 
     + nocheinZaehler.getMeinVerbraucher().getName());
  }
}