package com.example.assignment.KhoangChi.Khoanchi.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.KhoangChi.Khoanchi.DTO.KhoanChi;
import com.example.assignment.KhoangThu.Khoanthu.DTO.KhoanThu;
import com.example.assignment.SQLite.DBHelper;

import java.util.ArrayList;

public class KhoanchiDAO {
    SQLiteDatabase db;
    DBHelper dbHelper;

    public KhoanchiDAO(Context context){
        dbHelper=new DBHelper(context);
    }

    public void open(){
        db=dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public long addKT(KhoanChi khoanchi){
        ContentValues contentvalues=new ContentValues();

        contentvalues.put(KhoanChi.COL_NAME_NAMEKC,khoanchi.getName_khoanchi());
        contentvalues.put(KhoanChi.COL_NAME_DATEKC,khoanchi.getNgayKC());
        contentvalues.put(KhoanChi.COL_NAME_MONEYKC,khoanchi.getTienKC());


        long res=db.insert(KhoanChi.TB_NameKC,null,contentvalues);

        return res;
    }

    public ArrayList<KhoanChi> getAllKC(){ArrayList<KhoanChi> khoanChiArrayList=new ArrayList<>();

        String[] danh_sac_cot_lay_du_lieu_khoan_chi=new String[]{
                KhoanChi.COL_NAME_IDKC,KhoanChi.COL_NAME_NAMEKC,KhoanChi.COL_NAME_DATEKC,KhoanChi.COL_NAME_MONEYKC
        };
        Cursor cursor=db.query(KhoanChi.TB_NameKC,danh_sac_cot_lay_du_lieu_khoan_chi,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            KhoanChi khoanChi=new KhoanChi();
            khoanChi.setIdKC(cursor.getInt(0));
            khoanChi.setName_khoanchi(cursor.getString(1));
            khoanChi.setNgayKC(cursor.getString(2));
            khoanChi.setTienKC(cursor.getString(3));
            khoanChiArrayList.add(khoanChi);
            cursor.moveToNext();
        }
        return khoanChiArrayList;
    }

    public int updateKT(KhoanChi khoanchi){
        ContentValues contentvalues=new ContentValues();

        contentvalues.put(KhoanChi.COL_NAME_NAMEKC,khoanchi.getName_khoanchi());
        contentvalues.put(KhoanChi.COL_NAME_DATEKC,khoanchi.getNgayKC());
        contentvalues.put(KhoanChi.COL_NAME_MONEYKC,khoanchi.getTienKC());

        int res=db.update(KhoanChi.TB_NameKC,contentvalues,"idKTC = " + khoanchi.getIdKC(),null );

        return res;
    }

    public int deleteKT(KhoanChi khoanchi){
        return db.delete(KhoanChi.TB_NameKC,"idKTC=?",new String[]{khoanchi.getIdKC()+""});
    }

    public float[] getThongTinChi() {
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        int chi = 0;

        Cursor cursorChi = sqLiteDatabase.rawQuery("select sum(tienKC) from asm_giaodienkhoanchi where idKC ", null);

        if (cursorChi.getCount() != 0) {
            cursorChi.moveToFirst();
            chi = cursorChi.getInt(0);
        }

        float[] ketQua = new float[]{chi};
        return ketQua;
    }
}
