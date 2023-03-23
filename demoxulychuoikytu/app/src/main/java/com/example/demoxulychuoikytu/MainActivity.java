package com.example.demoxulychuoikytu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DemoBoundServiceTinhTong tinhTong; //đặt ở phạm vi class
    Button btntong;

    //tạo biến sv_con để thực hiện kết nới với service
    ServiceConnection sv_con=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder ibinder) {
            DemoBoundServiceTinhTong.LocalBinder localBinder=(DemoBoundServiceTinhTong.LocalBinder) ibinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //làm việc với binder
        tinhTong = new DemoBoundServiceTinhTong();


        Intent intentTinhTong=new Intent(MainActivity.this,DemoBoundServiceTinhTong.class);
        bindService(intentTinhTong,sv_con, Context.BIND_AUTO_CREATE);
        btntong=findViewById(R.id.btntong);
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tong=tinhTong.Tong(2,8);
                Toast.makeText(MainActivity.this, "Tổng= " + tong, Toast.LENGTH_SHORT).show();
            }
        });
    }
}