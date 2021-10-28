package com.example.datahandling.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHelper( Context context) { super(context, DATABASE_NAME, null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UsersMaster.Users.TABLE_NAME + " (" +
                        UsersMaster.Users._ID + " INTEGER PRIMARY KEY," +
                        UsersMaster.Users.COLUMN_NAME_USERNAME + " TEXT," +
                        UsersMaster.Users.COLUMN_NAME_PASSWORD + " TEXT)";
        db.execSQL(SQL_CREATE_ENTRIES); //This will execute the contents of SQL_CREATE_ENTRIES

    }

    public void addInfo(String userName, String password){
        //Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        //Create a new map of values, where column names the keys
        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_USERNAME, userName);
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD, password);

        //Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(UsersMaster.Users.TABLE_NAME, null,values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
