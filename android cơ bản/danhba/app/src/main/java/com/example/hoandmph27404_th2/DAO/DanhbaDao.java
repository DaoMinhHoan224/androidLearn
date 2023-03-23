package com.example.hoandmph27404_th2.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hoandmph27404_th2.DTO.danhba;
import com.example.hoandmph27404_th2.SQLite.createquanlydanhba;

import java.util.ArrayList;

public class DanhbaDao {
    SQLiteDatabase db;
    createquanlydanhba createquanlydanhba;

    public DanhbaDao(Context context) {
        createquanlydanhba = new createquanlydanhba(context);
    }

    public void open() {
        db = createquanlydanhba.getWritableDatabase();
    }

    public void close() {
        createquanlydanhba.close();
    }

    public long addNew(danhba danhbaa) {
        ContentValues contentvalue = new ContentValues();
        contentvalue.put(danhba.COL_NAME_HO_TEN, danhbaa.getHoten());
        contentvalue.put(danhba.COL_NAME_SDT, danhbaa.getSdt());
        contentvalue.put(danhba.COL_NAME_GHI_CHU, danhbaa.getGhichu());

        long res = db.insert(danhba.TB_NAME, null, contentvalue);
        return res;
    }

    public ArrayList<danhba> GetAll() {
        ArrayList<danhba> danhbA = new ArrayList<danhba>();

        String[] danh_sach_cot_lay_du_lieu = new String[]{
                danhba.COL_NAME_ID, danhba.COL_NAME_HO_TEN, danhba.COL_NAME_SDT, danhba.COL_NAME_GHI_CHU
        };

        Cursor c = db.query(danhba.TB_NAME, danh_sach_cot_lay_du_lieu, null, null, null, null, null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            //lấy thông tin từng cột cho vào biến
            int id = c.getInt(0);
            String hoten = c.getString(1);
            String sdt = c.getString(2);
            String ghichu = c.getString(3);
            //tạo đối tượng thông tin lớp để gán thông tin vào
            danhba danhbaa = new danhba();
            danhbaa.setId(id);
            danhbaa.setHoten(hoten);
            danhbaa.setSdt(sdt);
            danhbaa.setGhichu(ghichu);
            //thêm vào danh sách
            danhbA.add(danhbaa);
            //sau khi thêm vào danh sách thì chuyển con trỏ đọc xuống dòng tiếp theo
            c.moveToNext();
        }
        return danhbA;
    }
    public int update(danhba danhbaa){
        ContentValues contentvalue=new ContentValues();
        contentvalue.put(danhba.COL_NAME_HO_TEN, danhbaa.getHoten());
        contentvalue.put(danhba.COL_NAME_SDT, danhbaa.getSdt());
        contentvalue.put(danhba.COL_NAME_GHI_CHU, danhbaa.getGhichu());

        int res=db.update(danhba.TB_NAME,contentvalue,"id= " + danhbaa.getId(),null);
        return res;
    }

    public int delete(danhba danhbaa){
        return db.delete(danhba.TB_NAME,"id= "+ danhbaa.getId(),null);
    }
}

