package com.example.vidu7_curd_products.dBhELPER;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.BaseAdapter;

public class dbhelper extends SQLiteOpenHelper {
    public static final String DBName="products";
    public static final int DBversion=2;

    public dbhelper(Context context){
        super(context,DBName,null,DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_create_tb_product="CREATE TABLE tb_product (id INTEGER NOT NULL UNIQUE,name TEXT NOT NULL,price NUMERIC NOT NULL,img_res INTEGER NOT NULL,id_cat INTEGER NOT NULL,PRIMARY KEY(id))";
        db.execSQL(sql_create_tb_product);

        String sql_insert_into="INSERT INTO tb_product (name) VALUES ('Đào Minh Hoàn'),('Nguyễn Minh Đức')  ";
        db.execSQL(sql_insert_into);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         String dropTablesql="DROP TABLE IF EXISTS students";
         db.execSQL(dropTablesql);
         onCreate(db);
    }
}
