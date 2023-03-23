package hoandmph27404.fpoly.duanmau.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.duanmau.database.DbHelper;
import hoandmph27404.fpoly.duanmau.model.LoaiSach;
import hoandmph27404.fpoly.duanmau.model.PhieuMuon;

public class PhieuMuonDAO {
    private SQLiteDatabase db;
    private Context context;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

    public PhieuMuonDAO(Context context){
        this.context=context;
        DbHelper dbHelper=new DbHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public long insert(PhieuMuon obj){
        ContentValues values=new ContentValues();
        values.put("maTT", obj.getMaTT());
        values.put("maTV", obj.getMaTV());
        values.put("maSach", obj.getMaSach());
        values.put("ngay", sdf.format(obj.getNgay()));
        values.put("tienThue", obj.getTienThue());
        values.put("traSach", obj.getTraSach());

        return db.insert("PhieuMuon",null,values);
    }

    public int update(PhieuMuon obj){
        ContentValues values=new ContentValues();
        values.put("maTT", obj.getMaTT());
        values.put("maTV", obj.getMaTV());
        values.put("maSach", obj.getMaSach());
        values.put("ngay", sdf.format(obj.getNgay()));
        values.put("tienThue", obj.getTienThue());
        values.put("traSach", obj.getTraSach());

        return db.update("PhieuMuon",values,"maPM=?", new String[]{String.valueOf(obj.getMaPM())});
    }

    public int delete(String id){
        return db.delete("PhieuMuon", "maPH=?",new String[]{id});
    }

    //get data nhieu tham so

    @SuppressLint("Range")
    public List<PhieuMuon> getData(String sql, String...selectionArgs){
        List<PhieuMuon> list=new ArrayList<>();
        Cursor c=db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            PhieuMuon obj=new PhieuMuon();
            obj.setMaPM(Integer.parseInt(c.getString(c.getColumnIndex("maPM"))));
            obj.setMaTT(c.getString(c.getColumnIndex("maTT")));
            obj.setMaTV(Integer.parseInt(c.getString(c.getColumnIndex("maTV"))));
            obj.setMaSach(Integer.parseInt(c.getString(c.getColumnIndex("maSach"))));
            obj.setTienThue(Integer.parseInt(c.getString(c.getColumnIndex("tienThue"))));
            try {
                obj.setNgay(sdf.parse(c.getString(c.getColumnIndex("ngay"))));
            }catch (ParseException e){
                e.printStackTrace();
            }
            obj.setTraSach(Integer.parseInt(c.getString(c.getColumnIndex("traSach"))));
            list.add(obj);
        }
        return list;
    }

    // get tat ca data
    public List<PhieuMuon> getAll(){
        String sql="SELECT * FROM PhieuMuon";
        return getData(sql);
    }

    //get tat ca id
    public PhieuMuon getID(String id){
        String sql="SELECT * FROM PhieuMuon WHERE maPH=?";
        List<PhieuMuon> list=getData(sql,id);
        return list.get(0);
    }
}
