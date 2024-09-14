import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HourglassClothes extends ClothingRecommender {

    @Override
    public List<String> getLongSleevedTops() {
        List<String> tops = new ArrayList<>();
        tops.add("V-neck");
        tops.add("Asymmetrical neck");
        tops.add("Cowl neck");
        return tops;
    }

    @Override
    public List<String> getTailoredBlackPants() {
        List<String> pants = new ArrayList<>();
        pants.add("Straight cut black pants");
        pants.add("Boot cut black pants");
        pants.add("Flared black pants");
        pants.add("Wide-leg black pants");
        return pants;
    }

    @Override
    public List<String> getNecklineTypes() {
        List<String> necklines = new ArrayList<>();
        necklines.add("V-neck");
        necklines.add("Scoop neck");
        necklines.add("Cowl neck");
        return necklines;
    }

    @Override
    public void chooseClothing() {
        String chosenNeckline = askForNeckline();
        String chosenPantCut = askForPantCut();

        // Add choices to the shopping list or perform any other required actions
        System.out.println("You have chosen:");
        System.out.println("Neckline: " + chosenNeckline);
        System.out.println("Pant cut: " + chosenPantCut);
    }

    // Method to ask the user for neckline preference
    public String askForNeckline() {
        List<String> necklines = getNecklineTypes(); // Get available neckline options
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a neckline for your long-sleeved tops:");
        for (int i = 0; i < necklines.size(); i++) {
            System.out.println((i + 1) + ". " + necklines.get(i));
        }

        int choice = scanner.nextInt();
        if (choice > 0 && choice <= necklines.size()) {
            return necklines.get(choice - 1);
        } else {
            System.out.println("Invalid choice. Defaulting to V-neck.");
            return "V-neck"; // Default option
        }
    }

    // Method to ask the user for pant cut preference
    public String askForPantCut() {
        List<String> pants = getTailoredBlackPants(); // Get available pant cut options
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a cut for your tailored black pants:");
        for (int i = 0; i < pants.size(); i++) {
            System.out.println((i + 1) + ". " + pants.get(i));
        }

        int choice = scanner.nextInt();
        if (choice > 0 && choice <= pants.size()) {
            return pants.get(choice - 1);
        } else {
            System.out.println("Invalid choice. Defaulting to Straight cut.");
            return "Straight cut black pants"; // Default option
        }
    }
}
