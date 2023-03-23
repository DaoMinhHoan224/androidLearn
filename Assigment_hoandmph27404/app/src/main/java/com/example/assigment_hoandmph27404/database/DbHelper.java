package com.example.assigment_hoandmph27404.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    static final String dbName="asmm";
    static final int dbVersion=1;

    public DbHelper(Context context) {
        super(context,dbName,null,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String createTableUser= "create table UseR (" +
                 "maUser TEXT PRIMARY KEY, " +
                 "hoTen TEXT NOT NULL, " +
                 "matKhau TEXT NOT NULL)";
         db.execSQL(createTableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
