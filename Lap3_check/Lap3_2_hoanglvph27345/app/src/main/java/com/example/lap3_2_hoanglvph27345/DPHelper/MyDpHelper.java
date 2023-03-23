package com.example.lap3_2_hoanglvph27345.DPHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDpHelper extends SQLiteOpenHelper {
    static String DB_NAME = "mynote.db";
    static int DB_VERSION = 1;
    public MyDpHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tb_mynote (id_note INTEGER NOT NULL,title TEXT NOT NULL UNIQUE,noidung TEXT NOT NULL,ngaythang TEXT NOT NULL,PRIMARY KEY(id_note AUTOINCREMENT))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
