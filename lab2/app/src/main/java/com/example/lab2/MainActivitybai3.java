package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivitybai3 extends AppCompatActivity {
    EditText ed_check;
    Button btn_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitybai3);

        ed_check=findViewById(R.id.ed_check);
        btn_check=findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivitybai3.this,Broadcastbai3.class);
                intent.putExtra("CHECK_VOUCHER",ed_check.getText().toString());
                sendBroadcast(intent);
           }
        });
    }
}