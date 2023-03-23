package com.example.testtt.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class dPhelpEr extends SQLiteOpenHelper {
    static final String DB_NAME="crud_vatpham";
    static final int DB_VERSION=1;

    public dPhelpEr(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql_vatpham="CREATE TABLE table_vatpham (id INTEGER NOT NULL,tensp TEXT NOT NULL,money INTEGER NOT NULL,PRIMARY KEY(id))";
       db.execSQL(sql_vatpham);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
