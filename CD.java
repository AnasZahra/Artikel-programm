
/**
 * Beschreiben Sie hier die Klasse CD.
 * 
 * @author Basel,Anas
 * @version 16.01.2022
 */
public class CD extends Artikel
{
    private String interpret; 
    private String titel;
    private int anzahlTitel;

    CD(int artikelNr, int bestand,double preis, String interpret, String titel, int anzahlTitel) {
        super (artikelNr,bestand,preis);
        //
        eingabeUeberpruefen(interpret, "interpret");
        eingabeUeberpruefen(titel, "titel");
        eingabeUeberpruefen(anzahlTitel, "anzahlTitel");

        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;
    }

    @Override
    public String getBeschreibung (){
        return this.interpret+": "+this.titel;
    }

    //Setter
    public void setInterpret (String interpret){
        eingabeUeberpruefen(interpret, interpret);
        this.interpret = interpret;
    }

    public void setTitel (String titel){
        eingabeUeberpruefen(titel, "titel");
        this.titel = titel;
    }

    public void setAnzahlTitel (int anzahlTitel){
        eingabeUeberpruefen(anzahlTitel, "anzahlTitel");
        this.anzahlTitel = anzahlTitel;
    }
    
    //Getter
    public int getAnzahlTitel (){
        return this.anzahlTitel;
    }

    public String getTitel (){
        return this.titel;
    }

    public String getInterpret(){
        return this.interpret;
    }
    
    /**
     * Bereitet ein CD-Objekt als eine Zeichenkette auf
     */
    @Override
    public String toString(){
        return 
        "Artikel: "+super.getArtikelNr()
        +", Art: "+"CD"
        +", Bestand: "+super.getBestand() 
        + ", Preis: "+super.getPreis()
        +", Interpret: "+this.interpret
        +", Titel: "+this.titel
        +", Musiktitel: "+this.anzahlTitel;
    }

}
