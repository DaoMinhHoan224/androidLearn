package com.example.assignment_hoandmph27404.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assignment_hoandmph27404.DTO.TBclass;
import com.example.assignment_hoandmph27404.SQLite.dbhelper;

import java.util.ArrayList;

public class LOPDao {
    SQLiteDatabase db;
    dbhelper dbHelper;

    public LOPDao(Context context)  {
        dbHelper=new dbhelper(context);
    }

    public LOPDao() {

    }

    public void open(){
        db=dbHelper.getWritableDatabase();
    }
    public void close(){
        dbHelper.close();
    }

    public long addClass(TBclass tbclass){
        ContentValues contentvalues=new ContentValues();

        contentvalues.put(TBclass.COL_NAME_ID_CLASS,tbclass.getId_class());
        contentvalues.put(TBclass.COL_NAME_TEN_LOP,tbclass.getTenlop());

        long res=db.insert(TBclass.TB_NameClass,null,contentvalues);
        return res;
    }

    public ArrayList<TBclass> GetAll(){
        ArrayList<TBclass> tBclassArrayList=new ArrayList<TBclass>();

        String[] danh_sach_cot_lay_du_lieu_class=new String[]{
                TBclass.COL_NAME_ID,TBclass.COL_NAME_ID_CLASS,TBclass.COL_NAME_TEN_LOP

        };
        Cursor cursor=db.query(TBclass.TB_NameClass,danh_sach_cot_lay_du_lieu_class,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){

            TBclass tbclass=new TBclass();
            tbclass.setId_cl(cursor.getInt(0));
            tbclass.setId_class(cursor.getString(1));
            tbclass.setTenlop(cursor.getString(2));
            tBclassArrayList.add(tbclass);
            cursor.moveToNext();
        }
        return tBclassArrayList;
    }

    public int deleteClass(TBclass tbclass){
        return db.delete(TBclass.TB_NameClass,"id_cl = ? ", new String[] {tbclass.getId_cl() +"" });
    }
}