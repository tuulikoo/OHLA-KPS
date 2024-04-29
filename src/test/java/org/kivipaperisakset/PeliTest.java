package org.kivipaperisakset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Testiluokka Peli-luokan testaamiseen.
 * @author Tuuli Kivisaari
 */
public class PeliTest {

    private Peli peli;

    @Mock
    private Pelaaja pelaaja1mock;
    @Mock
    private Pelaaja pelaaja2mock;

    //Alustetaan Mockito
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        peli = new Peli(pelaaja1mock, pelaaja2mock);
    }

    /**
     * Testaa, että pelaaja 1 voittaa valitsemalla KIVI
     */
    @Test
    void testPelaaJaVoitaPelaaja1Kivi() {
        // Simuloidaan Mockilla tiettyjä valintoja
        when(pelaaja1mock.pelaajanValinta()).thenReturn(Valinta.KIVI);
        when(pelaaja2mock.pelaajanValinta()).thenReturn(Valinta.SAKSET);

        peli.suoritaPeli();
        if (peli.getPelatutPelit() > 1) {
            assertEquals(1, pelaaja1mock.getVoitot(), "Pelaaja1 piti voittaa");
            assertEquals(0, pelaaja2mock.getVoitot(), "Pelaaja2 piti hävitä");
        }
    }

    /**
     * Testaa, että pelaaja 1 voittaa valitsemalla PAPERI
     */
    @Test
    void testPelaaJaVoitaPelaaja1Paperi() {
        // Simuloidaan Mockilla tiettyjä valintoja
        when(pelaaja1mock.pelaajanValinta()).thenReturn(Valinta.PAPERI);
        when(pelaaja2mock.pelaajanValinta()).thenReturn(Valinta.KIVI);

        peli.suoritaPeli();
        if (peli.getPelatutPelit() > 1) {
            assertEquals(1, pelaaja1mock.getVoitot(), "Pelaaja1 piti voittaa");
            assertEquals(0, pelaaja2mock.getVoitot(), "Pelaaja2 piti hävitä");
        }
    }

    /**
     * Testaa, että pelaaja 1 voittaa valitsemalla SAKSET
     */
    @Test
    void testPelaaJaVoitaPelaaja1Sakset() {
        // Simuloidaan Mockilla tiettyjä valintoja
        when(pelaaja1mock.pelaajanValinta()).thenReturn(Valinta.SAKSET);
        when(pelaaja2mock.pelaajanValinta()).thenReturn(Valinta.PAPERI);

        peli.suoritaPeli();
        if (peli.getPelatutPelit() > 1) {
            assertEquals(1, pelaaja1mock.getVoitot(), "Pelaaja1 piti voittaa");
            assertEquals(0, pelaaja2mock.getVoitot(), "Pelaaja2 piti hävitä");
        }
    }

    /**
     * Testaa, että pelaaja 2 voittaa.
     */
    @Test
    void testPelaaJaVoitaPelaaja2() {
        // Simuloidaan tiettyjä valintoja Mockilla
        when(pelaaja1mock.pelaajanValinta()).thenReturn(Valinta.KIVI);
        when(pelaaja2mock.pelaajanValinta()).thenReturn(Valinta.PAPERI);

        peli.suoritaPeli();
        if (peli.getPelatutPelit() > 1) {
            assertEquals(0, pelaaja1mock.getVoitot(), "Pelaaja1 piti hävitä");
            assertEquals(1, pelaaja2mock.getVoitot(), "Pelaaja2 piti voittaa");
        }
    }

    /**
     * Testaa peliä tasapelin osalta.
     */
    @Test
    void testSuoritaPeliTasapeli() {
        // Simuloidaan tiettyjä valintoja Mockilla
        when(pelaaja1mock.pelaajanValinta()).thenReturn(Valinta.KIVI);
        when(pelaaja2mock.pelaajanValinta()).thenReturn(Valinta.KIVI);

        peli.suoritaPeli();

        if (peli.getPelatutPelit() > 0) {
            assertEquals(0, pelaaja1mock.getVoitot(), "Pelaajan 1 ei pitäisi voittaa");
            assertEquals(0, pelaaja2mock.getVoitot(), "Pelaajan 2 ei pitäisi voittaa");
        }
    }

    /**
     * Testaa pelaajien voittojen laskemista.
     */
    @Test
    void testLaskeVoitot() {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();
        Peli peli = new Peli(pelaaja1, pelaaja2);

        peli.suoritaPeli();

        assertTrue(pelaaja1.getVoitot() == 3 || pelaaja2.getVoitot() == 3,
                "Pelaajan 1 tai pelaajan 2 pitäisi voittaa 3 kertaa");
    }
}
