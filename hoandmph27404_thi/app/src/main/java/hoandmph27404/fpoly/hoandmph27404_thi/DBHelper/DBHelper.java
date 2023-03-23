package hoandmph27404.fpoly.hoandmph27404_thi.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static String DB_NAME="thi.db";
    static int DB_VERSION=1;
    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_news_thi="CREATE TABLE thi_news (id INTEGER NOT NULL,title TEXT NOT NULL,description TEXT NOT NULL,pubDate TEXT NOT NULL,link TEXT NOT NULL,PRIMARY KEY(id AUTOINCREMENT))";
        db.execSQL(sql_news_thi);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
