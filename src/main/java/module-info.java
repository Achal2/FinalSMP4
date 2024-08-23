module com.example.smp4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens com.example.smp4 to javafx.fxml;
    exports com.example.smp4;
}