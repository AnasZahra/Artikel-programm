import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * Diese Klasse ist ein Dialog, zur Kommunikation mit dem Anwender. Sie nimmt Eingaben entgegen und gibt
 * die Ergebnisse auf dem Bildschirm aus.
 * 
 * @author Basel Saad , Anas Zahra 
 * @version 08.11.2021
 */
public class ArtikelDialog
{
    private Scanner input ;
    private Artikel artikel;
    
    private static final int ANLEGEN = 1;
    private static final int OHNE_BESTAND_ANLEGEN = 2;
    private static final int ZUGANGABBUCHEN = 3;
    private static final int ABGANGABBUCHEN = 4;
    private static final int NEUEART = 5;
    private static final int ARTIKELNUMMER_VERAENDERN = 6;
     private static final int PREIS_VERAENDERN = 7;
    private static final int ARTIKEL_ANZEIGEN = 8;
    private static final int ZUSTIMMEN = 1;
    private static final int ABLEHNEN = 2 ;
    private static final int ENDE = 0;
    
    public ArtikelDialog (){
        input = new Scanner (System.in);
    }
    
    public static void main (String [] args){
        new ArtikelDialog().start();
    }
    
    /**
    * Hauptschleife des programms
    */
    public void start (){
        artikel = null;
        int funktion = -1;
        
        while (funktion != ENDE){
            try {
                funktion = eingabeFunktion ();
                verarbeitungsFunktion(funktion);
            }catch (IllegalArgumentException e ){
                System.out.println (e);
        }   catch (InputMismatchException e){
                System.out.println (e);
                System.out.println ("Sie duerfen keine Buchstaben eingeben");
                input.nextLine();
        }   catch (Exception e ) {
                System.out.println (e);
                e.printStackTrace (System.out); 
        }
        
        }
    }
    
    /**
     * Hier wird eine Menü ausgegeben und Funktion eingelesen.
     * 
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int eingabeFunktion (){
        int funktion;
        System.out.println ("\nGeben Sie die Nummer der Funktion ein\n");
        System.out.println ("-> Neue Artikel anlegen: "+ ANLEGEN
                        +"\n-> Neue Artikel ohne Bestand anlegen: "+OHNE_BESTAND_ANLEGEN
                        + "\n-> Menge hinzufuegen: "+ZUGANGABBUCHEN 
                        + "\n-> Menge abbuchen: "+ABGANGABBUCHEN
                        + "\n-> Art veraendern: "+NEUEART 
                        + "\n-> Artikelnummer veraendern: "+ARTIKELNUMMER_VERAENDERN
                        + "\n-> Preis veraendern: "+PREIS_VERAENDERN
                        + "\n-> Artikel anzeigen: "+ARTIKEL_ANZEIGEN
                        + "\n-> Ende: "+ENDE);
        
        funktion = input.nextInt();
        return funktion;
        
    }
    
    /**
     * Hier wird der ausgewählten Funktion Ausführen bzw. verarbeitet
     * 
     * @param die auszuführende Funktion als ganze Zahl
     */
    private void verarbeitungsFunktion(int funktion){
        if (funktion == ANLEGEN){
            artikelAnlegen();
        }else if (funktion == OHNE_BESTAND_ANLEGEN){
            artikelOhneBestand();
        }else if (funktion == ZUGANGABBUCHEN){
            bucheZugang();
        }else if (funktion == ABGANGABBUCHEN){
            bucheAbgang();
        }else if (funktion == NEUEART){
            setArt();
        }else if (funktion == ARTIKELNUMMER_VERAENDERN){
            artikelNummerVeraendern();
        }else if (funktion == ARTIKEL_ANZEIGEN){
                artikelAnzeigen();
        }else if (funktion == ENDE){
            System.out.println ("Programm wird beendet");
            
        }else{
            System.out.println ("Falsche Eingabe");
        }
        
      
        
    }
    
    /**
     * Artikel information Anzeigen
     */
    private void artikelAnzeigen (){
        if (artikel != null){
             System.out.println (artikel.toString());
        }else  {
            System.out.println("\n-Es wurde keine Artikel gefunden!!!");
        }
        
    }
    
    /**
    * Der Anwender kann eine bestimmte Name oder Menge für diejemaligen konstanten.
    * 
    * @param Artikelnummer wird gecheckt und ​muss aus vier stellen geschrieben sein.
    */
    private void artikelAnlegen (){
        if (checkVerfuegbarenArtikeln()){
        System.out.print("Artikelnummer:");
        int artikelnummer = input.nextInt();
        
        System.out.print("Artikel Art: ");
        String art = input.next();
        
        System.out.print("Bestand: ");
        int bestand = input.nextInt();
        
        System.out.print("Preis: ");
        double preis = input.nextDouble();
        
        artikel = new Artikel (artikelnummer , art.strip() , bestand,preis);
        }else {
            System.out.println("\n"+artikel.toString());
        }
       
    }
    
    private void artikelOhneBestand (){
        if (checkVerfuegbarenArtikeln()){
           System.out.print("Artikelnummer:");
        int artikelnummer = input.nextInt();
        
        System.out.print("Artikel Art: ");
        String art = input.next();
        
        System.out.print("Preis: ");
        double preis = input.nextDouble();
        
        artikel = new Artikel (artikelnummer,art,preis);
        }else {
            System.out.println("\n"+artikel.toString());
        }
    }
    
    /**
     * Ueberpruefen , ob eine Vorhandene Artikel verfuegbar ist 
     */
    
    private boolean checkVerfuegbarenArtikeln (){
        if (artikel != null){
            System.out.println ("\nEine Artikel wurde bereits geschrieben , Wollen Sie die Artikel trotzdem ueberschreiben?");
            System.out.println ("Ja : geben Sie bitte '1' ein"
                                +"\nNein: geben Sie bitte '2' ein");
            int eingabe = input.nextInt ();
            if (eingabe == ZUSTIMMEN){
                return true ;
            }else if (eingabe == ABLEHNEN){
                return false;
            }else {
                System.out.println ("Falsche Eingabe!");
                return false;
            }
           
        }else{
            return true ;
        }
         
    }
    
     /**
    * Die angegebene menge wird abgebucht wenn eine Artikel existiert.
    */
    private void bucheAbgang (){
        if (artikel != null){
           System.out.print ("Menge: ");
           int menge = input.nextInt();
           artikel.bucheAbgang(menge); 
        }else {
            System.out.println ("die Menge koennte nicht abgebucht werden ,da die Artikel noch nicht existiert!");
        }
        
    }
    
    /**
    * Die angegebene menge wird zugebucht wenn eine Artikel existiert.
    */
    private void bucheZugang (){
        if (artikel != null){
            System.out.print ("Menge: ");
            int menge = input.nextInt();
            artikel.bucheZugang (menge);
        }else{
           System.out.println ("die Menge koennte nicht zugefuehrt werden ,da die Artikel noch nicht existiert!"); 
        }
    }
    
     /**
    * Die angegebene Artikel Beschreibung wird geaendert wenn eine Artikel existiert.
    */
    private void setArt (){
        if (artikel != null){
            System.out.print ("Art: ");
            String art = input.next();
            artikel.setArt(art.strip());
        }else{
            System.out.println ("die Artikelart koennte nicht geaendert werden ,da die Artikel noch nicht existiert!"); 
        }
    }
    
    /**
     * Die Artikelnummer wird geaendert , wenn eine Artikel existiert.
     */
    private void artikelNummerVeraendern (){
        if (artikel != null ){
            System.out.print ("Neue Artikelnummer: ");
            int artikelnummer = input.nextInt();
            artikel.setArtikelNr(artikelnummer);
        }else {
            System.out.println ("Die Artikelnummer koennte nicht geaendert werden ,da die Artikel noch nicht existiert!");
        }
        
    }
    
    
      
    
}
