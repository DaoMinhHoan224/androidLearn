package com.example.thuchanhwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnlogin,btnregister;
    EditText ed_user,ed_pass;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_user=findViewById(R.id.ed_user);
        ed_pass=findViewById(R.id.ed_pass);
        sharedPreferences=getSharedPreferences("login_register", Context.MODE_PRIVATE);
        btnlogin=findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String ed_userlogin=ed_user.getText().toString();
                String ed_passlogin=ed_pass.getText().toString();
                String eduserlogin=sharedPreferences.getString("Username","");
                String edpasslogin=sharedPreferences.getString("Password","");

                if(ed_userlogin.equalsIgnoreCase(eduserlogin) && ed_passlogin.equalsIgnoreCase(edpasslogin)){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getBaseContext(),weBView.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }


            }
        });
        btnregister=findViewById(R.id.btn_register);
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),reGister.class);
                startActivity(i);
            }
        });
    }
}