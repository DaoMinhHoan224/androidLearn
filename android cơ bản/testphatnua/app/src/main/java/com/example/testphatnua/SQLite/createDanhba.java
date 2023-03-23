package com.example.testphatnua.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class createDanhba extends SQLiteOpenHelper {
    public static final String DB_Name="danhba";
    public static final int DB_Version=1;

    public createDanhba(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_insert_quanlydanhba="CREATE TABLE quanlydanhba (id INTEGER NOT NULL,hoten TEXT NOT NULL,sdt INTEGER NOT NULL,ghichu TEXT NOT NULL,PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql_insert_quanlydanhba);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
