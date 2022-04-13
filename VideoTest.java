import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Die Test-Klasse VideoTest.
 *
 * @author  Basel , Anas
 * @version 06.12.2021
 */
public class VideoTest 
{
    @Test
    public void korrekte_Artikelnummer_wird_uebergeben (){
        int korrekteArtikelnummer = 1234;

        Video video = new Video (1234, 100, 200.0,"Star Wars",50,2010);
        assertEquals(korrekteArtikelnummer, video.getArtikelNr()); 
    }

    @Test
    public void korrekter_Abgang_wird_uebergeben (){
        int korrekterBestand = 80;
        int korrekterAbgang = 20;
        Video video = new Video (1234, 100, 200.0,"Star Wars",50,2010);
        video.bucheAbgang(korrekterAbgang);

        assertEquals(korrekterBestand,video.getBestand());
    }

    @Test
    public void korrekter_Zugang_wird_uebergang (){
        int korrekterBestand = 120;
        int korrekterZugang = 20;
        Video video = new Video (1234, 100, 200.0,"Star Wars",50,2010);
        video.bucheZugang(korrekterZugang);

        assertEquals(korrekterBestand,video.getBestand());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_titel_wird_uebergeben (){
        
        Video video = new Video (1234, 100, 200.0,null,50,2010);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_spieldauer_wird_uebergeben (){
        Video video = new Video (1234, 100, 200.0,"Star Wars",-50,2010);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ungeultige_verlag_wird_uebergeben (){
         Video video = new Video (1234, 100, 200.0,"Star Wars",50,500);
    }

    



}
