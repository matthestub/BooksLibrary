package utils;

import com.example.mylibrary.LibraryApp;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.util.ResourceBundle;

public class Fxml {



    public static Pane loadFxmlFile(String fxmlPath) {

        FXMLLoader fxmlLoader = new FXMLLoader(LibraryApp.class.getResource(fxmlPath));
        fxmlLoader.setResources(getResourceBundle());
        try {
            return fxmlLoader.load();
        } catch (Exception e) {
            Dialogs.errorDialog(e.getMessage());
        }
        return null;
    }

    public static ResourceBundle getResourceBundle() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("bundles.messages");
        return resourceBundle;
    }

}
