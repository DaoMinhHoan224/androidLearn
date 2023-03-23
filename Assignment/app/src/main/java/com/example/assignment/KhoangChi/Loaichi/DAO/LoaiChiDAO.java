package com.example.assignment.KhoangChi.Loaichi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.KhoangChi.Loaichi.DTO.LoaiChi;
import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.SQLite.DBHelper;

import java.util.ArrayList;

public class LoaiChiDAO {
    SQLiteDatabase db;
    DBHelper dbhelper;

    public LoaiChiDAO(Context context){
        dbhelper=new DBHelper(context);
    }

    public LoaiChiDAO(){

    }

    public void open(){
        db=dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public long addLC(LoaiChi loaichi){
        ContentValues contentvalues=new ContentValues();


        contentvalues.put(LoaiChi.COL_NAME_NAMELC,loaichi.getName_loaichi());

        long res=db.insert(LoaiChi.TB_NAMELC,null,contentvalues);

        return res;
    }

    public ArrayList<LoaiChi> getAllLC(){
        ArrayList<LoaiChi> loaiChiArrayList=new ArrayList<>();

        String[] danh_sac_cot_lay_du_lieu_loai_chi=new String[]{
                LoaiChi.COL_NAME_IDLC,LoaiChi.COL_NAME_NAMELC
        };
        Cursor cursor=db.query(LoaiChi.TB_NAMELC,danh_sac_cot_lay_du_lieu_loai_chi,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            LoaiChi loaichi=new LoaiChi();
            loaichi.setIdLC(cursor.getInt(0));
            loaichi.setName_loaichi(cursor.getString(1));
            loaiChiArrayList.add(loaichi);
            cursor.moveToNext();
        }
        return loaiChiArrayList;
    }

    public int updateLT(LoaiChi loaichi){
        ContentValues contentvalues=new ContentValues();

        contentvalues.put(LoaiChi.COL_NAME_NAMELC,loaichi.getName_loaichi());

        int res=db.update(LoaiChi.TB_NAMELC,contentvalues,"LTid = " + loaichi.getIdLC(),null );

        return res;
    }

    public int deleteLT(LoaiChi loaichi){
        return db.delete(LoaiChi.TB_NAMELC,"LTid=? ",new String[]{loaichi.getIdLC()+""});
    }
}
