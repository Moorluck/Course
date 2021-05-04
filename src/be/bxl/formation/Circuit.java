package be.bxl.formation;

public class Circuit {
    private int distanceParTour;
    private String name;

    public Circuit(String name, int distanceParTour) {
        this.name = name;
        this.distanceParTour = distanceParTour;
    }

    public int getDistanceParTour() {
        return distanceParTour;
    }

    public String getName() {
        return name;
    }
}
