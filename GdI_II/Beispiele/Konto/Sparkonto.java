public class Sparkonto extends Konto
{

 //Konstruktor
 public Sparkonto(Kunde meinKunde)
 {
     super(meinKunde);
 }
 
 public void buchen(int betrag)
 {
     if(getKontostand()+ betrag > 0)
      super.buchen(betrag);
  }
}