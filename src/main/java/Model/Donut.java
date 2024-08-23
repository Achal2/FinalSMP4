package Model;

/**
 * @author Moses Devanesan
 */
    public class Donut extends MenuItem {
        private String flavor;
        private String type;
        private int quantity;
        public static final double YEAST_PRICE = 1.79;
        public static final double CAKE_PRICE = 1.89;
        public static final double HOLE_PRICE = .39;

    /**
     * @author Moses Devanesan
      * @param type
     * @param flavor
     * @param quantity
     */
    public Donut(String type, String flavor, int quantity) {
            this.type = type;
            this.flavor = flavor;
            this.quantity = quantity;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getFlavor() {
            return flavor;
        }

        public void setFlavor(String flavor) {
            this.flavor = flavor;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

    /**
     * @author Moses Devanesan
     * @return
     */
        @Override
        public double itemPrice() {
            double price = 0;
            if(type.equals("Yeast Donut")){
                price += YEAST_PRICE;
            }else if(type.equals("Cake Donut")){
                price += CAKE_PRICE;
            }else if(type.equals("Donut Hole")){
                price += HOLE_PRICE;
            }
            return price*quantity;
        }

    /**
     * @author Moses Devanesan
     * @return
     */
        @Override
        public String toString() {
            return type + " (" + quantity + ") (" + flavor + ")";
        }

    }


