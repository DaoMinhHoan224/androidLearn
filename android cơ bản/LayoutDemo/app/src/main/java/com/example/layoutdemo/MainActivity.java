package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed_name,ed_pass;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity2.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void anhXa() {
        ed_name=findViewById(R.id.ed_name);
        ed_pass=findViewById(R.id.ed_pass);
        btn_login=findViewById(R.id.btn_login);
    }

    @Override
    protected void onRestart() {
        getColor(R.color.purple_200);
        super.onRestart();
    }
}