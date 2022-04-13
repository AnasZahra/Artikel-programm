import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Die Test-Klasse ArtikelTest.
 *
 * @author  Basel , Anas
 * @version 06.12.2021
 */
public class ArtikelTest 
{
    @Test
    public void korrekte_Artikelnummer_wird_uebergeben (){
        int korrekteArtikelnummer = 1234;
        Artikel artikel = new Artikel (1234,"Art",100,200.0);
        
        assertEquals(korrekteArtikelnummer, artikel.getArtikelNr()); 
    }
    
    @Test
    public void artikel_ohne_bestand_anlegen (){
        final int erwartet = 1;
        Artikel artikel = new Artikel (1234,"Art",200.0);
        assertEquals(erwartet, artikel.getBestand()); 
    }
    
    @Test
    public void korrekter_Abgang_wird_uebergeben (){
        int korrekterBestand = 80;
        int korrekterAbgang = 20;
        Artikel artikel = new Artikel (1234,"Art",100,200.0);
        artikel.bucheAbgang(korrekterAbgang);
        
        assertEquals(korrekterBestand,artikel.getBestand());
    }
    
    @Test
    public void korrekter_Zugang_wird_uebergang (){
        int korrekterBestand = 120;
        int korrekterZugang = 20;
        Artikel artikel = new Artikel (1234,"Art",100,200.0);
        artikel.bucheZugang(korrekterZugang);
        
        assertEquals(korrekterBestand,artikel.getBestand());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_artikelnummer_wird_uebergeben (){
        Artikel artikel = new Artikel (-12,"Art",10,200.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_bestand_wird_uebergeben (){
        Artikel artikel = new Artikel (1234,"Art",-10,200.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void negativer_zugang_wird_uebergeben (){
        Artikel artikel =new Artikel (1234,"Art",10,200.0);
        artikel.bucheZugang(-100);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void bestand_des_artikels_wird_negativ (){
        Artikel artikel = new Artikel (1234,"Art",10,200.0);
        artikel.bucheAbgang(20);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_art_wird_uebergeben (){
        Artikel artikel = new Artikel (1234,"",10,200.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_art_wird_uebergeben_mit_null (){
        Artikel artikel = new Artikel (1234,null,10,200.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_preis_wird_uebergeben (){
        Artikel artikel = new Artikel (9854,"Laptop",10,-200.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_menge_bei_bucheAbgang_wird_uebergeben (){
        Artikel artikel = new Artikel (5897,"Handy",10,200.0);
        artikel.bucheAbgang(-20);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_menge_bei_bucheZugang_wird_uebergeben (){
        Artikel artikel = new Artikel (5897,"Handy",10,200.0);
        artikel.bucheZugang(-50);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_artikelnummer_weniger_als_vier_stellen (){
        Artikel artikel = new Artikel (597,"Handy",10,200.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_artikelnummer_mehr_als_vier_stellen (){
        Artikel artikel = new Artikel (59723,"Handy",10,200.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void ungueltiger_setArt_mit_Leerzeichen (){
        Artikel artikel = new Artikel (5973,"Handy",10,200.0);
        artikel.setArt("");
    }
    
    

    
}
