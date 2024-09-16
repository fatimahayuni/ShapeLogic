import java.util.List;

public abstract class ClothingRecommender {
    // todo to add other clothing categories like tank tops, shoes, bags, dresses, skirts and accessories
    public abstract List<String> getLongSleevedTopsNeckline();
    public abstract List<String> getTailoredBlackPantsCut();
    public abstract void addToShoppingList();

    // Pass BodyShapeCalculator instance as a parameter
    public static void displayRecommendations(BodyShapeCalculator calculator) {

        String bodyShape = calculator.getBodyShape();
        ClothingRecommender recommender;

        //todo create other child classes of different body shapes: Hourglass, Pear, Rectangle.
        if (bodyShape.equals("Inverted Triangle")) {
            recommender = new InvertedTriangleClothes(); // Instantiate without overriding
        } else if (bodyShape.equals("Hourglass")) {
            recommender = new HourglassClothes();
        } else {
            System.out.println("Recommendations for this body shape are not available.");
            return;
        }

        recommender.addToShoppingList();
    }
}
