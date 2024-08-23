package com.example.smp4;


import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import Model.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Achal Mukkapati
 */
public class CartViewController {
    @FXML
    private ListView<MenuItem> listCart;
    @FXML
    private TextField subtotal;
    @FXML
    private TextField salesTax;
    @FXML
    private TextField totalAmount;
    private Order currentOrder = HelloController.getCurrentOrder();

    private static List<Order> orders = new ArrayList<>();

    private static final double SALES_TAX = .06625;

    public static List<Order> getOrders(){
        return orders;
    }

    public void initialize(){
        displayOrder();
    }

    /**
     * @author Moses Devanesan
     */
    private void displayOrder() {
        DecimalFormat df = new DecimalFormat("0.00");
        double subTotalAmount = 0.0;

        for (MenuItem item : currentOrder.getItemList()) {
            listCart.getItems().add(item);
            subTotalAmount += item.itemPrice();

        }

        double taxAmount = subTotalAmount * SALES_TAX;
        double totalAmountValue = subTotalAmount + taxAmount;

        subtotal.setText(df.format(subTotalAmount));
        salesTax.setText(df.format(taxAmount));
        totalAmount.setText(df.format(totalAmountValue));
    }

    /**
     * @author Moses Devanesan
     */
    @FXML
    private void removeSelectedItem() {
        MenuItem selectedItem = listCart.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            currentOrder.removeItem(selectedItem);

        }
        listCart.getItems().clear();
        displayOrder();

    }

    /**
     * @author Moses Devanesan
     */
    @FXML
    private void placeOrder() {
        orders.add(currentOrder);
        HelloController.newOrder();
        listCart.getItems().clear();
        subtotal.clear();
        salesTax.clear();
        totalAmount.clear();
    }
}

