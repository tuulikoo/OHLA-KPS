package org.kivipaperisakset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testiluokka Pelaaja-luokan testaamiseen.
 * @author Tuuli Kivisaari
 */
public class PelaajaTest {
    private Pelaaja pelaaja;

    @BeforeEach
    void setUp() {
        pelaaja = new Pelaaja();
    }

    /**
     * Testaa, ettei pelaajan valinta palauta null-arvoa.
     */
    @Test
    void testPelaajanValinta() {
        assertNotNull(pelaaja.pelaajanValinta(), "pelaajanValinta ei saa palauttaa nullia");
    }

    /**
     * Testaa, että pelaajan valinta on KIVI, PAPERI tai SAKSET.
     */
    @Test
    void testPelaajanValintaOnOikea() {
        for (int i = 0; i < 100; i++) {
            Valinta valinta = pelaaja.pelaajanValinta();
            assertTrue(valinta == Valinta.KIVI || valinta == Valinta.PAPERI || valinta == Valinta.SAKSET, "Valinnan pitää olla KIVI, PAPERI tai SAKSET");
        }
    }

    /**
     * Testaa voittojen laskemista.
     */
    @Test
    void testVoittojenLaskeminen() {
        assertEquals(0, pelaaja.getVoitot(), "Voittojen pitää aluksi olla 0");

        pelaaja.setVoitot();
        assertEquals(1, pelaaja.getVoitot(), "Voitot pitäisi olla 1");

        for (int i = 0; i < 5; i++) {
            pelaaja.setVoitot();
        }
        assertEquals(6, pelaaja.getVoitot(), "Voitot pitäisi olla 6");
    }
}
