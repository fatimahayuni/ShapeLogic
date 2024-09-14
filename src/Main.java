import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static BodyShapeCalculator calculator;

    public static void displayBodyShape() {
        String bodyShape = calculator.getBodyShape();
        System.out.println("Your body shape is: " + bodyShape);
        System.out.println("Let's work on your shopping list! ");
        System.out.println();
    }

    public static void displayRecommendations() {
        if (calculator == null) {
            System.out.println("No measurements available. Please add measurements first.");
            return;
        }

        String bodyShape = calculator.getBodyShape();
        ClothingRecommender recommender = null;

        if (bodyShape.equals("Inverted Triangle")) {
            recommender = new InvertedTriangleClothes(); // Instantiate without overriding
        } else if (bodyShape.equals("Hourglass")) {
            recommender = new HourglassClothes();
        } else {
            System.out.println("Recommendations for this body shape are not available.");
            return;
        }

        recommender.addToShoppingList(); // Call the method to display recommendations
    }

    public static void main(String[] args) {
        while (true) {
            int choice = displayMenu();
            if (choice == 1) {
                calculator = BodyShapeCalculator.addNewMeasurements();
                displayBodyShape();
                displayRecommendations();
            } else if (choice == 2) {
                break;  // Exit the loop and end the program
            }
        }
    }

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
            scanner.nextLine(); // Consume the newline
            if (choice >= 1 && choice <= 2) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        }
        return choice;
    }
}
