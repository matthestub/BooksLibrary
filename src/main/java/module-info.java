module com.example.mylibrary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mylibrary to javafx.fxml;
    exports com.example.mylibrary;
    exports utils;
    opens utils to javafx.fxml;
}