package com.example.aa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class etgs extends AppCompatActivity {
    TextView tvhoten, sdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvhoten=findViewById(R.id.tv_hoten);
        sdt=findViewById(R.id.tv_sdt);
        tvhoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String hoten=tvhoten.getText().toString();
                Toast.makeText(etgs.this, "Dung co an vao toi", Toast.LENGTH_SHORT).show();
                tvhoten.setText("Hay ban vao so dien thoai");
            }
        });
        
        sdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sodt=sdt.getText().toString();
                Toast.makeText(etgs.this, "Call me", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +sodt));
                startActivity(intent);
            }
        });
    }


}
