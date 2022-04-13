
/**
 * Beschreiben Sie hier die Klasse Buch.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Buch extends Artikel
{
    private String autor;
    private String titel;
    private String verlag;

    Buch(int artikelNr, int bestand, double preis, String autor, String titel, String verlag){
        super(artikelNr,bestand,preis);
        eingabeUeberpruefen(autor,"autor");
        eingabeUeberpruefen(titel,"titel");
        eingabeUeberpruefen(verlag,"verlag");

        this.autor = autor;
        this.titel = titel;
        this.verlag = verlag;
    }

    @Override
    public String getBeschreibung (){
        return this.autor+": "+this.titel;
    }

    //Setter
    public void setAutor (String autor){
        eingabeUeberpruefen(autor, "autor");
        this.autor = autor;
    }

    public void setTitel (String titel){
        eingabeUeberpruefen(titel, "titel");
        this.titel = titel;
    }

    public void setVerlag (String verlag){
        eingabeUeberpruefen(verlag, "verlag");
        this.verlag = verlag;
    }

    //Getter
    public String getVerlag (){
        return this.verlag;
    }

    public String getTitel (){
        return this.titel;
    }

    public String getAutor(){
        return this.autor;
    }

    /**
     * Bereitet ein Video-Objekt als eine Zeichenkette auf
     */
    @Override
    public String toString(){
        return 
        "Artikel: "+super.getArtikelNr()
        +", Art: "+"Buch"
        +", Bestand: "+super.getBestand() 
        + ", Preis: "+super.getPreis()
        +", Titel: "+this.titel
        +", Autor: "+this.autor
        +", Verlag: "+this.verlag;
    }

}
