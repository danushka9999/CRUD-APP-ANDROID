package com.example.datahandling.database;

import android.provider.BaseColumns;

public final class UsersMaster {
    private UsersMaster(){}

    /* Inner class to define the table contents*/
    public static class Users implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME_USERNAME = "username";
        public static final String COLUMN_NAME_PASSWORD = "password";

    }
}