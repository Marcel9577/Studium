import java.util.*;

public class Console
{
  //Liest eine ganze Zahl vom Typ int von der Konsole
  public static int readPosInt() throws Exception, InputMismatchException
  {
   int i = 0;
   Scanner sc = new Scanner(System.in);
   i = sc.nextInt();
   if (i <= 0) 
	  throw new Exception
	   ("Die ganze Zahl muss gr��er Null sein!");
   return i;
 }
}