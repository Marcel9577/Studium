public class DemoSplit
{
   public static void main(String a[])
   {
    // Aufspalten eines Textes, der durch 
    // ::= getrennt ist 
    String text = "a::=b::=c=d";
    String muster = "::=";
    String[] teiltexte = text.split(muster, -1);
    // Ergebnis: ["a", "b", "c=d"]
    for (String element : teiltexte)
	 { 
	     System.out.println(element); 
	 }
// Aufspalten einer Formel mit "und" und "oder"
// und "; "
    String formel = "a und b oder c; a oder b;";
    muster = "[; ]+(und|oder)*[; ]*";
    teiltexte = formel.split(muster, 0);
// Ergebnis: ["a", "b", "c", "a", "b"]
    for (String element : teiltexte)
	 { 
	     System.out.println(element); 
	 }
   }
}

