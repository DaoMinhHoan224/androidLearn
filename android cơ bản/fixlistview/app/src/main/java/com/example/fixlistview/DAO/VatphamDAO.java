package com.example.fixlistview.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.fixlistview.DTO.VatPham;
import com.example.fixlistview.SQLite.DPhelper;

import java.util.ArrayList;

public class VatphamDAO {
    SQLiteDatabase db;
    DPhelper dphelper;

     public VatphamDAO(Context context){
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

         String[] ds_cot=new String[]{"*"};

         Cursor cursor=db.query(VatPham.TB_NAME,ds_cot,null,null,null,null,null);
         cursor.moveToFirst();
         while (!cursor.isAfterLast()){
             VatPham vatpham=new VatPham();
             vatpham.setId(cursor.getInt(0));
             vatpham.setName(cursor.getString(1));
             vatpham.setMoney(cursor.getDouble(2));

             vatPhamArrayList.add(vatpham);
             cursor.moveToNext();
         }
         return vatPhamArrayList;
     }

     public long addNew(VatPham vatpham){
         ContentValues contentvalues=new ContentValues();
         contentvalues.put(VatPham.COL_NAME_TENSP,vatpham.getName());
         contentvalues.put(VatPham.COL_NAME_TIEN,vatpham.getMoney());

         long res=db.insert(VatPham.TB_NAME,null,contentvalues);
         return res;
     }

     public int updateNew(VatPham vatpham){
         ContentValues contentvalues=new ContentValues();
         contentvalues.put(VatPham.COL_NAME_TENSP,vatpham.getName());
         contentvalues.put(VatPham.COL_NAME_TIEN,vatpham.getMoney());

         int res=db.update(VatPham.TB_NAME,contentvalues,"id=?",new String[]{vatpham.getId()+""});
         return res;
     }

     public int deleteNew(VatPham vatpham){
         return db.delete(VatPham.TB_NAME,"id=?",new  String[]{vatpham.getId()+""});
     }
}
