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
	short teilnehmerMin; //nur wenn �ffentlich
	short teilnehmerAktuell; //nur wenn �ffentlich
	double stornogeb�hr; //nur wenn �ffentlich
}