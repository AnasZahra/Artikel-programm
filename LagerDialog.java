import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Diese Klasse ist ein Dialog, zur Kommunikation mit dem Anwender. Sie nimmt Eingaben entgegen und gibt
 * die Ergebnisse auf dem Bildschirm aus.
 * 
 * @author Basel Saad , Anas Zahra 
 * @version 24.11.2021
 */
public class LagerDialog
{
    private enum ArtikelTyp {
        ARTIKEL_TYP("artikel"),
        CD_TYP("cd"),
        VIDEO_TYP("video"),
        BUCH_TYP("buch");

        private String artikelArt;

        private ArtikelTyp(String art){
            this.artikelArt = art;
        }

        public String getArtikelArt () {
            return this.artikelArt;
        }
    }

    //
    private Lager lager;
    private Scanner input; 
    private boolean groesseSchonBestimmt;
    //Konstanten
    private static final int ANLEGEN = 1;
    private static final int ARTIKEL_ENTFERNEN = 2;
    private static final int ZUGANGABBUCHEN = 3;
    private static final int ABGANGABBUCHEN = 4;
    private static final int PREIS_EINER_ARTIKEL_VERAENDERN = 5;
    private static final int PREIS_ALLER_ARTIKEL_VERAENDERN = 6;
    private static final int ARTIKEL_ANZEIGEN = 7;
    private static final int ALLE_ARTIKEL_ANZEIGEN = 8;
    private static final int ARTIKEL_ANZAHL = 9;
    private static final int LAGER_GROESSE = 10;
    private static final int AUSGEBEN_BESTAND_LIST = 11;
    private static final int ENDE = 0;
    private static final int ZUSTIMMEN = 1;
    private static final int ABLEHNEN = 2 ;

    public LagerDialog (){
        input = new Scanner (System.in);
        try {
            groesseBestimmen();
        }catch (InputMismatchException e){
            System.out.println(e);
            System.out.println("\nFehler: bitte keine Buchstaben eingeben!");
            new LagerDialog().lagerStart();
        }catch (Exception e){
            e.printStackTrace ();
        }
    }

    public static void main (String [] args){
        new LagerDialog().lagerStart();
    }

    private void lagerStart (){
        if (groesseSchonBestimmt) {
            int funktionLeser = -1; 
            while (funktionLeser != ENDE){
                try {
                    funktionLeser = eingabeFunktion();
                    verarbeitungsFunktion(funktionLeser);
                }catch (IllegalArgumentException e){
                    System.out.println (e);
                }catch (InputMismatchException e){
                    System.out.println (e);
                    System.out.println ("Sie duerfen keine Buchstaben eingeben");
                    input.nextLine();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Eingabe(=input) lesen und speichern
     * 
     * @return funktion, die gewaehlte Funktion
     */
    private int eingabeFunktion (){
        int funktion;
        System.out.println ("\nGeben Sie die Nummer der Funktion ein\n");
        System.out.println (
            /* + */"-> Neue Artikel anlegen: "+ ANLEGEN
            +"\n-> Artikel entfernen: "+ARTIKEL_ENTFERNEN
            + "\n-> Menge hinzufuegen: "+ZUGANGABBUCHEN 
            + "\n-> Menge abbuchen: "+ABGANGABBUCHEN
            + "\n-> Preis einer Artikl veraendern: "+PREIS_EINER_ARTIKEL_VERAENDERN
            + "\n-> Preis aller Artikel veraendern: "+PREIS_ALLER_ARTIKEL_VERAENDERN
            + "\n-> Artikel anzeigen: "+ARTIKEL_ANZEIGEN
            + "\n-> Alle Artikel anzeigen: "+ALLE_ARTIKEL_ANZEIGEN
            + "\n-> Artikel-Anzahl anzeigen: "+ ARTIKEL_ANZAHL
            + "\n-> Lager Groesse: "+LAGER_GROESSE
            + "\n-> Bestand-List ausgeben: "+AUSGEBEN_BESTAND_LIST
            + "\n-> Ende: "+ENDE);

        funktion = input.nextInt();
        return funktion;

    }

    /**
     * Hier wird die ausgewaehlte Funktion Ausfuehren bzw. verarbeitet
     * 
     * @param die auszufuehrende Funktion als ganze Zahl
     */
    private void verarbeitungsFunktion(int funktion){
        switch (funktion) {
            case ANLEGEN: 
                artikelAnLegen();
                break;
            case ARTIKEL_ENTFERNEN:
                entferneArtikel();
                break;
            case ZUGANGABBUCHEN: 
                buchZugang(); 
                break;
            case ABGANGABBUCHEN: 
                buchAbgang();
                break;
            case PREIS_EINER_ARTIKEL_VERAENDERN:
                aenderPreisEinesArtikel();
                break;
            case PREIS_ALLER_ARTIKEL_VERAENDERN:
                aenderPreisAllerArtikel();
                break;
            case ARTIKEL_ANZEIGEN: 
                getArtikel();
                break;
            case ALLE_ARTIKEL_ANZEIGEN:
                getAlleArtikel();
                break;
            case ARTIKEL_ANZAHL: 
                getArtikelAnzahl();
                break;
            case LAGER_GROESSE: 
                getLagerGroesse();
                break;
            case AUSGEBEN_BESTAND_LIST:
                ausgebenBestandList();
                break;
            case ENDE: 
                programmBeenden();
                break;
            default : 
                System.out.println("Falsche Eingabe!");

        } 
    }

    /**
     * Groesse des Lagers am Start bestimmen
     */
    private void groesseBestimmen(){

        while (!groesseSchonBestimmt){
            System.out.println ("\nMoechten Sie die Groesse des Lagers bestimmen?\nJa: "
                +ZUSTIMMEN+"\nNein: "+ABLEHNEN);
            System.out.println ("Achtung: Wenn Sie die Groesse nicht bestimmen, wird sie auf 10 gesetzt!");
            int funktion = input.nextInt();
            //ZUSTIMMEN
            if (funktion == ZUSTIMMEN){
                System.out.print("Groesse: ");
                int wert = input.nextInt();
                if (wert <= 0){
                    System.out.println ("\nFehler: die Groesse muss aus Zahlen bestehen, die groesser als 0 sind!");
                    groesseSchonBestimmt = false;         
                }else{
                    lager = new Lager (wert);
                    System.out.println ("Das Lager wurde für "+wert + " Artikel erfolgreich erstellt.");
                    groesseSchonBestimmt = true;
                }
            }
            //ABLEHNEN
            else if (funktion == ABLEHNEN){
                lager = new Lager();
                System.out.println ("Das Lager wurde erfolgreich erstellt...");
                groesseSchonBestimmt = true;
            }else{
                System.out.println("\nFehler: Falsche Eingabe");
                groesseSchonBestimmt = false;
            }      
        }
    }

    /**
     * Programm wird beendet
     */
    private void programmBeenden(){
        System.out.println("Programm wird beendet..."); 
    }

    /**
     * Artikel-Objekt in das Artikel-Array
     */
    private void artikelAnLegen(){
        System.out.print("Artikelnummer:");
        int artikelnummer = input.nextInt();
        input.nextLine();

        System.out.print("Artikel Art: ");
        String art = input.nextLine();

        System.out.print("Bestand: ");
        int bestand = input.nextInt();
        input.nextLine();

        System.out.print("Preis: ");
        double preis = input.nextDouble();
        input.nextLine();

        Artikel artikel;

        //CD-Objekt
        if (art.toLowerCase().equals(ArtikelTyp.CD_TYP.getArtikelArt())){
            artikel = artikelErzeugen(ArtikelTyp.CD_TYP,artikelnummer,art,bestand,preis,
                "Interpret","Titel","Titel-Anzahl");
        }
        //Video-Objekt
        else if (art.toLowerCase().equals(ArtikelTyp.VIDEO_TYP.getArtikelArt())){
            artikel = artikelErzeugen(ArtikelTyp.VIDEO_TYP,artikelnummer,art,bestand,preis,
                "Titel","Spieldauer","Jahr");
        }
        //Buch-Objekt
        else if (art.toLowerCase().equals(ArtikelTyp.BUCH_TYP.getArtikelArt())) {
            artikel = artikelErzeugen(ArtikelTyp.BUCH_TYP,artikelnummer,art,bestand,preis,
                "Autor","Titel","Verlag");
        }
        //Artikel
        else {
            artikel = artikelErzeugen(ArtikelTyp.ARTIKEL_TYP,artikelnummer,art,bestand,preis,"","","");
        }

        lager.artikelAnlegen(artikel);
    }

    /**
     * Artikel-Objekt je nach der Eingabe bei "art" erzeugen.
     * 
     * @param typ, typ der Artikel-Objekt
     * @param s1, "String_1" fuer Ausgeben
     * @param s2, "String_2" fuer Ausgeben
     * @param s3, "String_3" fuer Ausgeben
     * 
     * @return Objekt von der Typ Artikel,CD,Buch oder Video
     */
    private Artikel artikelErzeugen (ArtikelTyp typ, int artikelNr,String art,int bestand,double preis,
    String s1,String s2,String s3){

        if (typ == ArtikelTyp.CD_TYP){
            System.out.print(s1+": ");
            String interpret = input.nextLine();
            //
            System.out.print(s2+": ");
            String titel = input.nextLine();
            //
            System.out.print(s3+": ");
            int anzahltitel = input.nextInt();
            input.nextLine();
            //
            return new CD (artikelNr,bestand,preis,interpret,titel,anzahltitel);
        }else if (typ == ArtikelTyp.VIDEO_TYP){
            System.out.print(s1+": ");
            String titel = input.nextLine();
            //
            System.out.print(s2+": ");
            int spieldauer = input.nextInt();
            input.nextLine();
            //
            System.out.print(s3+": ");
            int jahr = input.nextInt();
            input.nextLine();
            //
            return new Video (artikelNr,bestand,preis,titel,spieldauer,jahr);
        }else if (typ == ArtikelTyp.BUCH_TYP){
            System.out.print(s1+": ");
            String autor = input.nextLine();
            //
            System.out.print(s2+": ");
            String titel = input.nextLine();
            //
            System.out.print(s3+": ");
            String verlag = input.nextLine();
            //
            return new Buch (artikelNr,bestand,preis,autor,titel,verlag);
        }else{
            return new Artikel (artikelNr,art,bestand,preis);
        }
    }

    /**
     * Entfernen eines Artikels aus dem Lager.
     */
    private void entferneArtikel (){
        System.out.print ("Geben Sie bitte die Artikelnummer ein: ");
        int artikelNr = input.nextInt();
        lager.entferneArtikel(artikelNr);
        System.out.println("\nDie Artikel wurde geloescht");
    }

    /**
     *  Abgang buchen fuer einen Artikel
     */
    private void buchAbgang (){
        System.out.print("\nGeben Sie bitte die Artikelnummer ein: ");
        int artikelNr = input.nextInt();
        System.out.print("\nGeben Sie bitte die Menge ein: ");
        int menge = input.nextInt();

        lager.bucheAbgang(artikelNr,menge);

    }

    /**
     *  Zugang buchen fuer einen Artikel
     */
    private void buchZugang (){
        System.out.print("\nGeben Sie bitte die Artikelnummer ein: ");
        int artikelNr = input.nextInt();
        System.out.print("\nGeben Sie bitte die Menge ein: ");
        int menge = input.nextInt();

        lager.bucheZugang(artikelNr,menge);

    }

    /**
     * Aendert den Preis fuer einen einzigen Artikel
     */
    private void aenderPreisEinesArtikel(){
        System.out.print("\nArtikelnummer: ");
        int artikelNr = input.nextInt();
        System.out.print("\nProzent: ");
        double prozent = input.nextDouble();

        lager.aenderePreisEinesArtikels(artikelNr, prozent);
    }

    /**
     * Aendert den Preis fuer alle Artikel
     */
    private void aenderPreisAllerArtikel(){
        System.out.print("\nProzent: ");
        double prozent = input.nextDouble();
        lager.aenderePreisAllerArtikel(prozent);
    }

    /**
     *  Ermittelt einen Artikel an einer bestimmten Stelle im Lager
     */
    private void getArtikel (){
        System.out.println("\nGeben Sie bitte die index der Artikel ein: ");
        int index = input.nextInt();
        input.nextLine();
        if (lager.getArtikel(index) != null){
            System.out.println(lager.getArtikel(index));
        }else {
            System.out.println("\nFehler: Es wurde keine Artikel im index: "+index+" gefunden!");
        }
    }

    /**
     * Bereitet alle Artikel-Objekte als eine Zeichenkette auf
     */
    private void getAlleArtikel (){
        System.out.println("\nIm Lager sind:\n"+lager.toString());
    }

    private void ausgebenBestandList () {
        System.out.println(lager.ausgebenBestandsListe());
    }

    /**
     * Bestimmt die aktuelle Anzahl der Artikel im Lager
     */
    private void getArtikelAnzahl (){
        System.out.println("\nAnzahl der Artikeln ist: "+lager.getArtikelAnzahl());
    }

    /**
     * Bestimmt die Anzahl der Artikel, die ins Lager gelegt werden koennen
     */
    private void getLagerGroesse (){
        System.out.println("\nGroesse des Lagers ist: "+lager.getLagerGroesse());
    }

}
