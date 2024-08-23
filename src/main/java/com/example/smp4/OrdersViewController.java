package com.example.smp4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import Model.*;

/**
 * @author Moses Devanesan
 */
public class OrdersViewController implements Initializable {
    @FXML
    private ComboBox<String> orderNumbers;
    @FXML
    private ListView<String> orderList;
    @FXML
    private TextField totalAmount;
    @FXML
    private Button cancelOrder;
    @FXML
    private Button exportOrders;
    private ObservableList<String> numbers;
    private ObservableList<String> orderItems;

    private List<Order> allOrders;
//    private CafeMainController cafeMainController;

    /**
     * @author Moses Devanesan
     */
    private void OrderNumbers() {
        orderNumbers.getItems().clear();

        for(int i = 0; i < allOrders.size(); i++){
            Order order = allOrders.get(i);
            orderNumbers.getItems().add(String.valueOf(order.getOrderNumber()));
        }

    }

    /**
     * @author Moses Devanesan
     * @param orderNumString
     */
    private void orderDisplay(String orderNumString) {

        int orderNum = Integer.parseInt(orderNumString);
        Order selectedOrder = allOrders.stream()
                .filter(order -> order.getOrderNumber() == orderNum)
                .findFirst()
                .orElse(null);

        if (selectedOrder != null) {
            orderList.getItems().clear();
            for (MenuItem item : selectedOrder.getItemList()) {
                orderList.getItems().add(item.toString());
            }


            double subtotal = selectedOrder.calculateTotal();
            double tax = subtotal * 0.06625;
            totalAmount.setText(String.format("%.2f", subtotal + tax));
        }
        else{

        }
    }

    /**
     * @author Moses Devanesan
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allOrders = CartViewController.getOrders();
        OrderNumbers();



        orderNumbers.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                orderDisplay(newVal);
            }
        });

    }

    /**
     * @author Achal Mukkapati
     */
    @FXML
    private void cancelSelectedOrder() {
        String selectedOrderNum = orderNumbers.getValue();
        if (selectedOrderNum != null && !selectedOrderNum.isEmpty()) {
            allOrders.removeIf(order -> String.valueOf(order.getOrderNumber()).equals(selectedOrderNum));
            OrderNumbers();
            orderList.getItems().clear();
            totalAmount.clear();
        }
    }

    /**
     * @author Moses Devanesan
     */
    @FXML
    private void exportOrdersToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Orders");
        fileChooser.setInitialFileName("orders.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                for (Order order : allOrders) {
                    writer.write(String.format("Order #%d\n", order.getOrderNumber()));
                    for (MenuItem item : order.getItemList()) {
                        writer.write(item.toString() + "\n");
                    }
                    double subtotal = order.calculateTotal();
                    double tax = subtotal * 0.06625;
                    double total = subtotal + tax;
                    writer.write(String.format("Subtotal: $%.2f, Tax: $%.2f, Total: $%.2f\n\n", subtotal, tax, total));
                }
            } catch (IOException e) {
                System.err.println("Error saving orders to file: " + e.getMessage());
            }
        }
    }

}