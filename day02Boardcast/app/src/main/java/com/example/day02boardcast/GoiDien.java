package com.example.day02boardcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GoiDien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goi_dien);

        // hiển thị dữ liệu được gửi từ Broadcast sang
        Intent i2 = getIntent();
        String dt = i2.getStringExtra("dienthoai");

        TextView tv = findViewById(R.id.id_texxt);
        tv.setText("Điện thoại: " + dt);
        Toast.makeText(this, dt, Toast.LENGTH_SHORT).show();
    }
}