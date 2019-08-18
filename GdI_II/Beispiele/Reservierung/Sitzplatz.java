public class Sitzplatz
{
    private int reihennummer;
    private char buchstabe;
	
    public Sitzplatz(int reihennummer, char buchstabe)
    {
	this.reihennummer = reihennummer;
        this.buchstabe = buchstabe;
    }

    public int getReihennummer(){ return this.reihennummer; }
    public char getBuchstabe(){ return this.buchstabe; }
    
    @Override
    public String toString()
    {
        return "Sitzplatz " + this.reihennummer + this.buchstabe;
    }
    
    @Override
    public boolean equals(Object o)
    {
        Sitzplatz s = (Sitzplatz)o;
        if(this.reihennummer==s.getReihennummer() &&
                this.buchstabe==s.getBuchstabe())
        {
            return true;
        }
        return false;
    }
}
