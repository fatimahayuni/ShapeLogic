import java.util.Scanner;

public class BodyShapeCalculator {
    // Measurements
    private double bust;
    private double waist;
    private double hips;
    // Body shape result
    private String bodyShape;

    // Default constructor
    private BodyShapeCalculator() {
    }

    // Constructor is private because addNewMeasurements can only be used within the
    private BodyShapeCalculator(double bust, double waist, double hips) {
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
        this.bodyShape = calculateBodyShape();
    }

    // Static method to add new measurements and return a new BodyShapeCalculator object
    public static BodyShapeCalculator addNewMeasurements() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your bust measurement in inches: ");
        double bust = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter your waist measurement in inches: ");
        double waist = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter your hips measurement in inches: ");
        double hips = scanner.nextDouble();
        scanner.nextLine();
        System.out.println();

        return new BodyShapeCalculator(bust, waist, hips);
    }

    // Calculate body shape based on bust, waist, and hips.
    private String calculateBodyShape() {
        if (Math.abs(bust - hips) <= 2 && waist < bust * 0.85) {
            return "Hourglass";
        } else if (bust > hips + 6 && waist < bust * 0.9) {
            return "Inverted Triangle";
        }
//        else if (hips > bust && waist < hips) {
//            return "Pear";
//        } else if (bust > hips && waist > hips * 0.9) {
//            return "Apple";
//        } else if (Math.abs(bust - waist) <= 2 && Math.abs(waist - hips) <= 2) {
//            return "Rectangle";
//        }
        return "Invalid body shape";
    }


    // Getters
    public double getBust() {
        return bust;
    }

    public double getWaist() {
        return waist;
    }

    public double getHips() {
        return hips;
    }

    public String getBodyShape() {
        return bodyShape;
    }

    // Setters. Currently not used until the user wants to edit her measurements.
    public void setBust(double bust) {
        if (bust >= 0 ) {
            this.bust = bust;
        } else {
            throw new IllegalArgumentException("Bust must be greater than 0");
        }
    }

    public void setWaist(double waist){
        if (waist >= 0 ) {
            this.waist = waist;
        } else {
            throw new IllegalArgumentException("Waist must be greater than 0");
        }
    }

    public void setHips(double hips) {
        if (hips >= 0) {
            this.hips = hips;
        } else {
            throw new IllegalArgumentException("Hips must be greater than 0");
        }
    }

    public void setBodyShape(String bodyShape) {
        this.bodyShape = bodyShape;
    }

}