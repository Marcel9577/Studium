public class Auftrag extends Object 
{
 private int nummer = 0;
 private int auftragssumme = 0;// in Cent

 public Auftrag(int nummer, int auftragssumme)
 {
   this.nummer = nummer;
   this.auftragssumme = auftragssumme;
 }
 //getter-Methoden
 public int getNummer()
 {
  return nummer;
 }
 public int getAuftragssumme()
 {
  return auftragssumme;
 }
 //Redefinierte Methode, gleiche Signatur!
 public boolean equals(Auftrag einAuftrag)
 {
     if (einAuftrag == null) return false;
     if (nummer == einAuftrag.getNummer() &&
         auftragssumme == einAuftrag.getAuftragssumme())
         return true;
     else
         return false;
 }
}
