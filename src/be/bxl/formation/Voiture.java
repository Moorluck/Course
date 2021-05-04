package be.bxl.formation;

import java.util.ArrayList;
import java.util.Random;

public class Voiture {
    private String marque;
    private String type;
    private int vitesseMax;
    private int vitesseMin;

    private int tempsActuel = 0;
    private int dureeTourActuel = 0;

    public String getMarque() {
        return marque.toUpperCase();
    }

    public String getType() {
        return type;
    }

    public int getVitesseMax() {
        return vitesseMax;
    }

    public int getVitesseMin() {
        return vitesseMin;
    }

    public int getTempsActuel() {
        return tempsActuel;
    }

    public int getDureeTourActuel() {
        return dureeTourActuel;
    }

    public Voiture(String marque, String type, int vitessMin, int vitesseMax) {
        this.marque = marque;
        this.type = type;

        if (vitesseMax > 80 || vitesseMax < vitessMin || vitessMin < 0) {
            throw new IllegalArgumentException();
        }

        this.vitesseMin = vitessMin;
        this.vitesseMax = vitesseMax;
    }

    public void roulerUnTour(Circuit circuit) {
        int distance = circuit.getDistanceParTour();
        Random rand = new Random();
        int dureeTour = distance/(vitesseMin + rand.nextInt(vitesseMax-vitesseMin));
        this.dureeTourActuel = dureeTour;
        this.tempsActuel += dureeTour;
    }
}
