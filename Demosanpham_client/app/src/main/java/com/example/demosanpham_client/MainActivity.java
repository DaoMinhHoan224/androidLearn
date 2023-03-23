package com.example.demosanpham_client;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri0001=Uri.parse("content://com.example.demosanpham_src.Provider/tb_sanpham");

        Cursor cursor=getContentResolver().query(uri0001,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Log.d("zzzzz","dong du lieu ID = " + cursor.getInt(0) + ", name = " + cursor.getInt(1));
            cursor.moveToNext();
        }
    }
}