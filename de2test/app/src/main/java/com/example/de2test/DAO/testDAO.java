package com.example.de2test.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.de2test.Object.User;
import com.example.de2test.database.DBHelper;

import java.util.ArrayList;

public class testDAO {
    SQLiteDatabase db;
    DBHelper dbHelper;

    public testDAO(Context context){
        dbHelper=new DBHelper(context);
    }

    public  testDAO(){

    }

    public void open(){
        db=dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public long addGV(User user){
        ContentValues contentValues=new ContentValues();
        contentValues.put(User.COL_NAME_NAMEGV,user.getName_gv());
        contentValues.put(User.COL_NAME_CHUYENNGANH,user.getChuyennganh());
        contentValues.put(User.COL_NAME_DATETIME,user.getDateTime());

        long res=db.insert(User.COL_NAME,null,contentValues);
        return res;
    }

    public ArrayList<User> GetAll(){
        ArrayList<User>userArrayList=new ArrayList<>();
        String[] danh_sach_lay_du_lieu=new String[]{
                User.COL_NAME_ID,User.COL_NAME_NAMEGV,User.COL_NAME_CHUYENNGANH,User.COL_NAME_DATETIME
        };
        Cursor cursor=db.query(User.COL_NAME,danh_sach_lay_du_lieu,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            User user=new User();
            user.setId(cursor.getInt(0));
            user.setName_gv(cursor.getString(1));
            user.setChuyennganh(cursor.getString(2));
            user.setDateTime(cursor.getString(3));
            userArrayList.add(user);
            cursor.moveToNext();
        }
        return userArrayList;
    }

    public int update(User user){
        ContentValues contentValues=new ContentValues();
        contentValues.put(User.COL_NAME_NAMEGV,user.getName_gv());
        contentValues.put(User.COL_NAME_CHUYENNGANH,user.getChuyennganh());
        contentValues.put(User.COL_NAME_DATETIME,user.getDateTime());

        int res=db.update(User.COL_NAME,contentValues,"id=?",new String[]{user.getId()+""});
        return res;
    }

    public int delete(User user){
        return db.delete(User.COL_NAME,"id=?",new String[]{user.getId()+""});
    }
}
