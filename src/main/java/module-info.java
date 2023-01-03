module com.example.mylibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires ormlite.jdbc;
    requires java.sql;


    opens com.example.mylibrary to javafx.fxml;
    exports com.example.mylibrary.utils;
    opens com.example.mylibrary.utils to javafx.fxml;
    exports com.example.mylibrary.app;
    exports com.example.mylibrary.daos;
    exports com.example.mylibrary.dbutils;
    exports com.example.mylibrary.models;
    opens com.example.mylibrary.app to javafx.fxml;
}