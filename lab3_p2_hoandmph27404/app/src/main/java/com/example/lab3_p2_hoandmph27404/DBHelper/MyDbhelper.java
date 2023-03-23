package com.example.lab3_p2_hoandmph27404.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbhelper extends SQLiteOpenHelper {
    static String DB_NAME="db_ghichu";
    static int DB_VERSION=1;

    public MyDbhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql_ghichu = "CREATE TABLE tb_ghichu( id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                " tieude TEXT NOT NULL UNIQUE, "+" noidung TEXT NOT NULL UNIQUE, "+" ngaythang TEXT NOT NULL UNIQUE ); ";
        db.execSQL(sql_ghichu);

//        String sql_insert_tieude = "INSERT INTO tb_ghichu (tieude) VALUES('Buổi sáng'), " +
//                " ('Buổi trưa'),('Buổi chiều'), ('Buổi tối') ";
//        db.execSQL(sql_insert_tieude);
//
//        String sql_insert_noidung = "INSERT INTO tb_ghichu (noidung) VALUES('Đi học'), " +
//                " ('Ăn trưa'),('Chơi thể thao'), ('Chạy deadline') ";
//        db.execSQL(sql_insert_noidung);
//
//        String sql_insert_ngaythang = "INSERT INTO tb_ghichu (ngaythang) VALUES('28/09/2022'), " +
//                " ('29/09/2022'),('30/09/2022'), ('01/10/2022') ";
//        db.execSQL(sql_insert_ngaythang);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
