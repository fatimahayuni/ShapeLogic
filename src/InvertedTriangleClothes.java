import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvertedTriangleClothes extends ClothingRecommender {
    private final List<String> shoppingList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // Method for choosing long-sleeved top with color and neckline
    private String longSleevedTop() {
        System.out.println("::TOPS::");
        String topColor;
        while (true) {
            System.out.println("1 x long-sleeved top. Black or white?");
            topColor = scanner.nextLine().trim().toLowerCase();
            if (topColor.equals("black") || topColor.equals("white")) {
                break;
            } else {
                System.out.println("Invalid color. Please enter 'black' or 'white'.");
            }
        }
        System.out.println();
        System.out.println("Choose the neckline. Enter 1/2/3");

        List<String> necklines = getLongSleevedTopsNeckline();
        for (int i = 0; i < necklines.size(); i++) {
            System.out.println((i + 1) + ". " + necklines.get(i));
        }

        int choice = getValidatedChoice(necklines.size());
        String neckline = (choice != -1) ? necklines.get(choice - 1) : necklines.get(0); // Default to first option if invalid choice

        String longSleevedTop = "1 x " + neckline + " " + topColor + " long-sleeved top";
        System.out.println(longSleevedTop);
        return longSleevedTop;
    }

    @Override
    public List<String> getLongSleevedTopsNeckline() {
        List<String> tops = new ArrayList<>();
        tops.add("V-neck");
        tops.add("Cowl neck");
        tops.add("Scoop neck");
        return tops;
    }

    // Method for choosing tailored pants
    private String tailoredPants() {
        System.out.println();
        System.out.println("::BOTTOM::");
        System.out.println("1 x tailored black pants. Choose one:");
        List<String> pants = getTailoredBlackPantsCut();
        for (int i = 0; i < pants.size(); i++) {
            System.out.println((i + 1) + ". " + pants.get(i));
        }

        int choice = getValidatedChoice(pants.size());
        String pantChoice = (choice != -1) ? pants.get(choice - 1) : pants.get(0); // Default to first option if invalid choice
        System.out.println("1 x " + pantChoice + " tailored black pants");
        System.out.println();
        return "1 x " + pantChoice + " tailored black pants";
    }

    @Override
    public List<String> getTailoredBlackPantsCut() {
        List<String> pants = new ArrayList<>();
        pants.add("Straight cut");
        pants.add("Boot cut");
        pants.add("Flared");
        pants.add("Wide-leg");
        return pants;
    }

  // CRUD
    public void addItemToShoppingList(String item) {
        shoppingList.add(item);
        System.out.println(item + " has been added to your shopping list.");
    }

    public void removeItemFromShoppingList(String item) {
        if (shoppingList.remove(item)) {
            System.out.println(item + " has been removed from your shopping list.");
        } else {
            System.out.println(item + " was not found in your shopping list.");
        }
    }

    public void updateShoppingListItem() {
        System.out.println("Enter the item to update:");
        String oldItem = scanner.nextLine();
        if (shoppingList.contains(oldItem)) {
            System.out.println("Enter the new item:");
            String newItem = scanner.nextLine();
            int index = shoppingList.indexOf(oldItem);
            shoppingList.set(index, newItem);
            System.out.println("Item updated to: " + newItem);
        } else {
            System.out.println("Item not found in the shopping list.");
        }
    }

    public void viewShoppingList() {
        System.out.println("\uD83E\uDDFA Your current capsule wardrobe shopping list:");
        for (String item : shoppingList) {
            System.out.println(item);
        }
    }

    private int getValidatedChoice(int maxOptions) {
        int choice = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= maxOptions) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Please enter a number between 1 and " + maxOptions + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }


    private void editShoppingList() {
        while (true) {
            System.out.println();
            System.out.println("\uFE0F Would you like to edit your shopping list?");
            System.out.println("1. Add an item");
            System.out.println("2. Remove an item");
            System.out.println("3. Update an item");
            System.out.println("4. View shopping list");
            System.out.println("5. Exit editing");
            System.out.print("Enter your choice: ");
            int choice = getValidatedChoice(5);

            switch (choice) {
                case 1:
                    System.out.print("Enter the item to add: ");
                    String addItem = scanner.nextLine();
                    addItemToShoppingList(addItem);
                    break;
                case 2:
                    System.out.print("Enter the item to remove: ");
                    String removeItem = scanner.nextLine();
                    removeItemFromShoppingList(removeItem);
                    break;
                case 3:
                    updateShoppingListItem();
                    break;
                case 4:
                    viewShoppingList();
                    break;
                case 5:
                    return;
            }
        }
    }

    // This method now handles selecting both the long-sleeved top and the tailored pants
    @Override
    public void addToShoppingList() {
        // Add long-sleeved top
        String longSleevedTop = longSleevedTop();
        shoppingList.add(longSleevedTop);

        // Add tailored pants
        String tailoredPants = tailoredPants();
        shoppingList.add(tailoredPants);

        // Display the final shopping list
        displayShoppingList();

        // Allow user to edit the shopping list
        editShoppingList();
    }

    // Display the shopping list
    private void displayShoppingList() {
        System.out.println("\uD83E\uDDFA Your capsule wardrobe shopping list:");
        for (String item : shoppingList) {
            System.out.println(item);
        }
        System.out.println();
    }
}
