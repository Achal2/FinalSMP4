package com.example.smp4;

import Model.Order;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Moses Devanesan
 */
public class HelloController implements Initializable {

    @FXML
    private ImageView sugarDonut = new ImageView();

    @FXML
    private ImageView coffee = new ImageView();

    @FXML
    private ImageView GcSand = new ImageView();
    @FXML
    private ImageView orderCoffee = new ImageView();

    @FXML
    private ImageView allOrders = new ImageView();

    private static Order currentOrder = new Order();

    /**
     * @author Achal Mukkapati
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Image Donut= new Image("file:src/pictures/sugarDonut.png");
        sugarDonut.setImage(Donut);


        Image Coffee = new Image("file:src/pictures/beancoffee.png");
        coffee.setImage(Coffee);

        Image Sand = new Image("file:src/pictures/GcSand.png");
        GcSand.setImage(Sand);

        Image coffeeOrder= new Image("file:src/pictures/orderCoffee.png");
        orderCoffee.setImage(coffeeOrder);

        Image allOrder= new Image("file:src/pictures/allOrders.png");
        allOrders.setImage(allOrder);


    }

    /**
     * @author Moses Devanesan
     */
    public static void newOrder(){
        currentOrder = new Order();
    }

    public static Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * @author Achal Mukkapati
     * @param event
     * @throws IOException
     */
    @FXML
    void openCoffeeWindow(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Coffee.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Coffee");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @author Achal Mukkapati
     * @param event
     * @throws IOException
     */
    @FXML
    void openDonutWindow(ActionEvent event) throws IOException{

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Donut.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Donut");
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @author Achal Mukkapati
     * @param event
     * @throws IOException
     */
    @FXML
    void openSandwichWindow(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Sandwich.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Sandwich");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @author Moses Devanesan
     * @param event
     * @throws IOException
     */
    @FXML
    void openCurrentOrderWindow(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Order.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Current Order Style");
        stage.setScene(scene);
        stage.show();


    }

    /**
     * @author Moses Devanesan
     * @param event
     * @throws IOException
     */
    @FXML
    void openOrdersWindow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("allOrder.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("All Store Orders");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @author Achal Mukkapati
     * @param event
     * @throws IOException
     */
    @FXML
    void openAllWindow(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Coffee.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Coffee");
        stage.setScene(scene);
        stage.show();
    }




}