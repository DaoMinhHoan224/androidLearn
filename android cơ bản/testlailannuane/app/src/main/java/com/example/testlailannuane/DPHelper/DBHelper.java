package com.example.testlailannuane.DPHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static final String DB_NAME="detest2";
    static final int DB_VERSION=1;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_insert_giaovien="CREATE TABLE test2 (id INTEGER NOT NULL,namegv TEXT,datatime INTEGER,chuyennganh TEXT,PRIMARY KEY(id))";
        db.execSQL(sql_insert_giaovien);

        String sql_insert_giaovien1="INSERT INTO test2(namegv,datatime,chuyennganh) VALUES ('Thanh Huy','23/6/1990','Lt Mobile')";
        db.execSQL(sql_insert_giaovien1);

        String sql_insert_giaovien2="INSERT INTO test2(namegv,datatime,chuyennganh) VALUES ('Huy Hoàng','2/2/1999','CNTT')";
        db.execSQL(sql_insert_giaovien2);

        String sql_insert_giaovien3="INSERT INTO test2(namegv,datatime,chuyennganh) VALUES ('Jenny Nguyen','8/2/1999','English')";
        db.execSQL(sql_insert_giaovien3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
