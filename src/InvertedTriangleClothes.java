public class InvertedTriangleClothes extends ClothingRecommender {
    private String[] topsForInvertedTriangle;
    private String[] bottomsForInvertedTriangle;
    private String[] shoesForInvertedTriangle;
    private String[] bagsForInvertedTriangle;

    public InvertedTriangleClothes() {
        super();
        this.topsForInvertedTriangle = new String[] {"V-neck", "Scoop neck", "Cowl neck"};
        this.bottomsForInvertedTriangle = new String[] {"Flared pants", "Straight cut pants", "A-line skirts"};
        this.shoesForInvertedTriangle = new String[] {"Pointed shoes", "Heeled sandals", "Ballet flats"};
        this.bagsForInvertedTriangle = new String[] {"Structured bag", "Crossbody bag", "Tote bag"};
    }

    // Getters
    public String[] getTopsForInvertedTriangle() {
        return topsForInvertedTriangle;
    }

    public String[] getBottomsForInvertedTriangle() {
        return bottomsForInvertedTriangle;
    }

    public String[] getShoesForInvertedTriangle() {
        return shoesForInvertedTriangle;
    }

    public String[] getBagsForInvertedTriangle() {
        return bagsForInvertedTriangle;
    }
}