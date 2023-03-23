package com.example.testlan4.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testlan4.Database.DBHelper;
import com.example.testlan4.Object.User;

import java.util.ArrayList;

public class testDAO {
    SQLiteDatabase db;
    DBHelper dbHelper;

    public testDAO(Context context){
         dbHelper=new DBHelper(context);
    }

    public void open(){
        db=dbHelper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long addGV(User user){
        ContentValues contentValues=new ContentValues();
        contentValues.put(User.COL_NAME_NAMEGV,user.getNamegv());
        contentValues.put(User.COL_NAME_NGAYGV,user.getNgaygv());
        contentValues.put(User.COL_NAME_CHUYENNGANH,user.getChuyennganhgv());

        long res=db.insert(User.COL_NAME_TB,null,contentValues);
        return res;
    }

    public ArrayList<User> Getall(){
        ArrayList<User> userArrayList=new ArrayList<>();

        String[] danhsachlaydulieu=new String[]{
                User.COL_NAME_ID,User.COL_NAME_NAMEGV,User.COL_NAME_NGAYGV,User.COL_NAME_CHUYENNGANH
        };
        Cursor cursor=db.query(User.COL_NAME_TB,danhsachlaydulieu,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            User user=new User();
            user.setId(cursor.getInt(0));
            user.setNamegv(cursor.getString(1));
            user.setNgaygv(cursor.getString(2));
            user.setChuyennganhgv(cursor.getString(3));
            userArrayList.add(user);
            cursor.moveToNext();
        }
        return userArrayList;
    }

    public int delete(User user){
        return db.delete(User.COL_NAME_TB,"idgv=?",new String[]{user.getId()+""});
    }
}
