import java.util.*;

public class Console
{
	//Liest eine ganze Zahl vom Typ int von der Konsole
	public static int readPosInt()
	{
	 int i = 0;
	 try
	 {
		Scanner sc = new Scanner(System.in);
		i = sc.nextInt();
		if (i <= 0) 
		  i = -1;
	 }
	 catch (InputMismatchException e)
	 {
		i = -1;
	 }
		return i;
	}
}
