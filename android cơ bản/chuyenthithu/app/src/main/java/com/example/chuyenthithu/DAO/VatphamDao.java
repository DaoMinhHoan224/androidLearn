package com.example.chuyenthithu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.chuyenthithu.DTO.VatPham;
import com.example.chuyenthithu.SQLite.DPhelper;

import java.util.ArrayList;

public class VatphamDao {
    SQLiteDatabase db;
    DPhelper dphelper;

    public VatphamDao(Context context){
        dphelper=new DPhelper(context);
    }

    public void open(){
        db=dphelper.getWritableDatabase();
    }

    public void close(){
        dphelper.close();
    }

    public ArrayList<VatPham> GetAll(){
        ArrayList<VatPham> vatPhamArrayList =new ArrayList<>();

        String[] ds_cot=new String[]{VatPham.COL_NAME_ID,VatPham.COL_NAME_TENSP,VatPham.COL_NAME_MONEY};

        Cursor cursor= db.query(VatPham.TB_NAME,ds_cot,null,null,null,null,null);
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

    public long AddNew(VatPham vatpham){
        ContentValues contentValues=new ContentValues();
        contentValues.put(VatPham.COL_NAME_TENSP,vatpham.getName());
        contentValues.put(VatPham.COL_NAME_MONEY,vatpham.getMoney());

        long res=db.insert(VatPham.TB_NAME,null,contentValues);
        return res;
    }

    public int updateNew(VatPham vatpham){
        ContentValues contentValues=new ContentValues();
        contentValues.put(VatPham.COL_NAME_TENSP,vatpham.getName());
        contentValues.put(VatPham.COL_NAME_MONEY,vatpham.getMoney());

        int res=db.update(VatPham.TB_NAME,contentValues,"id=?",new String[]{vatpham.getId()+""});
        return res;
    }

    public int deleteNew(VatPham vatpham){
        return db.delete(VatPham.TB_NAME,"id=?", new String[]{vatpham.getId()+""});
    }
}

