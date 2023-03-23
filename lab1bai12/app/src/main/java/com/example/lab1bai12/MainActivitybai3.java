package com.example.lab1bai12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivitybai3 extends AppCompatActivity {
    MyServicebai3 servicebai3;
    EditText ed_chuoi,ed_chu;
    Button btn_tim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitybai3);

        ed_chuoi=findViewById(R.id.ed_chuoi);
        ed_chu=findViewById(R.id.ed_chu);
        btn_tim=findViewById(R.id.btn_tim);
        servicebai3=new MyServicebai3();
        Intent intentdemkytu=new Intent(MainActivitybai3.this,MyServicebai3.class);
        bindService(intentdemkytu,sv_conn, Context.BIND_AUTO_CREATE);
        btn_tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a=ed_chuoi.getText().toString();
                char b=0;
                if (a.trim().length() == 0 && b+"".trim().length()==0){
                    Toast.makeText(MainActivitybai3.this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    b=ed_chu.getText().charAt(0);
                }catch(Exception s){
                    s.printStackTrace();
                    Toast.makeText(MainActivitybai3.this, "Bạn chưa nhập ký tự cần tìm", Toast.LENGTH_SHORT).show();
                }
                String tong=servicebai3.Demkitu(a,b);
                Toast.makeText(MainActivitybai3.this, "Số lượng ký tự " + b + " là " + tong, Toast.LENGTH_SHORT).show();
            }
        });
    }

    ServiceConnection sv_conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyServicebai3.LocalBiner localBiner=(MyServicebai3.LocalBiner) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}