package com.example.assignment_hoandmph27404.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignment_hoandmph27404.DTO.TBclass;
import com.example.assignment_hoandmph27404.DTO.TBsv;
import com.example.assignment_hoandmph27404.SQLite.dbhelper;

import java.util.ArrayList;

public class SVDao {
    SQLiteDatabase db;
    dbhelper dbHelper;

    public SVDao(Context context){
        dbHelper=new dbhelper(context);
    }


    public void opensv(){
        db=dbHelper.getWritableDatabase();
    }
    public void closesv(){
        dbHelper.close();
    }

    public long addSV(TBsv tbsv){
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(TBsv.COL_NAME_LOP,tbsv.getLop());
        contentvalues.put(TBsv.COL_NAME_Tensv,tbsv.getTensv());
        contentvalues.put(TBsv.COL_NAME_NGAY_SINH,tbsv.getNgaysinh());
        contentvalues.put(TBsv.COL_NAME_SDT,tbsv.getSdt());
        contentvalues.put(TBsv.COL_NAME_ID_SV,tbsv.getId_cl());

        long res=db.insert(TBsv.TB_NameSV,null,contentvalues);
        return res;
    }

    public ArrayList<TBsv> GetAll(){
        ArrayList<TBsv> tBsvArrayList=new ArrayList<TBsv>();

        String[] danh_sach_cot_lay_du_lieu_sv=new String[]{TBsv.COL_NAME_STT,TBsv.COL_NAME_LOP,TBsv.COL_NAME_Tensv,TBsv.COL_NAME_NGAY_SINH,TBsv.COL_NAME_SDT,TBsv.COL_NAME_ID_SV};
        Cursor c=db.query(TBsv.TB_NameSV,danh_sach_cot_lay_du_lieu_sv,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            int stt=c.getInt(0);
            String lop=c.getString(1);
            String ten_sv=c.getString(2);
            String ngay_sinh=c.getString(3);
            String sdt=c.getString(4);
            int id_cl=c.getInt(5);

            TBsv tbsv=new TBsv();
            tbsv.setStt(stt);
            tbsv.setLop(lop);
            tbsv.setTensv(ten_sv);
            tbsv.setNgaysinh(ngay_sinh);
            tbsv.setSdt(sdt);
            tbsv.setId_cl(id_cl);
            tBsvArrayList.add(tbsv);
            c.moveToNext();
        }
        return tBsvArrayList;
    }

    public int updateSV(TBsv tbsv){
        ContentValues contentvalues=new ContentValues();
        contentvalues.put(TBsv.COL_NAME_LOP,tbsv.getLop());
        contentvalues.put(TBsv.COL_NAME_Tensv,tbsv.getTensv());
        contentvalues.put(TBsv.COL_NAME_NGAY_SINH,tbsv.getNgaysinh());
        contentvalues.put(TBsv.COL_NAME_SDT,tbsv.getSdt());
        contentvalues.put(TBsv.COL_NAME_ID_SV,tbsv.getId_cl());

        int res=db.update(TBsv.TB_NameSV,contentvalues,"Stt= ?", new String[] {tbsv.getStt()+""});
        return res;
    }

    public int deleteSV(TBsv tbsv){
        return db.delete(TBsv.TB_NameSV,"Stt=? ", new String[] {tbsv.getStt() +"" });
    }

}
