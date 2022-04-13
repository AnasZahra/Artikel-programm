import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Die Test-Klasse CDTest.
 *
 * @author  Basel , Anas
 * @version 06.12.2021
 */
public class BuchTest
{
    @Test
    public void korrekte_Artikelnummer_wird_uebergeben (){
        int korrekteArtikelnummer = 1234;
        Buch buch = new Buch (1234, 100, 200.0,"Stroustrup","The C++ Programming Language","V.1");

        assertEquals(korrekteArtikelnummer, buch.getArtikelNr()); 
    }

    @Test
    public void korrekter_Abgang_wird_uebergeben (){
        int korrekterBestand = 80;
        int korrekterAbgang = 20;
        Buch buch = new Buch (1234, 100, 200.0,"Stroustrup","The C++ Programming Language","V.1");
        buch.bucheAbgang(korrekterAbgang);

        assertEquals(korrekterBestand,buch.getBestand());
    }

    @Test
    public void korrekter_Zugang_wird_uebergang (){
        int korrekterBestand = 120;
        int korrekterZugang = 20;
        Buch buch = new Buch (1234, 100, 200.0,"Stroustrup","The C++ Programming Language","V.1");
        buch.bucheZugang(korrekterZugang);

        assertEquals(korrekterBestand,buch.getBestand());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_autor_wird_uebergeben (){
        Buch buch = new Buch (1324, 100, 200.0,"","The C++ Programming Language","V.1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_titel_wird_uebergeben (){
        Buch buch = new Buch (1324, 100, 200.0,"Stroustrup","","V.1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_verlag_wird_uebergeben (){
        Buch buch = new Buch (1324, 100, 200.0,"Stroustrup","The C++ Programming Language","");
    }



}
