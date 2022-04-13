/**
 * Artikel , der die Menge , die Artikelnummer und den Bestand darstellt
 * 
 * @author Basel Saad , Anas Zahra 
 * @version 0.1
 */

public class Artikel
{
    public static final int STD_BESTAND = 1;
    private static final String MEDIEN = "Medien";
    private int artikelNr; 
    private String art ; 
    private int bestand;
    private double preis;
    
    /**
     * Neues Artikel-Object wird erzeugt 
     * 
     * @param artikel : Artikelnummer
     * @param art : Art der Artikel (Z.B Handy , Laptop)
     * @param bestand : wie viele sind Verfügbar
     * @param preis: preis der Artikel
     */
    public Artikel (int artikelNr,String art,int bestand,double preis){
        eingabeUeberpruefen(art,"art");
        eingabeUeberpruefen(artikelNr,"artikel");  
        eingabeUeberpruefen(preis,"preis");  
        eingabeUeberpruefen(bestand,"bestand");  
        
         if (String.valueOf(artikelNr).length() != 4){
            throw new IllegalArgumentException ("\nFehler: Die Artikelnummer muss aus vier Stellen bestehen!");
        }
     
       
        this.artikelNr = artikelNr ;
        this.art = art.strip();
        this.bestand = bestand;
        this.preis = preis;
    }
    
     /**
     * Neues Artikel-Object wird erzeugt
     * @param artikel : Artikelnummer
     * @param art : Art der Artikel (Z.B Handy , Laptop)
     */
    public Artikel (int artikelnr , String art,double preis ){
        this(artikelnr,art,STD_BESTAND,preis);
    }
    
    public Artikel (int artikelnr , int bestand, double preis){
        this(artikelnr,MEDIEN,bestand,preis);
    }
    
    /**
     * erhoeht den Bestand um eine bestimmte Menge
     * @param menge , um wie viel erhoeht werden soll
     */
    public void bucheZugang (int menge){
        if (menge <= 0) {
            throw new IllegalArgumentException ("Sie koennen keine negative Zahlen oder null hinzufuegen");
        }
            
        bestand += menge;
    }
    
    /**
     * vermindert den Bestand um eine bestimmte Menge
     * @param menge um wie viel vermindert werden soll
     */    
    public void bucheAbgang (int menge){
        if (menge <= 0 ){
            throw new IllegalArgumentException ("Sie koennen keine negative Zahlen oder null eingeben!");
        }else if (bestand < menge){
              throw new IllegalArgumentException ("Menge "+menge+" ist groesser als bestand: "+this.bestand);
        }
        bestand -= menge;
    }
    
    /**
     * Set Neuen String fuer art 
     * @param art Neuer Art
     */
    public void setArt (String art){
        if (art.strip().isEmpty() || art.equals(null)){
            throw new IllegalArgumentException ("Sie duerfen keine Leerzeichen eingeben!");
        }
        
        this.art = art.strip();
       
    }
    
    /**
     * Neue Artikelnummer
     * @param nr , Neue Artikelnummer
     */
    public void setArtikelNr(int artikelNr){
        if (String.valueOf(artikelNr).length() != 4){
            throw new IllegalArgumentException ("\nDie Artikelnummer muss aus vier Stellen bestehen!");
        }
        
        if (artikelNr <= 0 ){
            throw new IllegalArgumentException ("\nSie koennen keine Negative Zahlen oder null hinzufuegen!");
        }
        
        this.artikelNr = artikelNr; 
         
    }
    
       /**
     * Preis der Artikel anlegen oder veraendern 
     * @param Preis, Neuer Preis
     */
    public void aenderePreis (double prozent){
         if (prozent == 0.0d){
            throw new IllegalArgumentException ("\nFehler: Das Prozent muss nicht gleich 0 sein!");
        }
        if (prozent < -100.0d ){
            throw new IllegalArgumentException ("\nFehler: Das Prozent kann nicht groesser als 100%,oder kleiner als -100% sein!");
        }
        double wert = (this.preis * prozent) / 100d;
        this.preis = preis + wert;
    }
    
    public void setPreis(int preis){
        if (preis <= 0){
            throw new IllegalArgumentException ("\nDer Preis muss aus positiven Zahl bestehen");
        }
        this.preis = preis;
        
    }
    
    /**
     * Bestand wird gezeigt
     */
    public int getBestand(){
        return this.bestand;
    }
    
    /**
     * Artikelnummer wird gezeigt
     */
    public int getArtikelNr (){
        return this.artikelNr;
    }
    
    /**
     * Artikelart wird gezeigt
     */
    public String getArt (){
        return this.art;
    }
    
    public String getBeschreibung(){
        return this.art;
    }
    
    /**
     * Bereitet ein Artikel-Objekt als eine Zeichenkette auf
     */
    @Override
    public String toString(){
        return 
        "Artikel: "+artikelNr
        +",Art: "+art
        +", Bestand: "+bestand 
        + ",Preis: "+preis; 
    }
    
    /**
     * Preis der Artikel wird angezeigt 
     */
    public double getPreis (){
        return this.preis;
    }
    
    
    //------------------------------hilfsmethoden-----------------------------------
    public void eingabeUeberpruefen (int integerveriable,String name){
        if (integerveriable <= 0 ){
            throw new IllegalArgumentException ("\nFehler: "+name+" darf nicht gleich 0 oder kleiner sein");
        }
    }
    
      public void eingabeUeberpruefen (String stringveriable,String name){
        if (stringveriable == null || stringveriable.strip().isEmpty()){
            throw new IllegalArgumentException ("\nFehler: "+name+" darf nicht nicht leer sein");
        }
    }
    
    public void eingabeUeberpruefen (double doubleveriable,String name){
        if (doubleveriable <= 0.0d ){
            throw new IllegalArgumentException ("\nFehler: "+name+" darf nicht gleich 0 oder kleiner sein");
        }
    }

}
