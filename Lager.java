/**
 * Diese Klasse  Klasse Lager zum Verwalten von mehreren Artikeln.
 * 
 * @author Basel Saad , Anas Zahra 
 * @version 24.11.2021
 */
public class Lager{

    private static final int STANDERD_GROESSE = 10;
    private static final int KEINE_ARTIKEL_GEFUNDEN = -1;
    private Artikel [] arrayArtikel;
    private int groesseDesLagers;

    /**
     * Neues Lager-Object wird erzeugt 
     * @param groesse, laenge der Lager bestimmen.
     */
    public Lager (int groesse){

        if (groesse <= 0){
            throw new IllegalArgumentException ("\nFehler: Sie koennen keine negative Zahlen oder 0 eingeben!");            
        }

        this.arrayArtikel = new Artikel [groesse];
        this.groesseDesLagers = groesse;
    }

    /**
     * Neues Lager-Object wird erzeugt 
     */
    public Lager (){
        this(STANDERD_GROESSE);
    }

    /**
     * Index einer Artikel im Lager finden.
     * @param artikelNr, um die Artikel zu bestimmen
     */
    public int findeArtikelIndex(int artikelNr){
        for(int i = 0;i < arrayArtikel.length;i++){
            if (this.arrayArtikel[i] != null)//ueberpruefen,ob es bei [i] index eine Artikel gibt
                if (this.arrayArtikel[i].getArtikelNr() == artikelNr){
                    return i;
                }
        }
        return KEINE_ARTIKEL_GEFUNDEN; 
    }

    /**
     * Artikel-Objekt in das Artikel-Array
     * @param artikel, neuer Artikel-objekt in Array  
     */
    public void artikelAnlegen (Artikel artikel){   
        if (artikel == null){
            throw new IllegalArgumentException("\nFehler: Geben Sie bitte eine gueltige Artikel ein");
        }

        //freier Platz
        int aktuelleindex = getArtikelAnzahl();
        if (aktuelleindex >= groesseDesLagers){
            throw new IllegalArgumentException ("\nFehler: Es gibt keinen freien Platz im Lager!");
        }

        //ob die Artikel schon existiert 
        int index = findeArtikelIndex(artikel.getArtikelNr());
        if (index != KEINE_ARTIKEL_GEFUNDEN){
            throw new IllegalArgumentException ("\nFehler: Diese Artikel existiert schon im Lager!"
                +"\n("+getArtikel(index)+")\ngeben Sie bitte andere Artikelnummer");
        }

        //artikel anlegen
        this.arrayArtikel[aktuelleindex] = artikel;
    }

    /**
     * Entfernen eines Artikels aus dem Lager.
     * @param artikelNr, um die Artikel zu bestimmen
     */
    public void entferneArtikel (int artikelNr){
        int artikelIndex = findeArtikelIndex(artikelNr);
        if (artikelIndex == KEINE_ARTIKEL_GEFUNDEN){
            throw new IllegalArgumentException ("\nFehler: Es wurde keine Artikel mit der Artikelnummer: "
            +artikelNr+" gefunden!");
        }

        Artikel [] tempArray = this.arrayArtikel;
        this.arrayArtikel = new Artikel[groesseDesLagers];
        //entferne Artikel
        int index = 0;
        for (int i = 0;i < groesseDesLagers;i++){
            if (i != artikelIndex){
                this.arrayArtikel[index] = tempArray[i];
                index++;
            }
        }
    }

    /**
     *  Zugang buchen fuer einen Artikel
     *  @param artikelNr, um die Artikel zu bestimmen
     *  @param zugang: Menge hinzufuegen
     */
    public void bucheZugang(int artikelNr, int zugang){
        int index = findeArtikelIndex(artikelNr);
        if (index == KEINE_ARTIKEL_GEFUNDEN){
            throw new IllegalArgumentException ("\nFehler: Es wurde keine Artikel mit der Artikelnummer: "
            +artikelNr+" gefunden!");
        }

        this.arrayArtikel[index].bucheZugang(zugang);

    }

    /**
     *  Abgang buchen fuer einen Artikel
     *  @param artikelNr, um die Artikel zu bestimmen
     *  @param zugang: Menge abbuchen
     */
    public void bucheAbgang(int artikelNr, int abgang){
        int index = findeArtikelIndex(artikelNr);

        if (index == KEINE_ARTIKEL_GEFUNDEN){
            throw new IllegalArgumentException ("\nFehler: Es wurde keine Artikel mit der Artikelnummer: "
                +artikelNr+" gefunden!");
        }

        this.arrayArtikel[index].bucheAbgang(abgang);

    }

    /**
     * Aendert den Preis fuer einen einzigen Artikel
     * @param artikelNr, um die Artikel zu bestimmen
     * @param prozent, um wie viel prozent soll der Preis verringert/erhoet werden
     */
    public void aenderePreisEinesArtikels (int artikelNr,double prozent){
        int index = findeArtikelIndex(artikelNr);
        if (index == KEINE_ARTIKEL_GEFUNDEN ){
            throw new IllegalArgumentException  ("\nFehler: Es wurde keine Artikel mit der Artikelnummer: "
                +artikelNr+" gefunden!");
        }

        this.arrayArtikel[index].aenderePreis(prozent);

    }

    /**
     * Aendert den Preis fuer alle Artikel
     * @param prozent, um wie viel prozent soll der Preis verringert/erhoet werden
     */
    public void aenderePreisAllerArtikel(double prozent) {
        for (int a = 0 ;a < this.arrayArtikel.length;a++){
            if (this.arrayArtikel[a] != null){
                this.arrayArtikel[a].aenderePreis(prozent);
            }
        }
    }

    /**
     *  Ermittelt einen Artikel an einer bestimmten Stelle im Lager
     *  @param index, um die Artikel zu bestimmen
     */
    public Artikel getArtikel (int index){
        if (index >= this.groesseDesLagers){
            throw new IllegalArgumentException("\nFehler: die Index ist groesser als der Bestand!");
        }

        if (this.arrayArtikel[index] == null){
            throw new IllegalArgumentException ("\nFehler: Die Artikel wurde nicht gefunden!");

        }

        return this.arrayArtikel[index];
    }

    /**
     * Bereitet alle Artikel-Objekte als eine Zeichenkette auf
     */
    @Override
    public String toString(){
        String data = "";
        int index = 1; 
        for (Artikel artikel : this.arrayArtikel){
            if (artikel != null){
                data += "\n"+index+" "+artikel.toString();
                index++;
            }
        }
        return data;
    }

    public String ausgebenBestandsListe() {
        String data = "";
        int index = 1; 
        double gesammtWert = 0;
        for (Artikel artikel : this.arrayArtikel){
            if (artikel != null){
                double gesammtPresiEinerArtikel = artikel.getPreis() * (double)artikel.getBestand();
                gesammtPresiEinerArtikel = (Math.round(gesammtPresiEinerArtikel * 100))/100.0d;
                double preis = (Math.round(artikel.getPreis() * 100))/100.0d;

                data += String.format("\n%d \t %s \t %.02f \t %d \t %.02f",
                    artikel.getArtikelNr(),
                    artikel.getBeschreibung(),
                    preis,
                    artikel.getBestand(),
                    gesammtPresiEinerArtikel);

                gesammtWert += gesammtPresiEinerArtikel;
                index++;
            }
        }
        data += "\n---------------------------------------------------------------------------------------------"
        +"\nGesammtwert: "+gesammtWert;
        return data;
    }

    /**
     * Bestimmt die aktuelle Anzahl der Artikel im Lager
     */
    public int getArtikelAnzahl (){
        int artikelAnzahl = 0;
        for (Artikel artikel : this.arrayArtikel){
            if (artikel != null){
                artikelAnzahl++;    
            }
        }
        return artikelAnzahl;
    }

    /**
     * Bestimmt die Anzahl der Artikel, die ins Lager gelegt werden koennen
     */
    public int getLagerGroesse(){
        return this.arrayArtikel.length;
    }

}
