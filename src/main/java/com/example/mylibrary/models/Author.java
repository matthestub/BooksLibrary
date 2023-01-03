package com.example.mylibrary.models;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "AUTHORS")
public class Author implements BaseModel {

    public Author() {
    }

    @DatabaseField(generatedId = true)
    public int id;
    @DatabaseField(columnName = "Author_name")
    public String authorName;
    @DatabaseField(columnName = "Author_surname")
    public String authorSurname;

    @ForeignCollectionField(eager = true) // eager oznacza ze ta kolekcja od razu zostanie uzupelniona, lazy - tylko gdy odpytam
    public ForeignCollection<Book> booksCollection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public ForeignCollection<Book> getBooksCollection() {
        return booksCollection;
    }

    public void setBooksCollection(ForeignCollection<Book> booksCollection) {
        this.booksCollection = booksCollection;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", books=" + booksCollection +
                '}';
    }
}
