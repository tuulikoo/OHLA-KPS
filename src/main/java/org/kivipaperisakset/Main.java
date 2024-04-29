package org.kivipaperisakset;

/**
 * Main-luokka, joka käynnistää pelin.
 * Tämä luokka sisältää `main`-metodin, joka toimii pelin aloituspisteenä.
 * Luo kaksi pelaajaa ja käynnistää pelin niiden välillä.
 * 
 * @author Tuuli Kivisaari
 * @version 1.0
 */

public class Main {

    public static void main(String[] args) {
        Pelaaja pelaaja1 = new Pelaaja();
        Pelaaja pelaaja2 = new Pelaaja();
        Peli peli = new Peli(pelaaja1, pelaaja2);
        peli.suoritaPeli();
    }

}
