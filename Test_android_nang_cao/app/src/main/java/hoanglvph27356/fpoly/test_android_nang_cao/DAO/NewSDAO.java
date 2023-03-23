package hoanglvph27356.fpoly.test_android_nang_cao.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

import hoanglvph27356.fpoly.test_android_nang_cao.DpHelper.MyDpHelper;
import hoanglvph27356.fpoly.test_android_nang_cao.News;

public class NewSDAO {
    SQLiteDatabase db;
    MyDpHelper myDpHelper;

    public NewSDAO(Context context) {
        myDpHelper = new MyDpHelper(context);
        db = myDpHelper.getWritableDatabase();
    }

    public long insertNews(News news){
        ContentValues contentValues = new ContentValues();
        contentValues.put(News.COL_TITLE,news.getTitle());
        contentValues.put(News.COL_LINK,news.getLink());
        contentValues.put(News.COL_COMMENT,news.getCommemt());
        contentValues.put(News.COL_PUBDATE,news.getPubDate());
        long res = db.insert(News.TB_NAME,null,contentValues);
        return res;
    }
    public ArrayList<News> getAll(){
        ArrayList<News> list = new ArrayList<News>();
        String[] ds_cot = new String[]{"*"};
        Cursor c = db.query(News.TB_NAME,ds_cot,null,null,null,null,null);
        if(c.moveToFirst()){
            while (!c.isAfterLast()){
                News news = new News();
                news.setId_news(c.getInt(0));
                news.setTitle(c.getString(1));
                news.setPubDate(c.getString(2));
                news.setLink(c.getString(3));
                news.setCommemt(c.getString(4));
                list.add(news);
                c.moveToNext();
            }
        }
        return list;
     }
}
