public class Unterzaehler 
  extends Zaehler 
  implements Cloneable
{
 //Attribute
 private int unterzaehlerstand = 0;

 //Konstruktor
 Unterzaehler(String zaehlerart, 
   Verbraucher meinVerbraucher, int zaehlerstand)
 {
    super(zaehlerart, meinVerbraucher, 0);
    unterzaehlerstand = zaehlerstand;
  }
 //Kopier-Konstruktor
 public Unterzaehler(Unterzaehler einUnterzaehler)
 {
     super(einUnterzaehler.getZaehlerart(),
     einUnterzaehler.getMeinVerbraucher(), 
     einUnterzaehler.getZaehlerstand());
     
     this.unterzaehlerstand =
       einUnterzaehler.getUnterzaehlerstand();
  }
 
 //Methoden
 public int getUnterzaehlerstand()
 {
  return unterzaehlerstand;
 }

 //Redefinierte Methoden
 public Unterzaehler clone() 
  throws CloneNotSupportedException
 {
   return (Unterzaehler)super.clone();
 }
 
 
}