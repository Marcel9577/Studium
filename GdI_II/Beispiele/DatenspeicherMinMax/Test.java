public class Test
{
  public static void main(String args[])
  {
      DatenspeicherMinMax2<Double> eineWetterstation = 
         new DatenspeicherMinMax2<>();
            
      DatenspeicherMinMax2<Integer> einePegelstation = 
         new DatenspeicherMinMax2<>();
      
      DatenspeicherMinMax2<Character> einText = 
         new DatenspeicherMinMax2<>();
            
      // Test Autoboxing
      eineWetterstation.setMin(2.76);
      eineWetterstation.pruefeMin(3.76);
      double dieMinTemp = eineWetterstation.getMin();
      System.out.println("Temperatur: " + dieMinTemp);
      
      einePegelstation.setMax(200);
      einePegelstation.pruefeMax(180);
      int derMaxPegel = einePegelstation.getMax();
      System.out.println("Pegel: " + derMaxPegel);
      
      einText.setMin('x');
      einText.pruefeMin('v');
      char dasMinZeichen = einText.getMin();
      System.out.println("Zeichen: " + dasMinZeichen);
  }
}