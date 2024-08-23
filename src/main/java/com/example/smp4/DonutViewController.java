package com.example.smp4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.net.URL;


import Model.*;

/**
 * @author Achal Mukkapati
 */
public class DonutViewController implements Initializable {
    private ObservableList<String> yeastDonuts;
    private ObservableList<String> cakeDonuts;
    private ObservableList<String> donutHoles;
    private ObservableList<String> numbers;
    private ObservableList<String> orderedDonuts;
    @FXML
    private ListView<String> donutStock;
    @FXML
    private ListView<String> orderList;
    @FXML
    private ComboBox<String> typeSelector;
    @FXML
    private ComboBox<String> quantity;
    @FXML
    private ImageView donutImage = new ImageView();
    @FXML
    private TextField subtotal;

    private Order order;

    /**
     * @author Achal Mukkapati
     * @param flavor
     */
    public void setDonutImage(String flavor) {
        String imageName;
        if (flavor.equalsIgnoreCase("Yeast Donuts")) {
            imageName = "yeastDonut.png";
        } else if (flavor.equalsIgnoreCase("Cake Donuts")) {
            imageName = "cakeDonut.png";
        } else if (flavor.equalsIgnoreCase("Donut Holes")) {
            imageName = "donutHole.png";
        } else {
            imageName = "redDonut.png";
        }
        Image donutChoice = new Image("file:src/images/" + imageName);
        donutImage.setImage(donutChoice);

    }

    /**
     * @author Achal Mukkapati
     * @param url
     * @param resourceBundle
     */
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        order = HelloController.getCurrentOrder();

        yeastDonuts = FXCollections.observableArrayList("Jelly", "Glazed", "Chocolate Frosted",
                "Strawberry Frosted", "Lemon-Filled", "Apple Bite");
        cakeDonuts = FXCollections.observableArrayList("Salted Caramel", "Blue",
                "Chocolate Sprinkle", "Jelly Glazed");
        donutHoles = FXCollections.observableArrayList("Pretzel", "Chocolate Glazed", "Pumpkin Pie", "France");
        donutStock.setItems(yeastDonuts);
        ObservableList<String> types = FXCollections.observableArrayList(
                "Yeast Donut", "Cake Donut", "Donut Hole");
        typeSelector.setItems(types);
        typeSelector.setValue("Yeast Donut");
        quantity.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12"));
        quantity.setValue("1");
        donutImage.setImage(new Image("file:src/pictures/reddonut.png"));
        orderedDonuts = FXCollections.observableArrayList();
        orderList.setItems(orderedDonuts);
        updatePrice();
    }

    /**
     @author Moses Devanesan
     Changes the flavor options and displayed picture based on the selected type of donut.
     */
    @FXML
    protected void onTypeSelect(ActionEvent event){
        if(typeSelector.getSelectionModel().getSelectedItem().equals("Yeast Donut")){
            donutStock.setItems(yeastDonuts);
            donutImage.setImage(new Image("file:src/pictures/yeastdonut.png"));
        }else if(typeSelector.getSelectionModel().getSelectedItem().equals("Cake Donut")){
            donutStock.setItems(cakeDonuts);
            donutImage.setImage(new Image("file:src/pictures/cakedonut.png"));
        }else if(typeSelector.getSelectionModel().getSelectedItem().equals("Donut Hole")){
            donutStock.setItems(donutHoles);
            donutImage.setImage(new Image("file:src/pictures/donuthole.png"));
        }
    }

    /**
     * @author Moses Devanesan
     Adds a donut to the pre-order list.
     */
    @FXML
    protected void onAddButtonPress(){
        int index = donutStock.getSelectionModel().getSelectedIndex();
        if(index >= 0){
            String flavor = donutStock.getItems().get(index);
            int quantity = Integer.parseInt(this.quantity.getSelectionModel().getSelectedItem());
            String type = this.typeSelector.getSelectionModel().getSelectedItem();
            Donut ordered = new Donut(type, flavor, quantity);
            orderedDonuts.add(ordered.toString());
            donutStock.getItems().remove(index);
            updatePrice();
        }
    }


    /**
     * @author Achal Mukkapati
     */
    @FXML
    protected void onRemoveButtonPress(){
        int index = orderList.getSelectionModel().getSelectedIndex();
        if(index >= 0){
            String[] toRemove = orderList.getItems().get(index).split("\\(");
            if(toRemove[0].equals("Yeast Donut ")){
                yeastDonuts.add(toRemove[2].substring(0, toRemove[2].length()-1));
            }else if(toRemove[0].equals("Cake Donut ")){
                cakeDonuts.add(toRemove[2].substring(0, toRemove[2].length()-1));
            }else if(toRemove[0].equals("Donut Hole ")) {
                donutHoles.add(toRemove[2].substring(0, toRemove[2].length()-1));
            }
            orderList.getItems().remove(index);
            updatePrice();
        }
    }

    /**
     * @author Moses Devanesan
     Calculates and updates the price of the order.
     */
    public void updatePrice(){
        DecimalFormat df = new DecimalFormat("##,###.00");
        double price = 0;
        for(int i = 0; i < orderList.getItems().size(); i++){
            String[] checkPrice = orderList.getItems().get(i).split(" \\(");
            price += new Donut(checkPrice[0], checkPrice[2].substring(0, checkPrice[2].length()-1),
                    Integer.parseInt(checkPrice[1].substring(0, checkPrice[1].length()-1))).itemPrice();
        }
        subtotal.setText("$" + df.format(price));
    }

    /**
     * @author Achal Mukkapati
     Adds the list of selected donuts to the order.
     */
    @FXML
    protected void onAddToOrderButtonPress(){
        for(int i = 0; i < orderList.getItems().size(); i++){
            String[] addToOrder = orderList.getItems().get(i).split(" \\(");



            order.addItem(new Donut(addToOrder[0], addToOrder[2].substring(0, addToOrder[2].length()-1)  , Integer.parseInt(addToOrder[1].substring(0,
                    addToOrder[1].length()-1)) ));
        }

        orderList.getItems().clear();
    }
}

