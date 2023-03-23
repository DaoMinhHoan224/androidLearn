package com.example.thuchanhtrenlop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_email,ed_pass;
    Button btn_dangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_email=findViewById(R.id.ed_email);
        ed_pass=findViewById(R.id.ed_pass);

        btn_dangnhap=findViewById(R.id.btn_dangnhap);
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=ed_email.getText().toString();
                String pass=ed_pass.getText().toString();
                String emailcheck="admin@gmail.com";
                String passcheck="123";

                if(email.equalsIgnoreCase(emailcheck) && pass.equalsIgnoreCase(passcheck)) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Không đúng", Toast.LENGTH_SHORT).show();
                }

                Intent i=new Intent(getBaseContext(),info.class);
                Bundle bundle=new Bundle();
                bundle.putString("email",email);
                bundle.putString("pass",pass);

                i.putExtra("goi_hang",bundle);

                startActivity(i);
            }
        });

    }
}