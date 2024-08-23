package com.example.smp4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import Model.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Moses Devanesan
 */
public class SandwichViewController  implements Initializable {

    @FXML
    private TextField price;

    @FXML
    private RadioButton bagel, wheatToast, sourDough, beef, chicken, fish;

    @FXML
    private ToggleGroup proteinGroup, breadGroup;

    @FXML
    private CheckBox cheese = new CheckBox();
    @FXML
    private CheckBox lettuce = new CheckBox();
    @FXML
    private CheckBox tomatoes = new CheckBox();
    @FXML
    private CheckBox onions = new CheckBox();

    @FXML
    private ImageView grilledcheese1 = new ImageView();

    private Order order;


    /**
     * @author Achal Mukkapati
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        order = HelloController.getCurrentOrder();

        Image Sandwich = new Image("file:src/pictures/grilledcheese1.png");
        grilledcheese1.setImage(Sandwich);

        proteinGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> priceUpdate());

        price.setText("$" + 0);
        priceUpdate();
    }

    /**
     * @author Moses Devanesan
     */
    @FXML
    public void priceUpdate() {
        DecimalFormat df = new DecimalFormat("##,###.00");
        String currentPrice = df.format(createSandwich().itemPrice());
        price.setText("$" + currentPrice);
    }

    /**
     * @author Achal Mukkapati
     * @return
     */
    public Sandwich createSandwich() {


        String sandwichBread = ((RadioButton)breadGroup.getSelectedToggle()) != null ? ((RadioButton)breadGroup.getSelectedToggle()).getText().toLowerCase() : "";
        String sandwichProtein = ((RadioButton)proteinGroup.getSelectedToggle()) != null ? ((RadioButton)proteinGroup.getSelectedToggle()).getText().toLowerCase() : "";


        boolean cheeseSelected = this.cheese.isSelected();
        boolean lettuceSelected = this.lettuce.isSelected();
        boolean tomatoesSelected = this.tomatoes.isSelected();
        boolean onionsSelected = this.onions.isSelected();

        return new Sandwich(sandwichProtein, sandwichBread, cheeseSelected, lettuceSelected, tomatoesSelected, onionsSelected);
    }

    /**
     * @author Achal Mukkapati
     */
    @FXML
    protected void onAddButtonPress() {
        order.addItem(createSandwich());
    }
}
