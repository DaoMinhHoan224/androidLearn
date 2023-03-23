package com.example.vidu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_open=findViewById(R.id.btn_open);
        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo intent để khởi động activity
                Intent i=new Intent(getBaseContext(),Maytinhactivity.class);

                //tạo dữ liệu để gửi
                String hoTen="Nguyen Van A";//Có thể lấy họ tên từ editext hoặc từ hàm khác...
                int tuoi=50;

                //Tạo đối tượng Bundle để đóng gói
                Bundle bundle=new Bundle();
                bundle.putString("Chuoi_ho_ten",hoTen);
                bundle.putInt("So tuoi",tuoi);

                //Gắn bundle vào intend(giống như giao gói hàng cho shipper)
                i.putExtra("Goi_hang_thong_tin",bundle);

          startActivity(i);//gọi activity ra hoạt động
            }
        });
    }
}