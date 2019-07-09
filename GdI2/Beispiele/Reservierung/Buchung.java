public class Buchung
{
    private Sitzplatz sitzplatz;
    
    public Buchung(Sitzplatz sitzplatz)
    {
        this.sitzplatz = sitzplatz;
    }
    
    public Sitzplatz getSitzplatz(){ return this.sitzplatz; }
}