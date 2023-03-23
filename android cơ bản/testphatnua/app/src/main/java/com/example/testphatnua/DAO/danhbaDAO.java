package com.example.testphatnua.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.testphatnua.DTO.danhBa;
import com.example.testphatnua.SQLite.createDanhba;

import java.util.ArrayList;

public class danhbaDAO  {
     SQLiteDatabase db;
     createDanhba createdanhba;

     public danhbaDAO(Context context){
         createdanhba=new createDanhba(context);
     }

     public void open(){
         db=createdanhba.getWritableDatabase();
     }

     public void close(){
         createdanhba.close();
     }

     public long addNew(danhBa danhba){
         ContentValues contentvalues=new ContentValues();
         contentvalues.put(danhba.COL_NAME_HO_TEN,danhba.getHoten());
         contentvalues.put(danhba.COL_NAME_SDT,danhba.getSdt());
         contentvalues.put(danhba.COL_NAME_GHI_CHU,danhba.getGhichu());

         long res=db.insert(danhba.TB_NAME,null,contentvalues);
         return res;
     }

     public ArrayList<danhBa> GetAll(){
         ArrayList<danhBa> danhBas=new ArrayList<>();

         String[] danh_sach_cot_lay_du_lieu=new String[]{
             danhBa.COL_NAME_ID,danhBa.COL_NAME_HO_TEN,danhBa.COL_NAME_SDT,danhBa.COL_NAME_GHI_CHU
         };

         Cursor c=db.query(danhBa.TB_NAME,danh_sach_cot_lay_du_lieu,null,null,null,null,null);
         c.moveToFirst();
         while (!c.isAfterLast()){
             int id=c.getInt(0);
             String hoten=c.getString(1);
             String sdt=c.getString(2);
             String ghichu=c.getString(3);

             danhBa danhbaa=new danhBa();
             danhbaa.setId(id);
             danhbaa.setHoten(hoten);
             danhbaa.setSdt(sdt);
             danhbaa.setGhichu(ghichu);

             danhBas.add(danhbaa);
         }
         return danhBas;

     }
     public int update(danhBa danhba){
         ContentValues contentvalues=new ContentValues();
         contentvalues.put(danhba.COL_NAME_HO_TEN,danhba.getHoten());
         contentvalues.put(danhba.COL_NAME_SDT,danhba.getSdt());
         contentvalues.put(danhba.COL_NAME_GHI_CHU,danhba.getGhichu());

         int res=db.update(danhba.TB_NAME,contentvalues,"id=? " + danhba.getId(),null);
         return res;
     }

     public int delete(danhBa danhba){
          return db.delete(danhba.TB_NAME,"id=?" + danhba.getId(),null);
     }
}
