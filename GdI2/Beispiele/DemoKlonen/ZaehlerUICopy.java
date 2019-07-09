public class ZaehlerUICopy
{
 public static void main(String args[])
 {
    //Attribute
    Zaehler einZaehler, copyZaehler =null; 
       
    Verbraucher einVerbraucher = new Verbraucher("Schulz"); 
    einZaehler = new Zaehler("Elektro", einVerbraucher, 123);
        
    //Kopieren
    copyZaehler = new Zaehler(einZaehler);
    
    System.out.println
    ("Zählerstand =  " 
     + einZaehler.getZaehlerstand()
     + " gehört zu Verbraucher " + 
     einZaehler.getMeinVerbraucher().getName());
        
    System.out.println
    ("Kopierter Zähler: Zählerstand =  " 
     + copyZaehler.getZaehlerstand() 
     + " gehört zu Verbraucher " + 
     einZaehler.getMeinVerbraucher().getName());
     
     if (einZaehler.getMeinVerbraucher() == copyZaehler.getMeinVerbraucher())
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
     
    //Kopieren
    Unterzaehler copyUnterzaehler = null;
    copyUnterzaehler = new Unterzaehler(nocheinZaehler);
    
    System.out.println
    ("Kopierter Unterzähler: Zählerstand =  " 
     + nocheinZaehler.getZaehlerstand()+
    " Unterzählerstand: " 
    + nocheinZaehler.getUnterzaehlerstand() 
     + " gehört zu Verbraucher " 
     + nocheinZaehler.getMeinVerbraucher().getName());
     
   
  }
}