import java.util.List;

public abstract class ClothingRecommender {
    // Abstract methods to be implemented by child classes
    public abstract List<String> getLongSleevedTops();
    public abstract List<String> getTailoredBlackPants();
    public abstract List<String> getNecklineTypes();
    public abstract void chooseClothing();

    // Concrete method to display recommendations
    public void displayRecommendations() {
        System.out.println("1 x long-sleeved top (black or white) * allow user to choose which one");
        System.out.println("1 x long-sleeved top (accent color)");
        System.out.println("Choose 1-2 from the recommended necklines below: *allow user to choose which one.");
        for (String top : getLongSleevedTops()) {
            System.out.println("- " + top);
        }
    }
}
