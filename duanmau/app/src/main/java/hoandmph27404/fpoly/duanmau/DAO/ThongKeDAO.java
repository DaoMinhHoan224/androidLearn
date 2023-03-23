package hoandmph27404.fpoly.duanmau.DAO;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.duanmau.database.DbHelper;
import hoandmph27404.fpoly.duanmau.model.Sach;
import hoandmph27404.fpoly.duanmau.model.Top;

public class ThongKeDAO {

    private SQLiteDatabase db;
    private Context context;
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public ThongKeDAO(Context context){
        this.context=context;
        DbHelper dbHelper=new DbHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    //thong ke doanh thu
    @SuppressLint("Range")
    public int getDoanhThu(String tuNgay, String denNgay){
        String sqlDoanhThu="SELECT SUM(tienThue) as doanhThu FROM PhieuMuon WHERE ngay BETWEEN ? AND ?";
        List<Integer> list=new ArrayList<>();
        Cursor c=db.rawQuery(sqlDoanhThu,new String[]{tuNgay,denNgay});
        while (c.moveToNext()){
            try {
                list.add(Integer.parseInt(c.getString(c.getColumnIndex("doanhThu"))));
            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }

    //thong ke top 10
    @SuppressLint("Range")
    public List<Top> getTop(){
        String sqlTop="SELECT maSach, count(maSach) as soLuong FROM PhieuMuon GROUP BY maSach" +
                " ORDER BY soLuong DESC LIMIT 10";
        List<Top> list=new ArrayList<Top>();
        SachDAO sachDAO=new SachDAO(context);
        Cursor c=db.rawQuery(sqlTop, null);
        while (c.moveToNext()){
            Top top=new Top();
            Sach sach=sachDAO.getID(c.getString(c.getColumnIndex("maSach")));
            top.setTenSach(sach.getTenSach());
            top.setSoLuong(Integer.parseInt(c.getString(c.getColumnIndex("soLuong"))));
            list.add(top);
        }
        return list;
    }
}
