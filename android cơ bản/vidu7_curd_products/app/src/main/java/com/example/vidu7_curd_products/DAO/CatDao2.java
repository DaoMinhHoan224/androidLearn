package com.example.vidu7_curd_products.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.vidu7_curd_products.DTO.Cat2;
import com.example.vidu7_curd_products.dBhELPER.dbhelper;

import java.util.ArrayList;
import java.util.List;

//thao tác và truy vấn với CSDL
public class CatDao2 {
    SQLiteDatabase db;

    public CatDao2(Context context){
        dbhelper dphepler=new dbhelper(context);
        db=dphepler.        getWritableDatabase();
    }

    public List<Cat2> selectAll(){
        ArrayList<Cat2> listcat=new ArrayList<Cat2>();
        String sql_select="SELECT*FROM tb_product";
        Cursor c=db.rawQuery(sql_select,null);
        if(c.moveToFirst()){
            while(!c.isAfterLast()){
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

    public long insert(Cat2 objvalue){
        ContentValues objcontent=new ContentValues();

        objcontent.put("Name",objvalue.getName());
        objcontent.put("Price",objvalue.getPrice());
        objcontent.put("img_res",objvalue.getImg_res());
        objcontent.put("id_cat",objvalue.getId_cat());

        return db.insert("tb_product",null,objcontent);
    }

    public int update(Cat2 objvalue){
        ContentValues objcontent=new ContentValues();

        objcontent.put("Name",objvalue.getName());
        objcontent.put("Price",objvalue.getPrice());
        objcontent.put("img_res",objvalue.getImg_res());
        objcontent.put("id_cat",objvalue.getId_cat());

        return db.update("tb_product",objcontent,"id=?",new String[]{objvalue.getId()+""});
    }

    public int delete(Cat2 objvalue){
        return db.delete("tb_product","id=?",new String[]{objvalue.getId()+""});
    }

    public Cat2 selectone(int id){
        Cat2 objcat=null;

        String[] dieu_kien=new String[]{id+""};

        String sql="SELECT id,name,price,img_res,id_cat FROM tb_product WHERE id=?";
        Cursor c=db.rawQuery(sql,dieu_kien);
        if(c.moveToFirst()){
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
