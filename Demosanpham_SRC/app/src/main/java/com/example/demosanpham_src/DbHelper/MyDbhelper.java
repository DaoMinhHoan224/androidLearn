package com.example.demosanpham_src.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbhelper extends SQLiteOpenHelper {
    static String DB_NAME="db_banhang";
    static int DB_VERSION=1;
    public MyDbhelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE tb_sanpham( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " name TEXT NOT NULL UNIQUE ); ";
        db.execSQL(sql);


        // chèn dữ liệu DEMO
        String sql_insert = "INSERT INTO tb_sanpham (name) VALUES('Điện thoại'), " +
                " ('Máy tính'),('Tivi'), ('Tủ lạnh') ";
        db.execSQL(sql_insert);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
