import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

/**
 * Die Test-Klasse LagerTest.
 *
 * @author  Basel , Anas
 * @version 06.12.2021
 */
public class LagerTest{
    private static final double EPSILON = 1E-10;
    @Test
    public void test_gueltiger_lager_groesse()
    {
        final int erwartetGroesse = 8;
        Lager lager = new Lager (8);
        assertEquals(erwartetGroesse,lager.getLagerGroesse());
    } 
    
    @Test
    public void test_gueltiger_lager_groesse_ohne_uebergabe()
    {
        final int erwartet = 10;
        Lager lager = new Lager ();
        assertEquals(erwartet,lager.getLagerGroesse());
    } 
    
    @Test
    public void test_lege_Artikel(){
        final int erwartetArtikelNummer = 1234;
        Lager lager = new Lager ();
        Artikel artikel = new Artikel (1234, "Head set", 100, 50.0);
        lager.artikelAnlegen(artikel);
        
        assertEquals(erwartetArtikelNummer,lager.getArtikel(0).getArtikelNr());
    }
    
    @Test
    public void test_Buch_soll_korrekt(){
        final int erwartetArtikelNummer = 1234;
        Lager lager = new Lager ();
        Artikel artikel = new Buch (1234, 51, 49.95,"Stroustrup","The C++ Programming Language","V.1");
        lager.artikelAnlegen(artikel);
        
        assertEquals(erwartetArtikelNummer,lager.getArtikel(0).getArtikelNr());
    }
    
    @Test
    public void test_CD_soll_korrekt(){
        final int erwartetArtikelNummer = 1234;
        Lager lager = new Lager ();
        Artikel artikel = new CD (1234, 51, 49.95,"Santana","Supernatural",20);
        lager.artikelAnlegen(artikel);
        
        assertEquals(erwartetArtikelNummer,lager.getArtikel(0).getArtikelNr());
    }
    
    @Test
    public void test_Video_soll_korrekt(){
        final int erwartetArtikelNummer = 1234;
        Lager lager = new Lager ();
        Artikel artikel = new Video (1234, 51, 49.95,"Star Wars",50,2010);
        lager.artikelAnlegen(artikel);
        
        assertEquals(erwartetArtikelNummer,lager.getArtikel(0).getArtikelNr());
    }
    
    @Test
    public void test_entferneArtikel()
    {
        final int erwarteterZahl = 2;
        Lager lager = new Lager ();
        Artikel ersteArtikel = new Artikel (1234,"Handy",100,100.0);
        Artikel zweitArtikel = new Artikel (1235,"Handy",100,100.0);
        Artikel dritteArtikel = new Artikel (1236,"Handy",100,100.0);
        lager.artikelAnlegen(ersteArtikel);
        lager.artikelAnlegen(zweitArtikel);
        lager.artikelAnlegen(dritteArtikel);
        lager.entferneArtikel(1234);
        
        assertEquals (erwarteterZahl,lager.getArtikelAnzahl());
    }
    
    @Test 
    public void test_buche_zugang_ertwartet_130()
    {
        final int erwartet = 130;
        Lager lager = new Lager ();
        Artikel artikel = new Artikel (1234, "Head set", 100, 50.0);
        final int zugang = 30;
        lager.artikelAnlegen(artikel);
        lager.bucheZugang(1234, zugang);
        
        assertEquals(erwartet, lager.getArtikel(0).getBestand());
    }
    
    @Test
    public void test_buch_abgang_erwartet_80(){
        final int erwartet = 80;
        Lager lager = new Lager ();
        Artikel artikel = new Artikel (1234, "Head set", 100, 50.0);
        final int zugang = 20;
        lager.artikelAnlegen(artikel);
        lager.bucheAbgang(1234, zugang);
        
        assertEquals(erwartet, lager.getArtikel(0).getBestand());
    }
    
    @Test
    public void test_erhoehung_preis_eines_artikels()
    {
        final double erwartet = 105.0;
        final double prozent = 5;
        Lager lager = new Lager (3);
        Artikel artikel = new Artikel (1234, "Head set", 100, 100.0);
        lager.artikelAnlegen(artikel);
        lager.aenderePreisEinesArtikels(1234,prozent);
        
        
        assertEquals(erwartet, lager.getArtikel(0).getPreis(),EPSILON);
    }

    @Test
    public void test_verringerung_preis_eines_artikels()
    {
        final double erwartet = 95.0;
        final double prozent = -5.0;
        Lager lager = new Lager (3);
        Artikel artikel = new Artikel (1234, "Head set", 100, 100.0);
        lager.artikelAnlegen(artikel);
        lager.aenderePreisEinesArtikels(1234,prozent);
        
        assertEquals(erwartet, lager.getArtikel(0).getPreis(),EPSILON);
    }
    
    @Test
    public void test_verringerung_preis_aller_artikel()
    {
        final double erwartet = 75.0;
        Lager lager = new Lager (2);
        Artikel ersteArtikel = new Artikel (1234, "Handy", 100, 100.0);
        Artikel zweiteArtikel = new Artikel (1235, "Head set", 100, 50.0);
        
        lager.artikelAnlegen(ersteArtikel);
        lager.artikelAnlegen(zweiteArtikel);
        lager.aenderePreisAllerArtikel(-50.0);
        
        double wirklichePreis = lager.getArtikel(0).getPreis() + lager.getArtikel(1).getPreis();
        assertEquals(erwartet, wirklichePreis, EPSILON);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_entferne_artikel_mit_falscher_artikelnummer()
    {
        final int erwarteterZahl = 2;
        Lager lager = new Lager ();
        Artikel ersteArtikel = new Artikel (1234,"Handy",100,100.0);
        Artikel zweitArtikel = new Artikel (1235,"Handy",100,100.0);
        Artikel dritteArtikel = new Artikel (1236,"Handy",100,100.0);
        lager.artikelAnlegen(ersteArtikel);
        lager.artikelAnlegen(zweitArtikel);
        lager.artikelAnlegen(dritteArtikel);
        lager.entferneArtikel(1237);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void test_ungueltiger_art(){
        Lager lager = new Lager ();
        lager.artikelAnlegen(new Artikel(1234,"",100,100.0));
    }
    
     @Test(expected = IllegalArgumentException.class)
    public void test_ungueltiger_preis(){
        Lager lager = new Lager ();
        lager.artikelAnlegen(new Artikel(1234,"",100,-20.0));
    }    
    
    @Test (expected = IllegalArgumentException.class)
    public void test_ungueltiger_lager_groesse()
    {
        Lager lager = new Lager (-5);
    } 
    
    @Test (expected = IllegalArgumentException.class)
    public void test_lege_anArtikel_bereits_existiert(){
        Lager lager = new Lager ();
        Artikel ersteArtikel = new Artikel (1234, "Head set", 100, 50.0);
        Artikel zweiteArtikel = new Artikel (4321, "Tasche", 100, 50.0);
        
        lager.artikelAnlegen(ersteArtikel);
        lager.artikelAnlegen(zweiteArtikel);
        lager.artikelAnlegen(ersteArtikel);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_lege_anArtikel_lager_voll(){
        Lager lager = new Lager (1);
        Artikel ersteArtikel = new Artikel (1234, "Head set", 100, 50.0);
        Artikel zweiteArtikel = new Artikel (4321, "Tasche", 100, 50.0);
        
        lager.artikelAnlegen(ersteArtikel);
        lager.artikelAnlegen(zweiteArtikel);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void aenderePreisEinesArtikelsNegativ()
    {
        Lager lager = new Lager (3);
        Artikel artikel = new Artikel (1234, "Head set", 100, 100.0);
        lager.aenderePreisEinesArtikels(1234, -120.0);
        
    }
}