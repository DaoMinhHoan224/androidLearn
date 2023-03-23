package com.example.thithu2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.thithu2.DTO.VatPham;
import com.example.thithu2.SQLite.DPhelper;

import java.util.ArrayList;

public class VatphamDAO {
     SQLiteDatabase db;
     DPhelper dphelper;

     public  VatphamDAO(Context context){
         dphelper=new DPhelper(context);
     }

     public void open(){
         db=dphelper.getWritableDatabase();
     }
     public void close(){
         dphelper.close();
     }

     public ArrayList<VatPham> GetAll(){
         ArrayList<VatPham> vatPhamArrayList=new ArrayList<>();

         String[] ds_cot=new String[]{VatPham.COL_NAME_ID,VatPham.COL_NAME_TENSP,VatPham.COL_NAME_Money};

         Cursor cursor=db.query(VatPham.TB_NAME,ds_cot,null,null,null,null,null);
         cursor.moveToFirst();
         while (!cursor.isAfterLast()){
             VatPham vatPham=new VatPham();
             vatPham.setId(cursor.getInt(0));
             vatPham.setNaem(cursor.getString(1));
             vatPham.setMoney(cursor.getDouble(2));

             vatPhamArrayList.add(vatPham);
             cursor.moveToNext();
         }
         return vatPhamArrayList;
     }

     public long Addnew(VatPham vatpham){
         ContentValues contentValues=new ContentValues();
         contentValues.put(VatPham.COL_NAME_TENSP,vatpham.getNaem());
         contentValues.put(VatPham.COL_NAME_Money,vatpham.getMoney());

         long res=db.insert(VatPham.TB_NAME,null,contentValues);
         return res;
     }

     public int updateNew(VatPham vatpham){
         ContentValues contentValues=new ContentValues();
         contentValues.put(VatPham.COL_NAME_TENSP,vatpham.getNaem());
         contentValues.put(VatPham.COL_NAME_Money,vatpham.getMoney());

         int res=db.update(VatPham.TB_NAME,contentValues,"id=?",new String[]{vatpham.getId()+""});
         return res;
     }

     public int deleteNew(VatPham vatpham){
         return db.delete(VatPham.TB_NAME,"id=?",new String[]{vatpham.getId()+""});
     }
}
