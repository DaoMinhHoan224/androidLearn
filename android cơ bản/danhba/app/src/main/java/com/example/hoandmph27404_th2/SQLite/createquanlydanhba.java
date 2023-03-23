package com.example.hoandmph27404_th2.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class createquanlydanhba extends  SQLiteOpenHelper{
 public static final String DB_NAME="quanlydanhba";
 public static final int DB_VERSION=1;

 public createquanlydanhba(Context context) {

  super(context,DB_NAME,null,DB_VERSION);
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


