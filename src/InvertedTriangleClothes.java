import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvertedTriangleClothes extends ClothingRecommender {

    private final List<String> shoppingList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> getLongSleevedTops() {
        List<String> tops = new ArrayList<>();
        tops.add("V-neck");
        tops.add("Cowl neck");
        tops.add("Scoop neck");
        return tops;
    }

    @Override
    public List<String> getTailoredBlackPants() {
        List<String> pants = new ArrayList<>();
        pants.add("Straight cut");
        pants.add("Boot cut");
        pants.add("Flared");
        pants.add("Wide-leg");
        return pants;
    }

    @Override
    public List<String> getNecklineTypes() {
        return getLongSleevedTops();
    }

    @Override
    public void chooseClothing() {
        chooseLongSleevedTop();
        chooseTailoredPants();
        // You can add more clothing choices here if needed
    }

    // Method to ask for top color and neckline, then add to shoppingList
    public void chooseLongSleevedTop() {
        // Choose color
        System.out.println("1 x long-sleeved top. Black or white?");
        String longSleevedTopColor = scanner.nextLine().trim();

        // Choose neckline
        System.out.println("Choose the neckline:");
        System.out.println("1. V-neck");
        System.out.println("2. Cowl neck");
        System.out.println("3. Scoop neck");

        int necklineChoice; // Default invalid value

        if (scanner.hasNextInt()) {
            necklineChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            String neckline;
            if (necklineChoice == 1) {
                neckline = "V-neck";
            } else if (necklineChoice == 2) {
                neckline = "Cowl neck";
            } else if (necklineChoice == 3) {
                neckline = "Scoop neck";
            } else {
                System.out.println("Invalid choice. Please select a number between 1 and 3.");
                return; // Exit the method to avoid adding invalid choices
            }

            // Add choice to shopping list
            shoppingList.add("1 x " + longSleevedTopColor + " long-sleeved top with " + neckline);
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear the invalid input
        }
    }

    // Method to ask for pants cut and add to shoppingList
    public void chooseTailoredPants() {
        System.out.println("1 x tailored black pants. Choose one:");
        List<String> pants = getTailoredBlackPants();
        for (int i = 0; i < pants.size(); i++) {
            System.out.println((i + 1) + ". " + pants.get(i));
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        String pantChoice = pants.get(choice - 1);

        // Add choice to shopping list
        shoppingList.add("1 x " + pantChoice + " tailored black pants");
    }

    // Method to display the shopping list
    public void displayShoppingList() {
        System.out.println("Your capsule wardrobe shopping list:");
        for (String item : shoppingList) {
            System.out.println(item);
        }
    }
}
