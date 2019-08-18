/* Programmname: Taschenrechner
* Fachkonzept-Klasse: Rechner
* Aufgabe: einfacher Taschenrechner ohne Prioritäten
* Operanden und Operatoren durch Leerzeichen getrennt
* abwechselnd Operanden und Operatoren
* keine Eingabeüberprüfung
*/
public class Rechner
{
 //Methoden
 public String getErgebnis(String eingabe) 
 {
	float ergebnis, neu;
	char operator;
    String muster = " ";
    //Anwendung der split-Methode
	String [] teile = eingabe.split(muster);
	//Kontrollausgabe
	for (String element : teile)
	 { 
	     System.out.println(element); 
	 }
	 
	// 1. Operand
	ergebnis = Float.valueOf(teile[0]).floatValue();
	
	for (int i = 1; i < teile.length; i = i + 2)
	{
     //Operator
     operator = teile[i].charAt(0);
     //Operand
     neu = Float.valueOf(teile[i+1]).floatValue();
     switch (operator)
     {
	  case '+': ergebnis += neu;break;
	  case '-': ergebnis -= neu;break;
	  case '*': ergebnis *= neu;break;
	  case '/': ergebnis /= neu;break;
     }
    }
	return String.valueOf(ergebnis);
  }
}
