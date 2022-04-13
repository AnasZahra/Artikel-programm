
/**
 * Beschreiben Sie hier die Klasse Video.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Video extends Artikel
{
    private int spieldauer;
    private int jahr;
    private String titel;
    
    Video(int artikelNr, int bestand, double preis, String titel, int spieldauer, int jahr){
        super (artikelNr,bestand,preis);
        eingabeUeberpruefen(spieldauer, "spieldauer");
        eingabeUeberpruefen(titel,"titel");
        if (jahr < 1900 || jahr > 2022){
            throw new IllegalArgumentException ("\nFehler: Erscheinungsjahr muss zwischen 1900 und 2022 sein");
        }
        
        this.spieldauer = spieldauer;
        this.jahr = jahr;
        this.titel = titel;
    }
    
    @Override
    public String getBeschreibung (){
        return this.titel;
    }
    
     //Setter
    public void setSpieldauer (int spieldauer){
        eingabeUeberpruefen(spieldauer, "spieldauer");
        this.spieldauer = spieldauer;
    }
    
    public void setTitel (String titel){
        eingabeUeberpruefen(titel, "titel");
        this.titel = titel;
    }
    
    public void setJahr (int jahr){
        if (jahr < 1900 || jahr > 2022){
            throw new IllegalArgumentException ("\nFehler: Erscheinungsjahr muss zwischen 1900 und 2022 sein");
        }
        this.jahr = jahr;
    }
    
    //Getter
    public int getJahr (){
        return this.jahr;
    }
    
    public String getTitel (){
        return this.titel;
    }
    
    public int getSpieldauer(){
        return this.spieldauer;
    }
    
    /**
     * Bereitet ein Video-Objekt als eine Zeichenkette auf
     */
    @Override
    public String toString(){
        return 
        "Artikel: "+super.getArtikelNr()
        +", Art: "+"Video"
        +", Bestand: "+super.getBestand() 
        + ", Preis: "+super.getPreis()
        +", Titel: "+this.titel
        +", Spieldauer: "+this.spieldauer
        +", Jahr: "+this.jahr;
    }
    
}
