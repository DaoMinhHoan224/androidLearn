package hoandmph27404.fpoly.testbaithinangcaolan2.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    static String DB_NAME="news.db";
    static int DB_VERSION=1;

    public DBhelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_news="CREATE TABLE tintuc(maTT INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT NOT NULL, link TEXT NOT NULL)";
        db.execSQL(sql_news);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
