package utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.util.Optional;
import java.util.ResourceBundle;

public class Dialogs {

    static ResourceBundle resourceBundle = Fxml.getResourceBundle();


    public static void aboutAppDialog() {

        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle(resourceBundle.getString("about"));
        informationAlert.setHeaderText(resourceBundle.getString("about.header"));
        Label label = new Label(resourceBundle.getString("about.info"));
        label.setWrapText(true);
        informationAlert.getDialogPane().setContent(label);
//        informationAlert.setContentText(resourceBundle.getString("about.info"));
        informationAlert.showAndWait();
    }


    public static Optional<ButtonType> showConfirmationDialog() {
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle(resourceBundle.getString("close"));
        confirmationAlert.setContentText(resourceBundle.getString("exit.header"));
        return confirmationAlert.showAndWait();
    }

    public static void errorDialog(String errorMessage) {

        Alert errorDialog = new Alert(Alert.AlertType.ERROR);
        errorDialog.setTitle(resourceBundle.getString("error.title"));
        errorDialog.setHeaderText(resourceBundle.getString("error.header"));

        TextArea errorTextArea = new TextArea(errorMessage);
        errorDialog.getDialogPane().setContent(errorTextArea);
        //errorDialog.getDialogPane().setContent(Fxml.loadFxmlFile("main-view.fxml"));
        errorDialog.showAndWait();
    }

}
