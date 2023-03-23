package duymvph27211.fpoly.baitaponthi.DBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDbHelper extends SQLiteOpenHelper {
    static String DB_NAME = "TINTUC.DB";
    static int VERSION = 1;
    public MyDbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbl = "CREATE TABLE tintuc(maTT INTEGER PRIMARY KEY AUTOINCREMENT,title TEXT NOT NULL, link TEXT NOT NULL)";
        db.execSQL(tbl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
