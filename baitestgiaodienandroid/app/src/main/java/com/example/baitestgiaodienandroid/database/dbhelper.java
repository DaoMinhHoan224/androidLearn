package com.example.baitestgiaodienandroid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    static final String DB_NAME="test_thithuu";
    static final int DB_VERSION=1;
    public dbhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         String sql_insert_ghichu="CREATE TABLE test_thithu (id INTEGER NOT NULL,content TEXT,dataTime INTEGER,PRIMARY KEY(id))";
         db.execSQL(sql_insert_ghichu);

         String sql_insert_ghichu1="INSERT INTO test_thithu(content,dataTime) VALUES ('Dậy lúc 6 giờ','15/08/2022')";
         db.execSQL(sql_insert_ghichu1);
         String sql_insert_ghichu2="INSERT INTO test_thithu(content,dataTime) VALUES ('Ăn sáng lúc 7 giờ','15/08/2022')";
         db.execSQL(sql_insert_ghichu2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
