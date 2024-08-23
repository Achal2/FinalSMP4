package Model;

import static org.junit.Assert.*;

public class SandwichTest {

    @org.junit.Test
    public void itemPrice() {
        Sandwich sandwich1 = new Sandwich("beef", "bagel", false, false,true,true);
        Sandwich sandwich2 = new Sandwich("chicken", "bagel", true, true,false,true);
        Sandwich sandwich3 = new Sandwich("fish", "bagel", false, true,true,false);
        Sandwich sandwich4 = new Sandwich("beef", "bagel", false, true,true,true);
        Sandwich sandwich5 = new Sandwich("fish", "bagel", true, true,false,false);

        // Testing the price of each sandwich with assertEqual()
        // Expected prices are based on your implementation of the itemPrice() method
        assertEquals(11.59, sandwich1.itemPrice(), 0.01);
        assertEquals(10.59, sandwich2.itemPrice(), 0.01);
        assertEquals(10.59, sandwich3.itemPrice(), 0.01);
        assertEquals(11.89, sandwich4.itemPrice(), 0.01);
        assertEquals(11.29, sandwich5.itemPrice(), 0.01);
    }
}