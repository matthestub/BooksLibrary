package com.example.mylibrary.dbutils;

import com.example.mylibrary.models.Author;
import com.example.mylibrary.models.Book;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class DbManager {

    public static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);
//    private static final String JDBC_H2_DRIVER = "jdbc:h2:./libraryDB";
    private static final String JDBC_SQLITE_DRIVER = "jdbc:sqlite:libraryDB.db";
//    private static final String H2_USER = "matthestub";
//    private static final String H2_PASS = "p@sswd";
    private static ConnectionSource connectionSource;

    public static void initDatabase() {
        createConnectionSource();
        dropTable();
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource() {
        try {
            connectionSource = new JdbcConnectionSource(JDBC_SQLITE_DRIVER);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource() {
        if (connectionSource == null) {
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (Exception e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable() {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Author.class);
            TableUtils.createTableIfNotExists(connectionSource, Book.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable() {
        try {
            TableUtils.dropTable(connectionSource, Author.class, true);
            TableUtils.dropTable(connectionSource, Book.class, true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

}
