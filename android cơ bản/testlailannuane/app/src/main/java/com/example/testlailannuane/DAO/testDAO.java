package com.example.testlailannuane.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testlailannuane.DPHelper.DBHelper;
import com.example.testlailannuane.Object.User;

import java.util.ArrayList;

public class testDAO {
    SQLiteDatabase db;
    DBHelper dbHelper;

    public testDAO(Context context){
        dbHelper=new DBHelper(context);
    }

    public testDAO() {
    }

    public void open(){
        db=dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public long addGV(User user){
        ContentValues contentValues=new ContentValues();
        contentValues.put(User.COL_NAME_GV,user.getNamegv());
        contentValues.put(User.COL_NAME_DATETIME,user.getDatetime());
        contentValues.put(User.COL_NAME_CHUYENNGANH,user.getChuyennganh());

        long res=db.insert(User.COL_NAME,null,contentValues);
        return res;
    }

    public ArrayList<User> GetAll(){
        ArrayList<User> userArrayList=new ArrayList<>();

        String[] danh_sach_lay_du_lieu=new String[]{
                User.COL_NAME_ID,User.COL_NAME_GV,User.COL_NAME_CHUYENNGANH,User.COL_NAME_DATETIME
        };
        Cursor cursor=db.query(User.COL_NAME,danh_sach_lay_du_lieu,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
             User user=new User();
             user.setId(cursor.getInt(0));
             user.setNamegv(cursor.getString(1));
             user.setDatetime(cursor.getString(2));
             user.setChuyennganh(cursor.getString(3));
             userArrayList.add(user);
             cursor.moveToNext();
        }
        return userArrayList;
    }

    public int updateGV(User user){
        ContentValues contentValues=new ContentValues();
        contentValues.put(User.COL_NAME_GV,user.getNamegv());
        contentValues.put(User.COL_NAME_DATETIME,user.getDatetime());
        contentValues.put(User.COL_NAME_CHUYENNGANH,user.getChuyennganh());

        int res=db.update(User.COL_NAME,contentValues,"id=?",new String[]{user.getId()+""});
        return res;
    }

    public int delete(User user){
        return db.delete(User.COL_NAME,"id=?",new String[]{user.getId()+""});
    }
}
