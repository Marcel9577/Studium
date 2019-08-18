import java.time.LocalDate;

public abstract class Veranstaltung
{
	int nummer;
	short dauer;
	LocalDate vom, bis;
	String ort, adresse;
	short teilnehmerMax;
	boolean storniert = false;
}