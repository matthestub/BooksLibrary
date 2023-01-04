package com.example.mylibrary.models;

import com.example.mylibrary.daos.CategoryDao;
import com.example.mylibrary.dbutils.DbManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class CategoryModel {

    private ObservableList<CategoryProperties> categoryPropertiesObservableList = FXCollections.observableArrayList();
    private ObjectProperty<CategoryProperties> selectedCategory = new SimpleObjectProperty<>();

    public void fillCategoryObservableList() {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        List<Category> categoryList = categoryDao.queryForAll(Category.class);
        categoryPropertiesObservableList.clear();
        categoryList.forEach(c -> {
            CategoryProperties categoryProperty = new CategoryProperties();
            categoryProperty.setId(c.getId());
            categoryProperty.setName(c.getName());
            categoryPropertiesObservableList.add(categoryProperty);
        });
        DbManager.closeConnectionSource();
    }

    public void addNewCategoryToDatabase(String name) {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        Category category = new Category();
        category.setName(name);
        categoryDao.universalCreateOrUpdate(category);
        DbManager.closeConnectionSource();
        fillCategoryObservableList();
    }


    public void deleteSelectedCategory() {
        CategoryDao categoryDao = new CategoryDao(DbManager.getConnectionSource());
        categoryDao.universalDeleteById(Category.class, getSelectedCategory().getId());
        DbManager.closeConnectionSource();
        fillCategoryObservableList();
    }

    public ObservableList<CategoryProperties> getCategoryPropertiesObservableList() {
        return categoryPropertiesObservableList;
    }

    public void setCategoryPropertiesObservableList(ObservableList<CategoryProperties> categoryPropertiesObservableList) {
        this.categoryPropertiesObservableList = categoryPropertiesObservableList;
    }

    public CategoryProperties getSelectedCategory() {
        return selectedCategory.get();
    }

    public ObjectProperty<CategoryProperties> selectedCategoryProperty() {
        return selectedCategory;
    }

    public void setSelectedCategory(CategoryProperties selectedCategory) {
        this.selectedCategory.set(selectedCategory);
    }
}
