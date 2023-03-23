package com.example.lablogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_user,ed_pass;
    Button btn_login,btn_check;
    CheckBox cbkremember;
    SharedPreferences   sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("login", Context.MODE_PRIVATE);
        ed_user=findViewById(R.id.ed_user);
        ed_pass=findViewById(R.id.ed_pass);
        cbkremember=findViewById(R.id.cbo_remember);

        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eduser=ed_user.getText().toString();
                String edpass=ed_pass.getText().toString();
                String user="admin";
                String pass="123";
                if (eduser.equalsIgnoreCase(user) && edpass.equalsIgnoreCase(pass)){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Đăng nhập không thành công.Vui lòng đăng nhập lại", Toast.LENGTH_SHORT).show();
                }

                cbkremember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor=sharedPreferences.edit();

                        editor.putString("Username","admin");
                        editor.putString("Password","123");

                        editor.commit();//commit thì mới ghi xuống file
                    }
                });

                SharedPreferences.Editor editor=sharedPreferences.edit();

                editor.putString("Username","admin");
                editor.commit();

            }
        });
        btn_check=findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_user.setText(sharedPreferences.getString("Username",""));
                ed_pass.setText(sharedPreferences.getString("Password",""));
            }
        });

    }
}