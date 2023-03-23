package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivitybai2 extends AppCompatActivity {
    EditText ed_vb;
    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitybai2);

        ed_vb=findViewById(R.id.ed_send);
        btn_send=findViewById(R.id.btn_ntubai2);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivitybai2.this,BroadCastbai2.class);
                intent.putExtra("NAME_BAI2", ed_vb.getText().toString());
                sendBroadcast(intent);
            }
        });
    }
}