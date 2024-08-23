package Model;

/**
 * @author Moses Devanesan
 */
    public class Coffee extends MenuItem {
        private String size;
        private int quantity;
        private boolean sweetCream;
        private boolean frenchVanilla;
        private boolean irishCream;
        private boolean caramel;
        private boolean mocha;
        public static final double BASE_PRICE = 1.99;
        public static final double SIZE_UP = .50;
        public static final double ADD_IN = .30;
        public static final int BUFFER = 2;

    /**
     * @author Achal Mukkapati
     * @param size
     * @param quantity
     * @param sweetCream
     * @param frenchVanilla
     * @param irishCream
     * @param caramel
     * @param mocha
     */
        public Coffee(String size, int quantity, boolean sweetCream, boolean frenchVanilla,
                      boolean irishCream, boolean caramel, boolean mocha){
            this.size = size;
            this.quantity = quantity;
            this.sweetCream = sweetCream;
            this.frenchVanilla = frenchVanilla;
            this.irishCream = irishCream;
            this.caramel = caramel;
            this.mocha = mocha;
        }

    /**
     * @author Achal Mukkapati
     * @param size
     * @param quantity
     * @param numAddIns
     */
        public Coffee(String size, int quantity, int numAddIns){
            this.size = size;
            this.quantity = quantity;
            this.sweetCream = false;
            this.frenchVanilla = false;
            this.irishCream = false;
            this.caramel = false;
            this.mocha = false;
            for(int i = 0; i < numAddIns; i++){
                if(i == 0){
                    this.sweetCream = true;
                }else if(i == 1){
                    this.frenchVanilla = true;
                }else if(i == 2){
                    this.irishCream = true;
                }else if(i == 3){
                    this.caramel = true;
                }else if(i == 4){
                    this.mocha = true;
                }
            }
        }

    /**
     * @author Achal Mukkapati
     * @return
     */
        @Override
        public double itemPrice() {
            double price = BASE_PRICE;

            if(size.equals("Tall")){
                price += SIZE_UP;
            }else if(size.equals("Grande")){
                price += SIZE_UP*2;
            }else if(size.equals("Venti")){
                price += SIZE_UP*3;
            }

            if(sweetCream){
                price += ADD_IN;
            }
            if(frenchVanilla){
                price += ADD_IN;
            }
            if(irishCream){
                price += ADD_IN;
            }
            if(caramel){
                price += ADD_IN;
            }
            if(mocha){
                price += ADD_IN;
            }
            return price*quantity;
        }

    /**
     * @author Moses Devanesan
     * @return
     */
        @Override
        public String toString() {
            String coffee = "Coffee (" + quantity + ") " + size + " (";
            if(sweetCream){
                coffee += "Sweet Cream, ";
            }
            if(frenchVanilla){
                coffee += "French Vanilla, ";
            }
            if(irishCream){
                coffee += "Irish Cream, ";
            }
            if(caramel){
                coffee += "Caramel, ";
            }
            if(mocha){
                coffee += "Mocha, ";
            }
            coffee = coffee.substring(0, coffee.length()-BUFFER);
            if(sweetCream || frenchVanilla || irishCream || caramel || mocha){
                coffee  += ")";
            }
            return coffee;
        }
    }
