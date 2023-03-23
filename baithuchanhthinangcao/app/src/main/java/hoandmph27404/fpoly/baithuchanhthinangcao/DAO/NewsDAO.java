package hoandmph27404.fpoly.baithuchanhthinangcao.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.baithuchanhthinangcao.DBHelper.DBHelper;
import hoandmph27404.fpoly.baithuchanhthinangcao.DTO.News;

public class NewsDAO {
    DBHelper dbHelper;
   SQLiteDatabase db;

    public NewsDAO(DBHelper dbHelper, SQLiteDatabase db) {
        this.dbHelper = dbHelper;
        this.db = db;
    }

    public NewsDAO(Context context){
        dbHelper=new DBHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public long insertNews(News news){
        ContentValues contentValues=new ContentValues();
        contentValues.put("title",news.getTitle());
        contentValues.put("link", news.getLink());
        return db.insert("tintuc",null,contentValues);
    }

     @SuppressLint("Range")
     public List<News> getDaTa(String sql, String...selectionArgs){
        List<News> newsList=new ArrayList<>();
        Cursor cursor=db.rawQuery(sql,selectionArgs);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            News news=new News();
            news.setMaTT(String.valueOf(cursor.getInt(cursor.getColumnIndex("maTT"))));
            news.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            news.setLink(cursor.getString(cursor.getColumnIndex("link")));

            newsList.add(news);
            cursor.moveToNext();
        }
        return newsList;
     }

     public List<News> getAll(){
        String sql="SELECT * FROM tintuc";
        return getDaTa(sql);
     }

     public News getID(String id){
        String sql="SELECT * FROM tintuc WHERE maTT=?";
        List<News> list=getDaTa(sql,id);
        return list.get(0);
     }
}
