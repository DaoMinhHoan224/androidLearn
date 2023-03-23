package com.example.products.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.products.DTO.Cat2;
import com.example.products.dbhelper.dbhelperr;

import java.util.ArrayList;
import java.util.List;

public class Catdao2 {
     private SQLiteDatabase db;

     public Catdao2(Context context){
        dbhelperr dphelper=new dbhelperr(context);
        db=dphelper.getWritableDatabase();
     }

     public List<Cat2> selectAll(){
         ArrayList<Cat2> listcat=new ArrayList<>();
         String sql_select="SELECT*FROM tb_product";
         Cursor c=db.rawQuery(sql_select,null);

         if (c.moveToFirst()){
             while (!c.isAfterLast()){
                 Cat2 objvalue=new Cat2();
                 objvalue.setId(c.getInt(0));
                 objvalue.setName(c.getString(1));
                 objvalue.setPrice(c.getDouble(2));
                 objvalue.setImg_res(c.getString(3));
                 objvalue.setId_cat(c.getString(4));
                 listcat.add(objvalue);
                 c.moveToNext();
             }

         }
         return listcat;
     }

     public long insert(Cat2 objcat){
         ContentValues value=new ContentValues();

         value.put("Name",objcat.getName());
         value.put("Price",objcat.getPrice());
         value.put("Img_res",objcat.getImg_res());
         value.put("Id_cat",objcat.getId_cat());

         return db.insert("tb_product",null,value);
     }

     public int update(Cat2 objcat){
         ContentValues value=new ContentValues();

         value.put("Name",objcat.getName());
         value.put("Price",objcat.getPrice());
         value.put("Img_res",objcat.getImg_res());
         value.put("Id_cat",objcat.getId_cat());

         return db.update("tb_product",value,"id=?",new String[]{objcat.getId()+""});
     }

     public int delete(Cat2 objcat){
        return db.delete("tb_product","id=?",new String[]{objcat.getId()+""});
     }

     public Cat2 selectone(int id){
         Cat2 objcat=null;
         String[] dieu_kien=new String[]{id+""};

         String sql="SELECT id,name,price,img_res,id_cat FROM tb_product WHERE id=?";
         Cursor c=db.rawQuery(sql,dieu_kien);

         if (c.moveToNext()){
             objcat=new Cat2();
             objcat.setId(c.getInt(0));
             objcat.setName(c.getString(1));
             objcat.setPrice(c.getDouble(2));
             objcat.setImg_res(c.getString(3));
             objcat.setId_cat(c.getString(4));
         }
         return objcat;
     }
}
