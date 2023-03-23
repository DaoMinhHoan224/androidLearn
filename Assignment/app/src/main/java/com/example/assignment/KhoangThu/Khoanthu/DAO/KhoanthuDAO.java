package com.example.assignment.KhoangThu.Khoanthu.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment.KhoangThu.Khoanthu.DTO.KhoanThu;
import com.example.assignment.KhoangThu.Loaithu.DTO.LoaiThu;
import com.example.assignment.SQLite.DBHelper;

import java.util.ArrayList;

public class KhoanthuDAO {
    SQLiteDatabase db;
    DBHelper dbhelper;

    public KhoanthuDAO(Context context){
        dbhelper=new DBHelper(context);
    }

    public KhoanthuDAO(){

    }

    public void open(){
        db=dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public long addKT(KhoanThu khoanthu){
        ContentValues contentvalues=new ContentValues();

       contentvalues.put(KhoanThu.COL_NAME_NAMEKTC,khoanthu.getName_khoanthu());
        contentvalues.put(KhoanThu.COL_NAME_DATE,khoanthu.getNgay());
        contentvalues.put(KhoanThu.COL_NAME_MONEY,khoanthu.getTien());


        long res=db.insert(KhoanThu.TB_NameKTC,null,contentvalues);

        return res;
    }

    public ArrayList<KhoanThu> getAllKT(){
        ArrayList<KhoanThu> khoanThuArrayList=new ArrayList<>();

        String[] danh_sac_cot_lay_du_lieu_khoan_thu=new String[]{
                KhoanThu.COL_NAME_IDKTC,KhoanThu.COL_NAME_NAMEKTC,KhoanThu.COL_NAME_DATE,KhoanThu.COL_NAME_MONEY
        };
        Cursor cursor=db.query(KhoanThu.TB_NameKTC,danh_sac_cot_lay_du_lieu_khoan_thu,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            KhoanThu khoanthu=new KhoanThu();
            khoanthu.setIdKT(cursor.getInt(0));
            khoanthu.setName_khoanthu(cursor.getString(1));
            khoanthu.setNgay(cursor.getString(2));
            khoanthu.setTien(cursor.getString(3));
            khoanThuArrayList.add(khoanthu);
            cursor.moveToNext();
        }
        return khoanThuArrayList;
    }

    public int updateKT(KhoanThu khoanthu){
        ContentValues contentvalues=new ContentValues();

        contentvalues.put(KhoanThu.COL_NAME_NAMEKTC,khoanthu.getName_khoanthu());
        contentvalues.put(KhoanThu.COL_NAME_DATE,khoanthu.getNgay());
        contentvalues.put(KhoanThu.COL_NAME_MONEY,khoanthu.getTien());

        int res=db.update(KhoanThu.TB_NameKTC,contentvalues,"idKTC = " + khoanthu.getIdKT(),null );

        return res;
    }

    public int deleteKT(KhoanThu khoanthu){
        return db.delete(KhoanThu.TB_NameKTC,"idKTC=?",new String[]{khoanthu.getIdKT()+""});
    }

//    public float[] getThongTinThu() {
//        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
//        int thu = 0;
//
//
//        Cursor cursorThu = sqLiteDatabase.rawQuery("select sum(tienKT) from asm_giaodienkhoanthu where idKT ", null);
//
//        if (cursorThu.getCount() != 0) {
//            cursorThu.moveToFirst();
//            thu = cursorThu.getInt(0);
//        }
//
//        float[] ketQua = new float[]{thu};
//        return ketQua;
//    }

    public float[] getThongTinThuChi() {
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        int thu = 0, chi = 0;

        //select sum(tien)
        //from giaodich
        //where maloai in (select maloai from phanloai where thangthai = 'thu')
        Cursor cursorThu = sqLiteDatabase.rawQuery("select sum(tienKT) from asm_giaodienkhoanthu where idKT ", null);

        if (cursorThu.getCount() != 0) {
            cursorThu.moveToFirst();
            thu = cursorThu.getInt(0);
        }

        //select sum(tien)
        //from giaodich
        //where maloai in (select maloai from phanloai where thangthai = 'chi')
        Cursor cursorChi = sqLiteDatabase.rawQuery("select sum(tienKC) from asm_giaodienkhoanchi where idKC  ", null);

        if (cursorChi.getCount() != 0) {
            cursorChi.moveToFirst();
            chi = cursorChi.getInt(0);
        }

        float[] ketQua = new float[]{thu, chi};
        return ketQua;
    }
}
