	

class DemoString
{
    public static void main(String args[])
    {
        String text = "Java";
        //Wandle in Groﬂbuchstaben
        text.toUpperCase();
        //Das Ursprungsobjekt wird nicht ver‰ndert, d. h.
        //die Methode toUpperCase() hat keine Wirkung
        System.out.println(text);
        //Neues Objekt auﬂerhalb des Konstantenpools
        String textGross = text.toUpperCase();
        System.out.println(textGross);
    }
}