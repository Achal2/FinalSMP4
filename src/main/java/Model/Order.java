package Model;


import java.util.ArrayList;

/**
 * @author Achal Mukkapati
 */
public class Order {
    private int orderNumber;
    private ArrayList<MenuItem> itemList;

    private static int prevNumber = 1;

    /**
     * @author Achal Mukkapati
     */
    public Order() {

        this.orderNumber = prevNumber;
        this.itemList = new ArrayList<>();
        prevNumber++;

    }


    public void addItem(MenuItem toAdd) {
        itemList.add(toAdd);
    }


    public void removeItem(MenuItem toRemove) {
        itemList.remove(toRemove);
    }

    public int getOrderNumber() {
        return orderNumber;
    }


    public ArrayList<MenuItem> getItemList() {
        return itemList;
    }

    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : itemList) {
            total += item.itemPrice();
        }
        return total;
    }


}


