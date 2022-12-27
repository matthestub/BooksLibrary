package com.example.mylibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Fxml;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class LibraryApp extends Application {

    public static final String MAIN_VIEW_FXML = "main-view.fxml";

    @Override
    public void start(Stage stage) throws IOException {

//        Locale.setDefault(new Locale("en"));
//        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApp.class.getResource("main-view.fxml"));
//
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("bundles.messages");
//        fxmlLoader.setResources(resourceBundle);

        Scene scene = new Scene(Fxml.loadFxmlFile(MAIN_VIEW_FXML), 800, 600);
        stage.setTitle(Fxml.getResourceBundle().getString("app.title"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}