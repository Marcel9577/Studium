

public class QW
{
    public static double berechneQuadratwurzel(double x)
    {
        double y0, y1;
        int i;
        assert (x >= 0.0);
        y1 = 1.0;
        i = 1;
        for (;;)
        {
            y0 = y1;
            y1 = 0.5 * (y0 + x / y0);
            i++; assert (i <= 50);
            if (Math.abs(y1 - y0) < 1e-6) return y1;
        }
    }
    public static void main(String args[])
    {
    for (int i = 1; i < 10; i++)
    { 
       System.out.println("i: " + i + " Wurzel: " + 
       berechneQuadratwurzel(i));
    }
  }

}
