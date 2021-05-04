package be.bxl.formation;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

	    Circuit circuit = new Circuit("Francorchamps", 7004);
	    Voiture voiture1 = new Voiture("Peugeot", "Décapotable", 60, 70);
	    Voiture voiture2 = new Voiture("Citroen", "Monospace", 50, 70);
	    Voiture voiture3 = new Voiture("Toyota", "Rallye", 65, 75);
	    Voiture voiture4 = new Voiture("Renault", "Limousine", 40, 79);

        ArrayList<Voiture> voituresConcurentes = new ArrayList<>();
        voituresConcurentes.add(voiture1);
        voituresConcurentes.add(voiture2);
        voituresConcurentes.add(voiture3);
        voituresConcurentes.add(voiture4);

	    int nbrDeTour = 10;

        System.out.printf("Circuit %s, %s km", circuit.getName(), (double)circuit.getDistanceParTour()/1000);
        System.out.println("\n");

        for (int i = 0; i < nbrDeTour; i++) {
            for (Voiture voiture : voituresConcurentes) {
                voiture.roulerUnTour(circuit);
                System.out.printf("%s - %s - Durée du tour : %s secondes",
                        voiture.getMarque(),
                        voiture.getType(),
                        voiture.getDureeTourActuel());
                System.out.println();
            }
            sc.nextLine();
        }

        System.out.println("Résultats : ");
        Voiture voitureGagnante = voiture1;

        for (Voiture voiture : voituresConcurentes) {
            if (voitureGagnante.getTempsActuel() > voiture.getTempsActuel()) {
                voitureGagnante = voiture;
            }
            Duree duree = new Duree(voiture.getTempsActuel());
            voiture.roulerUnTour(circuit);
            System.out.printf("%s - %s - Résultat : %s secondes",
                    voiture.getMarque(),
                    voiture.getType(),
                    duree.getDuree());
            System.out.println();
        }

        System.out.println();

        System.out.println("Bravo au gagnant : " + voitureGagnante.getMarque() + " " + voitureGagnante.getType());




    }
}
