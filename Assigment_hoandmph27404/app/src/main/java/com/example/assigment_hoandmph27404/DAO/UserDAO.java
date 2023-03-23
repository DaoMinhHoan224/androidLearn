package com.example.assigment_hoandmph27404.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assigment_hoandmph27404.DTO.User;
import com.example.assigment_hoandmph27404.database.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
     private SQLiteDatabase db;

     public UserDAO(Context context){
         DbHelper dbHelper=new DbHelper(context);
         db=dbHelper.getWritableDatabase();
     }

     public long insert(User user ){
         ContentValues values=new ContentValues();
         values.put("maUser", user.getIdUser());
         values.put("hoTen", user.getHoTen());
         values.put("matKhau",user.getMatKhau());

         return db.insert("UseR",null,values);
     }

     public int updatePass(User user){
         ContentValues values=new ContentValues();
         values.put("hoTen", user.getHoTen());
         values.put("matKhau", user.getMatKhau());

         return db.update("UseR",values,"maUser=?",new String[]{user.getIdUser()});
     }

     public int delete(String id){
         return db.delete("UseR","maUser=?", new String[]{id});
     }

     @SuppressLint("Range")
     public List<User> getData(String sql, String...selectionArgs){
         List<User> list=new ArrayList<>();
         Cursor c=db.rawQuery(sql, selectionArgs);
         while (c.moveToNext()){
             User user=new User();
             user.setIdUser(c.getString(c.getColumnIndex("maUser")));
             user.setHoTen(c.getString(c.getColumnIndex("hoTen")));
             user.setMatKhau(c.getString(c.getColumnIndex("matKHau")));

             list.add(user);
         }
         return list;
     }

     public List<User> getAll(){
         String sql="SELECT * FROM UseR";
         return getData(sql);
     }

    public User getID(String id) {
        String sql = "SELECT * FROM UseR WHERE maUser=?";
        List<User> list = getData(sql, id);
        return list.get(0);
    }

    public int checkLogin(String id,String password){
        String sql="SELECT * FROM UseR WHERE maUser=? AND matKhau=?";
        List<User> list=getData(sql,id,password);
        if (list.size() == 0)
            return -1;
        return 1;
    }

}
