package com.example.lab3_p2_hoandmph27404.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab3_p2_hoandmph27404.DBHelper.MyDbhelper;
import com.example.lab3_p2_hoandmph27404.Note;

import java.util.ArrayList;

public class GhiChuDAO {
    MyDbhelper myDbhelper;
    SQLiteDatabase db;

    public GhiChuDAO(Context context){
        myDbhelper=new MyDbhelper(context);
        db=myDbhelper.getWritableDatabase();
    }

    public long insert(Note note){
        ContentValues contentValues=new ContentValues();
        contentValues.put(Note.COL_TIEUDE,note.getTieude());
        contentValues.put(Note.COL_NOIDUNG,note.getNoidung());
        contentValues.put(Note.COL_NGAYTHANG,note.getNgaythang());

        long res=db.insert(Note.TB_NAME,null,contentValues);
        return res;
    }

    public int update(Note note){
        ContentValues contentValues=new ContentValues();
        contentValues.put(Note.COL_TIEUDE,note.getTieude());
        contentValues.put(Note.COL_NOIDUNG,note.getNoidung());
        contentValues.put(Note.COL_NGAYTHANG,note.getNgaythang());

        int res=db.update(Note.TB_NAME,contentValues,"id = ?", new String[]{note.getId_note() + ""});
        return res;
    }

    public int delete(Note note){
        return db.delete(Note.TB_NAME,"id = ?",new String[]{note.getId_note() + ""});

    }

    public ArrayList<Note> selectAll(){
        ArrayList<Note> listNote=new ArrayList<>();
        String [] ds_cot= new String[]{"*"};
        Cursor cursor=db.query(Note.TB_NAME,ds_cot,null,null,null,null,null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Note objNote=new Note();
                objNote.setId_note(cursor.getInt(0));
                objNote.setTieude(cursor.getString(1));
                objNote.setNoidung(cursor.getString(2));
                objNote.setNgaythang(cursor.getString(3));
                listNote.add(objNote);
                cursor.moveToNext();

            }
        }
        return listNote;
    }

    public Cursor providerSelectAll(String[] columns, String selection, String[] selectionArgs, String orderBy){
        Cursor c=db.query("tb_ghichu",columns,selection,selectionArgs,null,null,orderBy);
        return c;
    }
}
