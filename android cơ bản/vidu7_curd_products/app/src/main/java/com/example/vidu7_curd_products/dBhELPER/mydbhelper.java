package com.example.vidu7_curd_products.dBhELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mydbhelper extends SQLiteOpenHelper {

    static final String DB_NAME="crud_product";
    static final int DB_VERSION=1;
    // viết hàm khởi tạo(tự viết không nên generate)
    public mydbhelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //các câu lệnh tạo bảng viết ở đây

        String sql_create_tb_cat="CREATE TABLE tb_cat (id INTEGER NOT NULL UNIQUE,name TEXT NOT NULL,PRIMARY KEY(id))";
        db.execSQL(sql_create_tb_cat);

        String sql_create_tb_product="CREATE TABLE tb_product (id INTEGER NOT NULL UNIQUE,name TEXT NOT NULL,price NUMERIC NOT NULL,img_res INTEGER NOT NULL,id_cat INTEGER NOT NULL,PRIMARY KEY(id))";
        db.execSQL(sql_create_tb_product);

        String sql_insert_into="INSERT INTO tb_cat (name) VALUES ('Hãng điện tử'),('Hãng gia dụng')";
        db.execSQL(sql_insert_into);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         String droptableSql="DROP TABLE IF EXISTS studentd";
         db.execSQL(droptableSql);
         onCreate(db);
    }
}
