import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static BodyShapeCalculator calculator;

    // Displays the determined body shape
    public static void displayBodyShape() {
        String bodyShape = calculator.getBodyShape();
        System.out.println("Your body shape is: " + bodyShape);
        System.out.println("Let's work on your shopping list!");
        System.out.println();
    }

    // Displays the menu and returns the user's choice
    private static int displayMenu() {
        int choice;

        while (true) {
            System.out.println();
            System.out.println("======");
            System.out.println("Menu");
            System.out.println("======");
            System.out.println("1. Find out your body shape and clothing recommendations");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1 || choice == 2) {
                return choice;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
    }

    // Main program execution
    public static void main(String[] args) {
        while (true) {
            int choice = displayMenu();

            if (choice == 1) {
                calculator = BodyShapeCalculator.addNewMeasurements();  // Add user measurements
                displayBodyShape();

                // Get and display clothing recommendations based on body shape
                ClothingRecommender.displayRecommendations(calculator);

            } else if (choice == 2) {
                System.out.println("Exiting program...");
                scanner.close();
                break;
            }
        }
    }
}
