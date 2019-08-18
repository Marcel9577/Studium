import java.util.*;

class DemoBindung
{ 
 private static void druckeEinElement(String einElement, 
    String elementbez)
 {
   System.out.println(elementbez + ": " + einElement);
   System.out.println("-----------------------");
 }

 private static void druckeAlleNamen(ArrayList eineListe)
 {
   System.out.println("+++++ Namensliste +++++" );
   System.out.println("-----------------------");
   for (Object element : eineListe)
     druckeEinElement((String)element, "Name");
   System.out.println("+++ Ende Namensliste ++" );  
 }

 public static void main(String arg[])
 {
  ArrayList<String> alleNamen = new ArrayList<>();
  alleNamen.add("Meyer"); 
  alleNamen.add("Schulz");
  alleNamen.add("Balzert"); 
  alleNamen.add("Dorakov");
  //Drucke alle Namen 
  druckeAlleNamen(alleNamen);
 }
}