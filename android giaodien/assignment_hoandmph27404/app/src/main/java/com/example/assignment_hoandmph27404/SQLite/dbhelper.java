package com.example.assignment_hoandmph27404.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    static final String DB_Name="asssssm";
    static final int DB_Version=1;

    public dbhelper(Context context){
        super(context,DB_Name,null,DB_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql_insert_class="CREATE TABLE assignmentclassss (id_cl INTEGER NOT NULL UNIQUE,Id_Class INTEGER NOT NULL,Tenlop TEXT NOT NULL,PRIMARY KEY(id_cl))";
       db.execSQL(sql_insert_class);

       String sql_insert_sv="CREATE TABLE assignmentsv (Stt INTEGER NOT NULL UNIQUE,Lop TEXT NOT NULL,Tensv TEXT NOT NULL,Ngaysinh INTEGER NOT NULL,sdt INTEGER NOT NULL,id_cl INTEGER NOT NULL,PRIMARY KEY(Stt))";
       db.execSQL(sql_insert_sv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
