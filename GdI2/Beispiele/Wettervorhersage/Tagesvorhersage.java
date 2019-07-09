
public class Tagesvorhersage
{
   private int minTemp, maxTemp, niederschlag, luft, wind;

    public Tagesvorhersage(int minTemp, int maxTemp, 
      int niederschlag, int luft, int wind)
    {
       this.minTemp=minTemp;
       this.maxTemp=maxTemp;
       this.niederschlag=niederschlag;
       this.luft=luft;
       this.wind=wind;
    }

    public int[] getWerte()
    {
       return new int[]{minTemp, maxTemp, niederschlag, luft, wind};
    }
}
