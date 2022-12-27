package com.example.mylibrary;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class TopMenuButtonsController {

    public static final String LIBRARY_VIEW_FXML = "library-view.fxml";
    public static final String BOOK_LIST_VIEW_FXML = "bookList-view.fxml";
    public static final String STATS_VIEW_FXML = "stats-view.fxml";
    public static final String ADDBOOK_VIEW_FXML = "addbook-view.fxml";
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
        if (toggleButtons.getSelectedToggle() != null) {
            toggleButtons.getSelectedToggle().setSelected(false);
        }

        libraryController.setCenterPanel(
                ADDBOOK_VIEW_FXML);


    }
}
