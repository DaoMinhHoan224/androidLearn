package com.example.assignment.KhoangThu.Loaithu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.SQLite.DBHelper;

import java.util.ArrayList;

public class LoaithuDAO {
    SQLiteDatabase db;
    DBHelper dbhelper;

    public LoaithuDAO(Context context){
        dbhelper=new DBHelper(context);
    }

    public LoaithuDAO(){

    }

    public void open(){
        db=dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public long addLT(LoaiThu loaithu){
        ContentValues contentvalues=new ContentValues();


        contentvalues.put(LoaiThu.COL_NAME_TEN_LOAI_THU,loaithu.getName_Loaithu());

        long res=db.insert(LoaiThu.TB_Namegiaodien,null,contentvalues);

        return res;
    }

    public ArrayList<LoaiThu> getAll(){
        ArrayList<LoaiThu> loaiThuArrayList=new ArrayList<>();

        String[] danh_sac_cot_lay_du_lieu_loai_thu=new String[]{
                LoaiThu.COL_NAME_ID,LoaiThu.COL_NAME_TEN_LOAI_THU
        };
        Cursor cursor=db.query(LoaiThu.TB_Namegiaodien,danh_sac_cot_lay_du_lieu_loai_thu,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiThu loaithu=new LoaiThu();
            loaithu.setLTid(cursor.getInt(0));
            loaithu.setName_Loaithu(cursor.getString(1));
            loaiThuArrayList.add(loaithu);
            cursor.moveToNext();
        }
        return loaiThuArrayList;
    }

    public int updateLT(LoaiThu loaithu){
        ContentValues contentvalues=new ContentValues();

        contentvalues.put(LoaiThu.COL_NAME_TEN_LOAI_THU,loaithu.getName_Loaithu());

        int res=db.update(LoaiThu.TB_Namegiaodien,contentvalues,"LTid = " + loaithu.getLTid(),null );

        return res;
    }

    public int deleteLT(LoaiThu loaithu){
        return db.delete(LoaiThu.TB_Namegiaodien,"LTid=?",new String[]{loaithu.getLTid()+""});
    }
}
