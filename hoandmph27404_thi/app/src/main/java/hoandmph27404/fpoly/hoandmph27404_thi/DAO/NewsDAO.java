package hoandmph27404.fpoly.hoandmph27404_thi.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.hoandmph27404_thi.DBHelper.DBHelper;
import hoandmph27404.fpoly.hoandmph27404_thi.DTO.News;

public class NewsDAO {
    DBHelper dbHelper;
    SQLiteDatabase db;


    public NewsDAO(Context context){
        dbHelper=new DBHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    public long insertNews(News news){
        ContentValues values=new ContentValues();
        values.put("title",news.getTitle());
        values.put("description",news.getDescription());
        values.put("pubDate",news.getPubDate());
        values.put("link",news.getLink());

        long res=db.insert("thi_news",null,values);
        return  res;
    }

    @SuppressLint("Range")
    public List<News> getDaTa(String sql, String...selectionArgs){
        List<News> newsList=new ArrayList<>();
        Cursor cursor=db.rawQuery(sql,selectionArgs);
        cursor.moveToFirst();
        while (cursor.isAfterLast()==false){
            News news=new News();
            news.setId(cursor.getInt(cursor.getColumnIndex("id")));
            news.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            news.setLink(cursor.getString(cursor.getColumnIndex("link")));

            newsList.add(news);
            cursor.moveToNext();
        }
        return newsList;
    }

    public List<News> getAll(){
        String sql="SELECT * FROM thi_news";
        return getDaTa(sql);
    }

    public News getID(String id){
        String sql="SELECT * FROM thi_news WHERE id=?";
        List<News> list=getDaTa(sql,id);
        return list.get(0);
    }
 }
