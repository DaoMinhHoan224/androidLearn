package com.example.baitestgiaodienandroid.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baitestgiaodienandroid.database.dbhelper;
import com.example.baitestgiaodienandroid.object.User;

import java.util.ArrayList;

public class testDAO {
    SQLiteDatabase db;
    dbhelper dbhelper;

    public testDAO(Context context){
        dbhelper=new dbhelper(context);
    }

    public testDAO(){};

    public void open(){
        db=dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public long addT(User user){
        ContentValues contentValues=new ContentValues();
        contentValues.put(User.COL_NAME_CONTENT,user.getContent());
        contentValues.put(User.COL_NAME_DATETIME,user.getDataTime());

        long res=db.insert(User.COL_NAME,null,contentValues);

        return res;
    }

    public ArrayList<User> GetAll(){
        ArrayList<User> userArrayList=new ArrayList<>();

        String[] danh_sach_lay_du_lieu=new String[]{
                User.COL_NAME_ID,User.COL_NAME_CONTENT,User.COL_NAME_DATETIME
        };
        Cursor cursor=db.query(User.COL_NAME,danh_sach_lay_du_lieu,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            User user=new User();
            user.setId(cursor.getInt(0));
            user.setContent(cursor.getString(1));
            user.setDataTime(cursor.getString(2));
            userArrayList.add(user);
            cursor.moveToNext();
        }
        return  userArrayList;
    }

    public int delete(User user){
        return db.delete(User.COL_NAME,"id=?",new String[]{user.getId()+""});
    }
}
