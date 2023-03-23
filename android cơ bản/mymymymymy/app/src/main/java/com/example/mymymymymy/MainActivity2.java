package com.example.mymymymymy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {
    EditText ed_soa,ed_sob;
    TextView tvkq;
    Button btn_tong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ed_soa=findViewById(R.id.ed_soa);
        ed_sob=findViewById(R.id.ed_sob);
        tvkq=findViewById(R.id.tv_kq);
        btn_tong=findViewById(R.id.btn_tong);
        btn_tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double so_a=Double.parseDouble(ed_soa.getText().toString());
                double so_b=Double.parseDouble(ed_sob.getText().toString());
                double tong=so_a+so_b;
                String tong1=String.valueOf(tong);
                Toast.makeText(MainActivity2.this, "Tong " + tong, Toast.LENGTH_SHORT).show();
                tvkq.setText(tong1);
            }
        });
    }
}