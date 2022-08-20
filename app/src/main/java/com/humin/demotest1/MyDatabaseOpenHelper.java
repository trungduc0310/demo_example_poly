package com.humin.demotest1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String NAME_DB = "demo_test_db";
    private static final int VERSION_DB = 1;
    private static final String scripCreateTableDepartment = "create table Department(id_department INTEGER PRIMARY KEY," +
            "name_department TEXT)";
    private static final String scripCreateTableStaff = "create table Staff(id_staff INTEGER PRIMARY KEY AUTOINCREMENT, name_staff TEXT," +
            "birthday TEXT, on_board TEXT, id_department INTEGER)";
    public MyDatabaseOpenHelper(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(scripCreateTableDepartment);
        sqLiteDatabase.execSQL(scripCreateTableStaff);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
}
