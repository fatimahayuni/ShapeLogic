import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BodyShapeCalculator calculator;

    public static void addNewMeasurements() {
        System.out.println("Enter your bust measurement in inches: ");
        double bust = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter your waist measurement in inches: ");
        double waist = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter your hips measurement in inches: ");
        double hips = scanner.nextDouble();
        scanner.nextLine();

       // Create a new BodyShapeCalculator object with the measurements so that we can use BodyShapeCalculator class in Main.java
        calculator = new BodyShapeCalculator(bust, waist, hips);

       // Display the body shape to the user:
        System.out.println("Your body shape: " + calculator.getBodyShape() + ".");
    }

    private static void displayRecommendations() {
        if (calculator == null) {
            System.out.println("No measurements available. Please add measurements first.");
            return;
        }

        String bodyShape = calculator.getBodyShape();
        
        ClothingRecommender recommender;

        if (bodyShape.equals("Inverted Triangle")) {
            recommender = new InvertedTriangleClothes();
        } else {
            recommender = new ClothingRecommender(); // or some default class
        }

        // Display clothing recommendations
        System.out.println("Clothing recommendations:");
        for (Map.Entry<String, String> entry : recommender.getTops().entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }

        for (Map.Entry<String, String> entry : recommender.getBottoms().entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }

        for (Map.Entry<String, String> entry : recommender.getShoes().entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }

        for (Map.Entry<String, String> entry : recommender.getBags().entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        do {
            int choice = displayMenu();
            if (choice == 1) {
                addNewMeasurements();
                displayRecommendations();
            }
            if (choice == 3) {
                break;
            }
        } while (true);
    }

    private static int displayMenu() {
        int choice = 0;

        while (true) {
            System.out.println("======");
            System.out.println("Menu");
            System.out.println("======");
            System.out.println("1. Find out your body shape and clothing recommendations");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character in the buffer
            if (choice >= 1 && choice <=3) {
                break;
            }
        }
        return choice;
        }
}
