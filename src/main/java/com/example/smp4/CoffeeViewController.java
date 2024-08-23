package com.example.smp4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import Model.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * @author Achal Mukkapati
 */
public class CoffeeViewController implements Initializable {

    @FXML
    private ComboBox<String> cmb_size = new ComboBox<>();
    @FXML
    private ComboBox<String> cmb_quantity = new ComboBox<>();
    @FXML
    private TextField price;
    @FXML
    private CheckBox sweetCream = new CheckBox();
    @FXML
    private CheckBox frenchVanilla = new CheckBox();
    @FXML
    private CheckBox irishCream = new CheckBox();
    @FXML
    private CheckBox caramel = new CheckBox();
    @FXML
    private CheckBox mocha  = new CheckBox();

    @FXML
    private ImageView coffee1 = new ImageView();

    private Order order;

    /**
     * @Moses Devanesan
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        order = HelloController.getCurrentOrder();


        Image coffeeM= new Image("file:src/pictures/coffee1.png");
        coffee1.setImage(coffeeM);

        cmb_size.setItems(FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti"));
        cmb_quantity.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9"));

        cmb_size.setValue("Short");
        cmb_quantity.setValue("1");

        priceUpdate();
    }

    /**
     * @author Achal Mukkapati
     */
    @FXML
    public void priceUpdate(){
        DecimalFormat df = new DecimalFormat("##,###.00");
        String currentPrice = df.format(createCoffee().itemPrice());
        price.setText("$" + currentPrice);
    }

    /**
     * @author Achal Mukkapati
     * @return
     */
    public Coffee createCoffee(){
        String coffeeSize = cmb_size.getValue();

        String quantityValue = cmb_quantity.getValue();
        int coffeeQuantity = Integer.parseInt(quantityValue);
        boolean sweetCream = false;
        boolean frenchVanilla = false;
        boolean irishCream = false;
        boolean caramel = false;
        boolean mocha = false;
        if(this.sweetCream.isSelected()){
            sweetCream = true;
        }
        if(this.frenchVanilla.isSelected()){
            frenchVanilla = true;
        }
        if(this.irishCream.isSelected()){
            irishCream = true;
        }
        if(this.caramel.isSelected()){
            caramel = true;
        }
        if(this.mocha.isSelected()){
            mocha = true;
        }
        return new Coffee(coffeeSize, coffeeQuantity, sweetCream, frenchVanilla, irishCream, caramel, mocha);
    }

    /**
     * Moses Devanesan
     */
    @FXML
    protected void onAddButtonPress(){

        order.addItem(createCoffee());
    }
}

