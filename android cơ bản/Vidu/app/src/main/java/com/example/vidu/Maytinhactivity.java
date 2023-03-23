package com.example.vidu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Maytinhactivity extends AppCompatActivity {
    EditText ed_soa,ed_sob;
    TextView tvkq;
    Button btn_tong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maytinhactivity);

        //Lấy dữ liệu trong intend
        Intent objIntend=getIntent();
        Bundle objBundle=objIntend.getBundleExtra("Goi_hang_thong_tin");

        String hoTen=objBundle.getString("Chuoi_ho_ten");
        int tuoi=objBundle.getInt("So tuoi");

        //Gán vào textview
        TextView tv_thongtin=findViewById(R.id.tv_thongtin);
        tv_thongtin.setText("Họ và tên: "+ hoTen + "\ntuoi"+ tuoi );














        //ánh xạ view vào biến
        ed_soa = findViewById(R.id.ed_soa);
        ed_sob = findViewById(R.id.ed_sob);
        btn_tong = findViewById(R.id.btn_tong);
        tvkq = findViewById(R.id.tv_ketqua);
        //Viết sự kiện bấm nút
        btn_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy dữ liệu vào biến
                double so_a = Double.parseDouble(ed_soa.getText().toString());
                double so_b = Double.parseDouble(ed_sob.getText().toString());

                double tong = so_a + so_b;
                String tong1=String.valueOf(tong);
                //thông báo kết quả
                Toast.makeText(Maytinhactivity.this, "Tổng " + tong, Toast.LENGTH_SHORT).show();
                tvkq.setText(tong1);

            }
        });
    }
}