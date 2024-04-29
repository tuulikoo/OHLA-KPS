package org.kivipaperisakset;

/**
 * Peli-luokka, joka hallinnoi pelin kulkua pelaajien välillä.
 * Tämä luokka vastaa koko pelin suorittamisesta ja tulosten tarkistamisesta.
 *
 * @author Ira Dook
 * @author Tuuli Kivisaari
 */

public class Peli {
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    private static int tasapelit = 0;
    private int pelatutPelit = 0;
    private static int MAX_VOITOT = 3;
    private static final int MAX_TASAPELIT = 500;

    /**
     * Peli-luokan konstruktori, joka alustaa pelin kahdelle pelaajalle.
     *
     * @param pelaaja1 Ensimmäinen pelaaja
     * @param pelaaja2 Toinen pelaaja
     */
    public Peli(Pelaaja pelaaja1, Pelaaja pelaaja2) {
        this.pelaaja1 = pelaaja1;
        this.pelaaja2 = pelaaja2;
    }
/**
     * Metodi palauttaa pelattujen pelien määrän.
     *
     * @return Pelattujen pelien määrä
     */
    public int getPelatutPelit() {
        return pelatutPelit;
    }

    /**
     * Metodi suorittaa pelin, kunnes jompikumpi pelaajista saavuttaa maksimivoitot tai tasapelien määrä ylittää rajan.
     */
    public void suoritaPeli() {
        boolean peliLoppui = false;

        do {
            System.out.println("Erä: " + (pelatutPelit + 1) + " =====================\n");
            Valinta p1Valinta = pelaaja1.pelaajanValinta();
            Valinta p2Valinta = pelaaja2.pelaajanValinta();

            tarkistaVoitot(p1Valinta, p2Valinta);
            System.out.println("Pelaaja 1: " + p1Valinta + "\n\t Pelaaja 1:llä koossa " + pelaaja1.getVoitot() + " voittoa.");
            System.out.println("Pelaaja 2: " + p2Valinta + "\n\t Pelaaja 2:lla koossa " + pelaaja2.getVoitot() + " voittoa.");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
            pelatutPelit++;

            if (pelaaja1.getVoitot() >= MAX_VOITOT || pelaaja2.getVoitot() >= MAX_VOITOT) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }
            else if (tasapelit >= MAX_TASAPELIT) {
                peliLoppui = true;
                System.out.println("500 TASAPELIÄ - PELI PÄÄTTYY TULOKSETTOMANA");
            }
            System.out.println();
        } while (!peliLoppui);
    }

    /**
     * Metodi tarkistaa pelin tuloksen ja päivittää voitot ja tasapelit sen perusteella.
     *
     * @param p1Valinta Pelaajan 1 valinta
     * @param p2Valinta Pelaajan 2 valinta
     */
    private void tarkistaVoitot(Valinta p1Valinta, Valinta p2Valinta) {
        if (p1Valinta == p2Valinta) {
            tasapelit++;
            System.out.println("\n !!!Tasapeli!!! \n");
        } else if ((p1Valinta == Valinta.KIVI && p2Valinta == Valinta.SAKSET) ||
                (p1Valinta == Valinta.PAPERI && p2Valinta == Valinta.KIVI) ||
                (p1Valinta == Valinta.SAKSET && p2Valinta == Valinta.PAPERI)) {
            pelaaja1.setVoitot();
            System.out.println("Pelaaja 1 voittaa");
        } else {
            pelaaja2.setVoitot();
            System.out.println("Pelaaja 2 voittaa");
        }
    }
}