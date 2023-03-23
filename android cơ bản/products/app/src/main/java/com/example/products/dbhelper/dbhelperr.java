package com.example.products.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelperr extends SQLiteOpenHelper {

    public static final String DB_Name="products";
    public static final int DB_version=1;

    public dbhelperr(Context context) {
        super(context, DB_Name, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql_create_tb_product="CREATE TABLE tb_product (id INTEGER NOT NULL UNIQUE,name TEXT NOT NULL,price NUMERIC NOT NULL,img_res INTEGER NOT NULL,id_cat INTEGER NOT NULL,PRIMARY KEY(id))";
       db.execSQL(sql_create_tb_product);

//       String sql_insert_into="INSERT INTO tb_product (name) VALUES ('Đào Minh Hoàn'),('Nguyễn Minh Đức') ";
//       db.execSQL(sql_insert_into);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      String drop_table="DROP TABLE IF EXISTS students";
      db.execSQL(drop_table);
      onCreate(db);
    }
}
