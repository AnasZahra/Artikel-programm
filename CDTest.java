import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Die Test-Klasse CDTest.
 *
 * @author  Basel , Anas
 * @version 06.12.2021
 */
public class CDTest 
{
    @Test
    public void korrekte_Artikelnummer_wird_uebergeben (){
        int korrekteArtikelnummer = 1234;
        CD cd = new CD (1234, 51, 49.95,"Santana","Supernatural",20);

        assertEquals(korrekteArtikelnummer, cd.getArtikelNr()); 
    }

    @Test
    public void korrekter_Abgang_wird_uebergeben (){
        int korrekterBestand = 80;
        int korrekterAbgang = 20;
        CD cd = new CD (1234, 100, 200.0,"Santana","Supernatural",20);
        cd.bucheAbgang(korrekterAbgang);

        assertEquals(korrekterBestand,cd.getBestand());
    }

    @Test
    public void korrekter_Zugang_wird_uebergang (){
        int korrekterBestand = 120;
        int korrekterZugang = 20;
        CD cd = new CD (1234, 100, 200.0,"Santana","Supernatural",20);
        cd.bucheZugang(korrekterZugang);

        assertEquals(korrekterBestand,cd.getBestand());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_interpret_wird_uebergeben (){
       
        CD cd = new CD (1324, 100, 200.0,"","Supernatural",20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_titel_wird_uebergeben (){
        
        CD cd = new CD (1234, 100, 200.0,"Santana","",20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_verlag_wird_uebergeben (){
        CD cd = new CD (1234, 100, 200.0,"Santana","Supernatural",-20);
    }



}
