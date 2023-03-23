package com.example.lab6.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab6.DBHelper.dbhelper;
import com.example.lab6.DTO.Lab6;

import java.util.ArrayList;

public class Lab6DAO {
    SQLiteDatabase db;
    dbhelper dbhelper;

    public Lab6DAO(Context context){
        dbhelper=new dbhelper(context);
    }

    public Lab6DAO(){

    }

    public void open(){
        db=dbhelper.getWritableDatabase();

    }

    public void close(){
        dbhelper.close();
    }

    public long addLT(Lab6 lab6){
        ContentValues contentvalues=new ContentValues();


        contentvalues.put(Lab6.COL_NAME,lab6.getName());

        long res=db.insert(Lab6.TB_NAMELAB6,null,contentvalues);

        return res;
    }

    public ArrayList<Lab6> getAll(){
        String sql="SELECT * FROM lab6";
        ArrayList<Lab6> lab6ArrayList=new ArrayList<>();
        db=dbhelper.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Lab6 lab6=new Lab6();
            lab6.setId(cursor.getInt(0));
            lab6.setName(cursor.getString(1));
            lab6.setImg(cursor.getInt(2));
            lab6ArrayList.add(lab6);
            cursor.moveToNext();
        }

        return lab6ArrayList;
    }

    public boolean updateLT(Lab6 lab6){
        db=dbhelper.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();

        contentvalues.put(Lab6.COL_NAME,lab6.getName());

        int res=db.update(Lab6.TB_NAMELAB6,contentvalues,"id = " + lab6.getId(),null );

        return (res>0);
    }

    public int deleteLT(Lab6 lab6){
        return db.delete(Lab6.TB_NAMELAB6,"id=?",new String[]{lab6.getId()+""});
    }
}
