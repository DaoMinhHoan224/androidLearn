package com.example.providerclient;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri uri0001 = Uri.parse("content://com.example.lap3_2_hoanglvph27345.Provider/tb_mynote");
        Cursor cursor = getContentResolver().query(uri0001,null, null, null, null);
        ArrayList<String> listNote = new ArrayList<String>();
        ArrayList<String> listId = new ArrayList<String>();
        ListView lv = findViewById(R.id.lv_note);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String objNote = "";
            String ID = "";
            String id_note = cursor.getInt(0) + "";
            objNote = id_note + " - ";
            int id_note_check = cursor.getInt(0);
            ID = id_note_check+"";
            String title = cursor.getString(1);
            objNote += title;
            cursor.moveToNext();
            listNote.add(objNote);
            listId.add(ID);



        }
        cursor.close();


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listview_item,R.id.tv_id,listNote);

        lv.setAdapter(arrayAdapter);
     
    }
}