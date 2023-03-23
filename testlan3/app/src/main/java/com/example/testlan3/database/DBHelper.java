package com.example.testlan3.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static final String DB_NAME="detestlan2";
    static final int DB_VERSION=1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_insert_gv="CREATE TABLE detestlai2 (idgv INTEGER NOT NULL,namegv TEXT,ngaygv INTEGER,chuyennganhgv TEXT,PRIMARY KEY(idgv))";
        db.execSQL(sql_insert_gv);

        String sql_insert_gv1="INSERT INTO detestlai2(namegv,ngaygv,chuyennganhgv) VALUES ('Thanh Huy','23/6/1990','Lt Mobile')";
        db.execSQL(sql_insert_gv1);

        String sql_insert_gv2="INSERT INTO detestlai2(namegv,ngaygv,chuyennganhgv) VALUES ('Huy Hoàng','2/2/1999','CNTT')";
        db.execSQL(sql_insert_gv2);

        String sql_insert_gv3="INSERT INTO detestlai2(namegv,ngaygv,chuyennganhgv) VALUES ('Jenny Nguyen','8/2/1999','English')";
        db.execSQL(sql_insert_gv3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
