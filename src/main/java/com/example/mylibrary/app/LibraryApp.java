package com.example.mylibrary.app;

import com.example.mylibrary.dbutils.DbManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.example.mylibrary.utils.Fxml;

import java.io.IOException;

public class LibraryApp extends Application {

    public static final String MAIN_VIEW_FXML = "/com/example/mylibrary/main-view.fxml";

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
        DbManager.initDatabase();
    }

    public static void main(String[] args) {
        launch();
    }
}