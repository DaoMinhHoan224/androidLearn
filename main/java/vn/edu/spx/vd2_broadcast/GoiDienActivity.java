package vn.edu.spx.vd2_broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GoiDienActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goi_dien);

        // hiển thị dữ liệu được gửi từ Broadcast sang
        Intent i2 = getIntent();
        String dt = i2.getStringExtra("dienthoai");

        TextView tv = findViewById(R.id.tv01);
        tv.setText("Điện thoại: " + dt);

    }
}