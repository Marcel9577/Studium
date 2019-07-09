public class DemoUI
{
 public static void main(String args[])
 {
    DemoOberklasse einObjekt = 
     new DemoOberklasse();
    System.out.println
     ("Attribut Oberklasse = " 
     + einObjekt.getAttribut());
    
    DemoUnterklasse nocheinObjekt = 
      new DemoUnterklasse();
    System.out.println
     ("Attribut Unterklasse = " 
     + nocheinObjekt.getAttribut());
 }
}