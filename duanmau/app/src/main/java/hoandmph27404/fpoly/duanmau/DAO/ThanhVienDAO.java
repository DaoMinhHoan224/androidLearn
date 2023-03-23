package hoandmph27404.fpoly.duanmau.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.duanmau.database.DbHelper;
import hoandmph27404.fpoly.duanmau.model.ThanhVien;

public class ThanhVienDAO {
    private SQLiteDatabase db;

    public ThanhVienDAO(Context context){
        DbHelper dbHelper=new DbHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public long insert(ThanhVien obj){
        ContentValues values=new ContentValues();
        values.put("hoTen", obj.getHoTen());
        values.put("gioiTinh",obj.getGioiTinh());
        values.put("namSinh", obj.getNamSinh());

        return db.insert("ThanhVien", null,values);
    }

    public int update(ThanhVien obj){
        ContentValues values=new ContentValues();
        values.put("hoTen",obj.getHoTen());
        values.put("gioiTinh",obj.getGioiTinh());
        values.put("namSinh", obj.getNamSinh());

        return db.update("ThanhVien", values,"maTV=?", new String[]{String.valueOf(obj.getMaTV())});

    }
    public int delete(String id){
        return db.delete("ThanhVien", "maTV=?",new String[]{id});
    }

    //get tat ca data
    public List<ThanhVien> getAll(){
        String sql="SELECT * FROM ThanhVien";
        return getData(sql);
    }

    //get data theo id
    public ThanhVien getID(String id){
        String sql="SELECT * FROM ThanhVien WHERE maTV=?";
        List<ThanhVien> list =getData(sql,id);
        return list.get(0);
    }

    //get data nhieu tham so
    @SuppressLint("Range")
    public List<ThanhVien> getData(String sql, String...selectionArgs){

        List<ThanhVien> list=new ArrayList<>();
        Cursor c=db.rawQuery(sql, selectionArgs);
        while (c.moveToNext()){
            ThanhVien obj=new ThanhVien();
            obj.setMaTV(Integer.parseInt(c.getString(c.getColumnIndex("maTV"))));
            obj.setHoTen(c.getString(c.getColumnIndex("hoTen")));
            obj.setGioiTinh(c.getString(c.getColumnIndex("gioiTinh")));
            obj.setNamSinh(c.getString(c.getColumnIndex("namSinh")));
            list.add(obj);
        }
        return list;
    }

}
