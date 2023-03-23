package hoandmph27404.fpoly.testbaithinangcaolan2.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.testbaithinangcaolan2.DBHelper.DBhelper;
import hoandmph27404.fpoly.testbaithinangcaolan2.DTO.News;

public class NewsDAO {
    DBhelper dBhelper;
    SQLiteDatabase db;
    Context context;

    public NewsDAO(DBhelper dBhelper, SQLiteDatabase db) {
        this.dBhelper = dBhelper;
        this.db = db;
    }

    public NewsDAO(Context context){
        dBhelper=new DBhelper(context);
        db=dBhelper.getWritableDatabase();
    }

    public long insertNews(News news){
        ContentValues values=new ContentValues();
        values.put("title",news.getTitle());
        values.put("link", news.getLink());
        return db.insert("tintuc", null,values);
    }

    @SuppressLint("Range")
    public List<News> getDaTa(String sql, String...selectionArgs){
        List<News> list=new ArrayList<>();
        Cursor cursor=db.rawQuery(sql,selectionArgs);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            News news=new News();
            news.setMaTT(String.valueOf(cursor.getInt(cursor.getColumnIndex("maTT"))));
            news.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            news.setLink(cursor.getString(cursor.getColumnIndex("link")));

            list.add(news);
            cursor.moveToNext();
        }
        return list;
    }
    public List<News> getAll(){
        String sql="SELECT * FROM tintuc";
        return getDaTa(sql);
    }

    public News getID(String id){
        String sql="SELECT * FROM tintuc WHERE maTT=?";
        List<News> list=getDaTa(sql);
        return list.get(0);
    }
}
