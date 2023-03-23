package com.example.lab6.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    static final String DB_Name="Lab6";
    static final int DB_Version=1;

    public dbhelper(@Nullable Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql_insert_lab6="CREATE TABLE lab6 (id INTEGER NOT NULL,name TEXT,img INTEGER ,PRIMARY KEY(id))";
       db.execSQL(sql_insert_lab6);

       String sql_item="INSERT INTO lab6(name,img) VALUES('android','0') ";
       db.execSQL(sql_item);
        String sql_item1="INSERT INTO lab6(name,img) VALUES('apple','1') ";
        db.execSQL(sql_item1);
        String sql_item2="INSERT INTO lab6(name,img) VALUES('blogger','2') ";
        db.execSQL(sql_item2);
        String sql_item3="INSERT INTO lab6(name,img) VALUES('chrome','3') ";
        db.execSQL(sql_item3);
        String sql_item4="INSERT INTO lab6(name,img) VALUES('dell','4') ";
        db.execSQL(sql_item4);
        String sql_item5="INSERT INTO lab6(name,img) VALUES('facebook','5') ";
        db.execSQL(sql_item5);
        String sql_item6="INSERT INTO lab6(name,img) VALUES('firefox','6') ";
        db.execSQL(sql_item6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
