package com.example.lap3_2_hoanglvph27345.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.example.lap3_2_hoanglvph27345.DPHelper.MyDpHelper;
import com.example.lap3_2_hoanglvph27345.Note;

import java.util.ArrayList;

public class NoteDAO {
    MyDpHelper myDpHelper;
    SQLiteDatabase db;

    public NoteDAO(Context context){
        myDpHelper = new MyDpHelper(context);
        db =myDpHelper.getWritableDatabase( );
    }
    public long insertNew(Note note){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Note.COL_TITLE,note.getTitle());
        contentValues.put(Note.COL_NOIDUNG,note.getNoidung());
        contentValues.put(Note.COL_NGAYTHANg,note.getNgaythang());
        long res = db.insert(Note.TB_NAME,null,contentValues);
        return  res;
    }
    public int updateRow(Note note){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Note.COL_TITLE,note.getTitle());
        contentValues.put(Note.COL_NOIDUNG,note.getNoidung());
        contentValues.put(Note.COL_NGAYTHANg,note.getNgaythang());
        int res = db.update(Note.TB_NAME,contentValues,"id_note = ?",new String[]{note.getId_note() + ""});
        return res;
    }
    public int deleteRow(Note note){
        int res = db.delete(Note.TB_NAME,"id_note = ?",new String[]{note.getId_note() + ""});
        return res;
    }
    public ArrayList<Note> selectAll(){
        ArrayList<Note> listNote =new ArrayList<Note>();
        String [] ds_cot = new String[]{ "*" };
        Cursor cursor = db.query(Note.TB_NAME,ds_cot,null,null,null,null,null);
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Note objNote = new Note();
                objNote.setId_note(cursor.getInt(0));
                objNote.setTitle(cursor.getString(1));
                objNote.setNoidung(cursor.getString(2));
                objNote.setNgaythang(cursor.getString(3));
                listNote.add(objNote);
                cursor.moveToNext();
            }
        }
        return listNote;
    }
    public Cursor providerSelectAll(String[] columns,String selection,String[] selectionArgs,String orderBy){
        return  db.query(Note.TB_NAME,columns,selection,selectionArgs,null,null,orderBy);
    }



}
