
package org.kivipaperisakset;
import java.util.Random;

/**
 * Pelaaja-luokka, joka sisältää pelaajan valinnan ja voittojen laskemisen.
 * Tämä luokka edustaa yhtä pelissä osallistuvaa pelaajaa.
 * Pelaaja voi valita yhden kolmesta vaihtoehdosta: KIVI, PAPERI tai SAKSET.
 * Voitot lasketaan ja päivitetään automaattisesti pelin kulun mukaan.
 * @see Valinta
 * @author Ira Dook
 * @author Tuuli Kivisaari
 */
public class Pelaaja {
    private int voitot;
    private static final int VAIHTOEHDOT = 3;
    private static final Random random = new Random();
    /**
     * Arvotaan pelaajan valinta satunnaisluvuilla 0-2.
     * 
     * @return Pelaajan valinta (KIVI, PAPERI tai SAKSET)
     */
    public Valinta pelaajanValinta() {
       int arvottuValinta = random.nextInt(VAIHTOEHDOT);
       return Valinta.values()[arvottuValinta];
    }

    public void setVoitot() {
        voitot++;
    }
    
    /** 
     * Palauttaa pelaajan voittojen määrän
     * @return int Pelaajan voittojen määrä
     */
    public int getVoitot() {
        return voitot;
    }
}
