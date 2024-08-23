package Model;

public class Sandwich extends MenuItem {
    private String type;
    private String bread;
    private boolean cheese;
    private boolean lettuce;
    private boolean tomatoes;
    private boolean onions;
    /**
     * @author Achal Mukkapati
     */
    public static final double BEEF_PRICE = 10.99;
    public static final double CHICKEN_PRICE = 8.99;
    public static final double FISH_PRICE = 9.99;
    public static final double VEGGIE_ADD_ON_PRICE = 0.30;
    public static final double CHEESE_ADD_ON_PRICE = 1.00;

    /**
     *@author Achal Mukkapati
     * @param type
     * @param bread
     * @param cheese
     * @param lettuce
     * @param tomatoes
     * @param onions
     */
    public Sandwich(String type, String bread, boolean cheese, boolean lettuce, boolean tomatoes, boolean onions) {
        this.type = type;
        this.bread = bread;
        this.cheese = cheese;
        this.lettuce = lettuce;
        this.tomatoes = tomatoes;
        this.onions = onions;
    }

    /**
     * @author Achal Mukkapati
     * @return
     */
    @Override
    public double itemPrice() {
        double price = 0;

        switch (type) {
            case "beef":
                price += BEEF_PRICE;
                break;
            case "chicken":
                price += CHICKEN_PRICE;
                break;
            case "fish":
                price += FISH_PRICE;
                break;
        }

        if (cheese) {
            price += CHEESE_ADD_ON_PRICE;
        }
        if (lettuce) {
            price += VEGGIE_ADD_ON_PRICE;
        }
        if (tomatoes) {
            price += VEGGIE_ADD_ON_PRICE;
        }
        if (onions) {
            price += VEGGIE_ADD_ON_PRICE;
        }

        return price;
    }

    /**
     * @author Achal Mukkapati
     * @return
     */
    @Override
    public String toString() {
        String details = "Sandwich: " + type + " on " + bread + " with ";
        if (cheese) {
            details += "Cheese, ";
        }
        if (lettuce) {
            details += "Lettuce, ";
        }
        if (tomatoes) {
            details += "Tomatoes, ";
        }
        if (onions) {
            details += "Onions, ";
        }
        // Remove trailing comma and space if there are add-ons
        if (details.endsWith(", ")) {
            details = details.substring(0, details.length() - 2);
        }
        return details;
    }
}
