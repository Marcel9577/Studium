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
    ("Zählerstand =  " 
     + einZaehler.getZaehlerstand()
     + " gehört zu Verbraucher " + 
     einZaehler.getMeinVerbraucher().getName());
        
    System.out.println
    ("Geklonter Zähler: Zählerstand =  " 
     + klonZaehler.getZaehlerstand() 
     + " gehört zu Verbraucher " + 
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
    ("Zählerstand =  " 
     + nocheinZaehler.getZaehlerstand()+
     " Unterzählerstand: " 
     + nocheinZaehler.getUnterzaehlerstand() 
     + " gehört zu Verbraucher " + 
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
    ("GeklonterUnterzähler: Zählerstand =  " 
     + nocheinZaehler.getZaehlerstand()+
    " Unterzählerstand: " 
    + nocheinZaehler.getUnterzaehlerstand() 
     + " gehört zu Verbraucher " 
     + nocheinZaehler.getMeinVerbraucher().getName());
  }
}