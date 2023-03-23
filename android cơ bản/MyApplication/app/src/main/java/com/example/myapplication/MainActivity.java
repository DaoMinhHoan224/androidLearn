package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText ed_number;
    TextView Thongbao,txtWin,txtLost,txtKq;
    Button btnQuaySo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutthongtin);

        ed_number = findViewById(R.id.ed_number);
        Thongbao = findViewById(R.id.Thongbao);
        txtWin = findViewById(R.id.txtWin);
        txtLost = findViewById(R.id.txtLost);
        txtKq = findViewById(R.id.txtKq);
        txtWin.setVisibility(View.GONE);
        txtLost.setVisibility(View.GONE);
        btnQuaySo = findViewById(R.id.btnQuaySo);

        btnQuaySo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number =Double.parseDouble(ed_number.getText().toString() );
                Random r = new Random();
                int so = r.nextInt(99);

                Thongbao.setVisibility(View.GONE);
                if (so == number){
                    txtKq.setText("KẾT QUẢ : " + so);
                    txtWin.setVisibility(View.VISIBLE);
                    txtLost.setVisibility(View.GONE);
                }else{
                    txtKq.setText("KẾT QUẢ : " + so);
                    txtWin.setVisibility(View.GONE);
                    txtLost.setVisibility(View.VISIBLE);
                }



            }
        });


    }
}