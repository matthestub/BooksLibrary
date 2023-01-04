package com.example.mylibrary.app;

import com.example.mylibrary.models.CategoryModel;
import com.example.mylibrary.models.CategoryProperties;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CategoryController {

    @FXML
    private TextField categoryTextField;
    @FXML
    private Button categoryAddButton;
    @FXML
    private ComboBox<CategoryProperties> categoryComboBox;
    @FXML
    private Button categoryDelBtn;

    private CategoryModel categoryModel;

    public void initialize() {
        this.categoryModel = new CategoryModel();
        categoryModel.fillCategoryObservableList();
        categoryComboBox.setItems(categoryModel.getCategoryPropertiesObservableList());
        setBindings();
    }

    public void setBindings() {
        categoryAddButton.disableProperty().bind(categoryTextField.textProperty().isEmpty());
        categoryDelBtn.disableProperty().bind(categoryModel.selectedCategoryProperty().isNull());
    }

    public void onAddCategoryButtonClick() {
        categoryModel.addNewCategoryToDatabase(categoryTextField.getText());
        categoryTextField.clear();
    }

    public void onComboBoxChange() {
        categoryModel.setSelectedCategory(this.categoryComboBox.getSelectionModel().getSelectedItem());
    }

    public void onCategoryDelBtnClick() {
        categoryModel.deleteSelectedCategory();
    }
}
