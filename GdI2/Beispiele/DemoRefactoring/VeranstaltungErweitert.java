import java.time.LocalDate;

public class VeranstaltungErweitert
{
	int nummer;
	short dauer;
	LocalDate vom, bis;
	String ort, adresse;
	short teilnehmerMax;
	double pauschalpreis; //nur wenn firmenintern
	boolean storniert = false;
	short teilnehmerMin; //nur wenn öffentlich
	short teilnehmerAktuell; //nur wenn öffentlich
	double stornogebühr; //nur wenn öffentlich
}