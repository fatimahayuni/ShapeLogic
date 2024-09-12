import java.util.HashMap;
import java.util.Map;

public class ClothingRecommender {
    private Map<String, String> tops; // Key: clothing type, Value: description
    private Map<String, String> bottoms;
    private Map<String, String> shoes;
    private Map<String, String> bags;

    //Constructors (starts with public and then the name of the constructor in uppercase)
    public ClothingRecommender() {
        // Initialise the lists with generic recommendations.
        this.tops = new HashMap<>();
        this.bottoms = new HashMap<>();
        this.shoes = new HashMap<>();
        this.bags = new HashMap<>();

        initializeGeneralRecommendations();
    }

    // Method to initialise general clothing recommendations.
    private void initializeGeneralRecommendations() {
        tops.put("Tops", "V-neck, scoop-neck, cowl-neck");
        bottoms.put("Bottoms", "A-line skirts, wide-leg trousers, boot cut/flared jeans, high-waisted pants, tailored or straight-leg pants");
        shoes.put("Shoes", "Strappy sandals, pointed-toe flats, ankle boots with a slight heel, wedge sandals, block-heeled shoes");
        bags.put("Bags", "Hobo bags, tote bags, crossbody bags, bucket bags, medium-sized satchels");
    }

    // Getters for the maps
    public Map<String, String> getTops() {
        return tops;
    }

    public Map<String, String> getBottoms() {
        return bottoms;
    }

    public Map<String, String> getShoes() {
        return shoes;
    }

   public Map<String, String> getBags() {
        return bags;
   }

    public void setTops(Map<String, String> tops) {
        this.tops = tops;
    }

    public void setBottoms(Map<String, String> bottoms) {
        this.bottoms = bottoms;
    }

    public void setShoes(Map<String, String> shoes) {
        this.shoes = shoes;
    }

    public void setBags(Map<String, String> bags) {
        this.bags = bags;
    }

    // Methods to add items to each category
    public void addTop(String key, String description) {
        tops.put(key, description);
    }
}

