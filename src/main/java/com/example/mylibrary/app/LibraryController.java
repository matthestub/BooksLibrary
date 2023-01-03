package com.example.mylibrary.app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import com.example.mylibrary.utils.Dialogs;
import com.example.mylibrary.utils.Fxml;

import java.util.Optional;

public class LibraryController {

    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private TopMenuButtonsController topMenuButtonsController;

    public void initialize() {
        topMenuButtonsController.setLibraryController(this);
    }


    public void setCenterPanel(String pathToFxml) {
//        FXMLLoader loader = new FXMLLoader(LibraryApp.class.getResource(pathToFxml));
//        ResourceBundle bundle = ResourceBundle.getBundle("bundles.messages");
//        loader.setResources(bundle);
//
//        Parent addBookView = null;
//        try {
//            addBookView = loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        mainBorderPane.setCenter(Fxml.loadFxmlFile(pathToFxml));
    }

    public void onClose() {
        Optional<ButtonType> result = Dialogs.showConfirmationDialog();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }

    public void onChangeCaspian() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    public void onChangeModena() {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    public void setPersistentVisibility(ActionEvent event) {
        Stage stage = (Stage) mainBorderPane.getScene().getWindow();
        CheckMenuItem checkMenuItem = (CheckMenuItem) event.getSource();
        boolean value = checkMenuItem.selectedProperty().get();
        stage.setAlwaysOnTop(value);
    }

    public void onAbout() {
        Dialogs.aboutAppDialog();
    }
}