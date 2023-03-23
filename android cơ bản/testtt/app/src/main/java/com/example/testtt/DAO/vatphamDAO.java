package com.example.testtt.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.testtt.DTO.vatPham;
import com.example.testtt.SQLite.dPhelpEr;

import java.util.ArrayList;

public class vatphamDAO {
    SQLiteDatabase db;
    dPhelpEr dphelper;


    public vatphamDAO(Context context){
        dphelper=new dPhelpEr(context);
    }

    public void open(){
        db=dphelper.getWritableDatabase();
    }

    public void close(){
       dphelper.close();
    }

    public long insertVP(vatPham objvatpham){
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(vatPham.COL_NAME_NAME,objvatpham.getTensp());
        contentvalues.put(vatPham.COL_NAME_MONEY,objvatpham.getMoney());

        long res=db.insert(vatPham.TB_NAME,null,contentvalues);
        return res;
    }

    public int updateVP(vatPham objvatpham){
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(vatPham.COL_NAME_NAME,objvatpham.getTensp());
        contentvalues.put(vatPham.COL_NAME_MONEY,objvatpham.getMoney());

        int res=db.update(vatPham.TB_NAME,contentvalues,"id=?",new String[]{objvatpham.getId()+""});
        return res;
    }

    public int deleteVP(vatPham objvatpham){
        return db.delete(vatPham.TB_NAME,"id=?",new String[]{objvatpham.getId()+""});
    }

    public ArrayList<vatPham> GetAll(){
       ArrayList<vatPham>listVP=new ArrayList<>();
       String[] ds_cot=new String[]{vatPham.COL_NAME_ID,vatPham.COL_NAME_NAME,vatPham.COL_NAME_MONEY};

        Cursor c=db.query(vatPham.TB_NAME,ds_cot,null,null,null,null,null);
        c.moveToFirst();
        if (!c.isAfterLast()){
            vatPham vatpham =new vatPham();
            vatpham .setId(c.getInt(0));
            vatpham .setTensp(c.getString(1));
            vatpham .setMoney(c.getDouble(2));

            listVP.add(vatpham );
            c.moveToNext();
        }
        return listVP;
    }
}
