import java.util.List;

public abstract class ClothingRecommender {
    // Abstract methods to be implemented by child classes
    public abstract List<String> getLongSleevedTopsNeckline();
    public abstract List<String> getTailoredBlackPantsCut();
    public abstract void addToShoppingList();

}
