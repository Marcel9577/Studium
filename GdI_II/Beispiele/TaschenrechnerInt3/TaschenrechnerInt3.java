public class TaschenrechnerInt3 
{
    @FunctionalInterface
    interface MathInteger
    {
       int berechne(int a, int b);
       
       default long berechneLong (int a, int b)  
       {
           return (long) a * (long) b;
       }
       
       static double berechneStatisch (int a, int b)
       {
           return (double) a / (double) b ;
       }
    }
      
    public static void main(String args[])
    {
        System.out.println(MathInteger.berechneStatisch(10,20));
        Taschenrechner r = new Taschenrechner();
        System.out.println(r.berechneLong(100000,200000));
     }
}

