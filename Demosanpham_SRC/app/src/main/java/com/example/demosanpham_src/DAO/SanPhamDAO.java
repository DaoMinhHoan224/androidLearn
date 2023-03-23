package com.example.demosanpham_src.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.demosanpham_src.DbHelper.MyDbhelper;

public class SanPhamDAO {
    MyDbhelper mydbhelper;
    SQLiteDatabase db;

    public SanPhamDAO(Context context){
        mydbhelper=new MyDbhelper(context);
        db=mydbhelper.getWritableDatabase();
    }

    public Cursor providerSelectAll(String[] columns, String selection, String[] selectionArgs, String orderBy){
        Cursor c=db.query("tb_sanpham",columns,selection,selectionArgs,null,null,orderBy);
        return c;
    }
}
