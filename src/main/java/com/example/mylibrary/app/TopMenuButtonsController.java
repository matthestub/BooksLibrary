package com.example.mylibrary.app;

import com.example.mylibrary.app.LibraryController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String LIBRARY_VIEW_FXML = "/com/example/mylibrary/library-view.fxml";
    public static final String BOOK_LIST_VIEW_FXML = "/com/example/mylibrary/bookList-view.fxml";
    public static final String STATS_VIEW_FXML = "/com/example/mylibrary/stats-view.fxml";
    public static final String ADDBOOK_VIEW_FXML = "/com/example/mylibrary/addbook-view.fxml";
    public static final String ADDCATEGORY_VIEW_FXML = "/com/example/mylibrary/addCategory-view.fxml";
    private LibraryController libraryController;

    @FXML
    private ToggleGroup toggleButtons;
    @FXML
    public void openLibrary() {
        libraryController.setCenterPanel(LIBRARY_VIEW_FXML);
    }
    @FXML
    public void openBookList() {
        libraryController.setCenterPanel(BOOK_LIST_VIEW_FXML);
    }
    @FXML
    public void openStatistics() {
        libraryController.setCenterPanel(STATS_VIEW_FXML);
    }


    public void setLibraryController(LibraryController libraryController) {
        this.libraryController = libraryController;
    }

    public void addBook() {
        resetToggleButtons();
        libraryController.setCenterPanel(ADDBOOK_VIEW_FXML);
    }


    public void addCategory() {
        resetToggleButtons();
        libraryController.setCenterPanel(ADDCATEGORY_VIEW_FXML);
    }

    private void resetToggleButtons() {
        if (toggleButtons.getSelectedToggle() != null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }
    }
}
