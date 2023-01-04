package com.example.mylibrary.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "CATEGORIES")
public class Category implements BaseModel {
    public Category() {
    }

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(columnName = "NAME", canBeNull = false, unique = true)
    public String name;

//    @ForeignCollectionField(columnName = "BOOK_ID")
//    public ForeignCollection<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public ForeignCollection<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(ForeignCollection<Book> books) {
//        this.books = books;
//    }

}
