package com.example.nhacchuongdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    Button btn_stop;
    ComponentName sv_play=null;
    String TAG="PlayMusic-zzzzzzz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);

        Intent intentMusic=new Intent(this,MyIntentServiceNhacChuong.class);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Bật nhạc lên click");
                Toast.makeText(MainActivity.this, "Bật nhạc lên click", Toast.LENGTH_SHORT).show();
                if (sv_play==null) //chống click nhiều
                    sv_play=startService(intentMusic);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"Tắt nhạc đê");
                stopService(intentMusic);
                sv_play=null;
           }
        });
    }
}