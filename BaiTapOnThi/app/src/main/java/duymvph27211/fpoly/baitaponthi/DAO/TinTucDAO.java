package duymvph27211.fpoly.baitaponthi.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import duymvph27211.fpoly.baitaponthi.DBHelper.MyDbHelper;
import duymvph27211.fpoly.baitaponthi.DTO.TinTuc;

public class TinTucDAO {
    MyDbHelper myDbHelper;
    SQLiteDatabase db;
    public TinTucDAO(Context context){
        myDbHelper = new MyDbHelper(context);
        db = myDbHelper.getWritableDatabase();
    }
    public long insertTinTuc(TinTuc obj){
        ContentValues values = new ContentValues();
        values.put("title",obj.getTitle());
        values.put("link",obj.getLink());
        return db.insert("tintuc",null,values);
    }
    @SuppressLint("Range")
    private List<TinTuc> getData(String sql, String...selectionArgs){
        List<TinTuc> list =new ArrayList<TinTuc>();
        Cursor c = db.rawQuery(sql,selectionArgs);
        c.moveToFirst();
        while (c.isAfterLast()==false){
            TinTuc obj = new TinTuc();
            obj.setMaTT(String.valueOf(c.getInt(c.getColumnIndex("maTT"))));
            obj.setTitle(c.getString(c.getColumnIndex("title")));
            obj.setLink(c.getString(c.getColumnIndex("link")));

            list.add(obj);
            c.moveToNext();
        }
        return list;
    }
    public List<TinTuc> getAll(){
        String sql = "SELECT * FROM tintuc";
        return getData(sql);
    }
    public TinTuc getId(String id){
        String sql = "SELECT + FROM tintuc WHERE maTT=?";
        List<TinTuc> list = getData(sql,id);
        return list.get(0);
    }

}
