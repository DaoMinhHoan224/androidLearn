package com.example.lab1bai12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_start;
    Button btn_stop;
    Button btn_bai3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start=findViewById(R.id.btn_start);
        btn_stop=findViewById(R.id.btn_stop);
        btn_bai3=findViewById(R.id.btn_bai3);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ClassLabService.class);

                Bundle b=new Bundle();
                b.putInt("StuID",1);
                b.putString("StuName","John");
                b.putString("Class","PT9101");

                intent.putExtra("student",b);
                startService(intent);
            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ClassLabService.class);
                stopService(intent);
            }
        });

        btn_bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(MainActivity.this,MainActivitybai3.class);
                startActivity(intent3);
            }
        });
    }
}