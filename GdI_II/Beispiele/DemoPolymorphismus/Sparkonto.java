public class Sparkonto extends Konto
{
 //Konstruktor
 public Sparkonto(int kontonr, int kontostand)
 {
     super(kontonr, kontostand);
 }
 public void buchen(int betrag)
 {
    if(getKontostand()+ betrag > 0)
      super.buchen(betrag);
  }
}