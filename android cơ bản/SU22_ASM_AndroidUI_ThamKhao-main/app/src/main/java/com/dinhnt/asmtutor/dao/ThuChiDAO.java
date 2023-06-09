package com.dinhnt.asmtutor.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dinhnt.asmtutor.database.KhoanThuChiDB;
import com.dinhnt.asmtutor.model.KhoanThuChi;
import com.dinhnt.asmtutor.model.Loai;

import java.util.ArrayList;

public class ThuChiDAO {
    KhoanThuChiDB khoanThuChiDB;
    public ThuChiDAO(Context context){
        khoanThuChiDB = new KhoanThuChiDB(context);
    }

    //get danh sách LOẠI THU/CHI
    public ArrayList<Loai> getDSLoaiThuChi(String loai){
        ArrayList<Loai> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM loai", null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                String trangthai = cursor.getString(2);
                if(trangthai.equals(loai)){
                    list.add(new Loai(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
                }
            }while (cursor.moveToNext());
        }
        return list;
    }

    //get danh sách LOẠI THU/CHI
    public ArrayList<Loai> getDSLoaiThuChiCach2(String loai){
        ArrayList<Loai> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM loai WHERE trangthai = ?", new String[]{loai});
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                list.add(new Loai(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
            }while (cursor.moveToNext());
        }
        return list;
    }

    //Thêm LOẠI THU/CHI
    public boolean themMoiLoaiThuChi(Loai loai){
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("tenloai", loai.getTenloai());
        contentValues.put("trangthai", loai.getTrangthai());
        long check = sqLiteDatabase.insert("loai", null, contentValues);
        if(check == -1)
            return false;
        return true;
    }

    //Cập nhật LOẠI THU/CHI
    public boolean capNhatLoaiThuChi(Loai loai){
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("maloai", loai.getMaloai());
        contentValues.put("tenloai", loai.getTenloai());
        contentValues.put("trangthai", loai.getTrangthai());
        long check = sqLiteDatabase.update("loai", contentValues, "maloai = ?", new String[]{ String.valueOf(loai.getMaloai()) });
        if(check == -1)
            return false;
        return true;
    }

    public boolean xoaLoaiThuChi(int maloai){
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getWritableDatabase();
        long check  = sqLiteDatabase.delete("loai", "maloai = ?", new String[]{ String.valueOf(maloai) });
        if(check == -1)
            return false;
        return true;
    }

    //Lấy danh sách KHOẢN THU/CHI
    public ArrayList<KhoanThuChi> getDSKhoanThuChi(String loai){
        ArrayList<KhoanThuChi> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getReadableDatabase();

        /*
        * loai (maloai, tenloai, trangthai)
        * khoanthuchi(makhoan, tien, maloai)
        * --> makhoan, tien, maloai, tenloai
        *
        * select k.makhoan, k.tien, k.maloai, l.tenloai
        * from loai l, khoanthuchi k
        * where l.maloai = k.maloai and l.trangthai = "thu/chi"
        * */

        Cursor cursor = sqLiteDatabase.rawQuery("select k.makhoan, k.tien, k.maloai, l.tenloai from loai l, khoanthuchi k where l.maloai = k.maloai and l.trangthai = ?", new String[]{loai});
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                list.add(new KhoanThuChi(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2), cursor.getString(3)));
            }while (cursor.moveToNext());
        }

        return list;
    }

    public boolean themMoiKhoanThuChi(KhoanThuChi khoanThuChi){
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("tien", khoanThuChi.getTien());
        contentValues.put("maloai", khoanThuChi.getMaloai());
        long check  = sqLiteDatabase.insert("khoanthuchi", null, contentValues);
        if(check == -1)
            return false;
        return true;
    }

    public boolean capNhatKhoanThuChi(KhoanThuChi khoanThuChi){
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("makhoan", khoanThuChi.getMakhoan());
        contentValues.put("tien", khoanThuChi.getTien());
        contentValues.put("maloai", khoanThuChi.getMaloai());
        long check = sqLiteDatabase.update("khoanthuchi", contentValues, "makhoan = ?", new String[]{String.valueOf(khoanThuChi.getMakhoan())});
        if(check == -1)
            return false;
        return true;
    }

    public boolean xoaKhoanThuChi(int makhoan){
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getWritableDatabase();
        long check = sqLiteDatabase.delete("khoanthuchi", "makhoan = ?", new String[]{ String.valueOf(makhoan) });
        if(check == -1)
            return false;
        return true;
    }

    public float[] getThongTinThuChi() {
        SQLiteDatabase sqLiteDatabase = khoanThuChiDB.getReadableDatabase();
        int thu = 0, chi = 0;

        //select sum(tien)
        //from giaodich
        //where maloai in (select maloai from phanloai where thangthai = 'thu')
        Cursor cursorThu = sqLiteDatabase.rawQuery("select sum(tien) from KHOANTHUCHI where maloai in (select maloai from loai where trangthai = 'thu') ", null);

        if (cursorThu.getCount() != 0) {
            cursorThu.moveToFirst();
            thu = cursorThu.getInt(0);
        }

        //select sum(tien)
        //from giaodich
        //where maloai in (select maloai from phanloai where thangthai = 'chi')
        Cursor cursorChi = sqLiteDatabase.rawQuery("select sum(tien) from KHOANTHUCHI where maloai in (select maloai from loai where trangthai = 'chi') ", null);

        if (cursorChi.getCount() != 0) {
            cursorChi.moveToFirst();
            chi = cursorChi.getInt(0);
        }

        float[] ketQua = new float[]{thu, chi};
        return ketQua;
    }

}
