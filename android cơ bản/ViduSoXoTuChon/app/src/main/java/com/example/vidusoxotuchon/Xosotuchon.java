package com.example.vidusoxotuchon;
//hoandmph27404_viduxosotuchon
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Random;

public class Xosotuchon extends AppCompatActivity {
     EditText ed_number;
     TextView tv_mauxanh,tv_maudo,tv_ketvanqua,tv_thongbao;
     Button btn_quay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xosotuchon);

        ed_number=findViewById(R.id.ed_number);
        tv_mauxanh=findViewById(R.id.tv_mauxanh);
        tv_maudo=findViewById(R.id.tv_maudo);
        tv_ketvanqua=findViewById(R.id.tv_ketvanqua);
        tv_thongbao=findViewById(R.id.tv_thongbao);
        tv_mauxanh.setVisibility(View.GONE);
        tv_maudo.setVisibility(View.GONE);
        btn_quay=findViewById(R.id.btn_quay);



        btn_quay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number=Double.parseDouble(ed_number.getText().toString());
                Random r=new Random();
                int so=r.nextInt(99);

                tv_thongbao.setVisibility(View.GONE);
                if(so == number){
                    tv_ketvanqua.setText("So quay duoc: " + so);
                    tv_mauxanh.setVisibility(View.VISIBLE);
                    tv_maudo.setVisibility(View.GONE);
                 }else{
                    tv_ketvanqua.setText("So quay duoc: " + so);
                    tv_maudo.setVisibility(View.VISIBLE);
                    tv_mauxanh.setVisibility(View.GONE);
               }
            }
        });
    }
}