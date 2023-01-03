package com.example.mylibrary.daos;

import com.j256.ormlite.support.ConnectionSource;

public class AuthorDao extends UniversalDao {
    public AuthorDao(ConnectionSource connectionSource) {
        super(connectionSource);
    }
}
