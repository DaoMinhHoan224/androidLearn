package com.example.thithu2.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DPhelper  extends SQLiteOpenHelper{
     static final String DB_NAME="asdfgh";
     static final int DB_VERSION=1;

    public DPhelper(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_insert_jhsafsajf="CREATE TABLE tbl_vatpham (id INTEGER NOT NULL,tensp TEXT NOT NULL,money INTEGER NOT NULL,PRIMARY KEY(id))";
        db.execSQL(sql_insert_jhsafsajf);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
