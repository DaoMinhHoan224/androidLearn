package hoanglvph27356.fpoly.test_android_nang_cao.DpHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDpHelper  extends SQLiteOpenHelper {
    static  String DB_NAME = "test.db";
    static  int DB_VERSION =  1;


    public MyDpHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tb_news (id_news INTEGER NOT NULL,title TEXT NOT NULL UNIQUE,pubDate TEXT NOT NULL,link TEXT NOT NULL,commemt TEXT,PRIMARY KEY(id_news AUTOINCREMENT))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
