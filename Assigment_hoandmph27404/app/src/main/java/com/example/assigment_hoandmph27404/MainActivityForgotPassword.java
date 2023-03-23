package com.example.assigment_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assigment_hoandmph27404.DAO.UserDAO;
import com.example.assigment_hoandmph27404.DTO.User;

public class MainActivityForgotPassword extends AppCompatActivity {
    Button btn_savepass, btn_cancel;
    UserDAO userDAO;
    EditText ed_matkhaucu,ed_matkhaumoi,ed_nhaplaimatkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_forgot_password);

        btn_cancel=findViewById(R.id.btn_huysave);
        ed_matkhaucu=findViewById(R.id.ed_matkhaucu);
        ed_matkhaumoi=findViewById(R.id.ed_matkhaumoi);
        ed_nhaplaimatkhau=findViewById(R.id.ed_nhaplaimatkhaumoi);
        btn_savepass=findViewById(R.id.btn_save);
        userDAO=new UserDAO(this);

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_matkhaucu.setText("");
                ed_matkhaumoi.setText("");
                ed_nhaplaimatkhau.setText("");
            }
        });

        btn_savepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // đọc user, pass trong SharedPreferences
                SharedPreferences  pref =getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
                String username11=pref.getString("USERNAME","");
                if (validate()>0){
                     User user=userDAO.getID(username11);
                    user.setMatKhau(ed_matkhaumoi.getText().toString());
                    userDAO.updatePass(user);
                    if (userDAO.updatePass(user) >0){
                        Toast.makeText(getApplicationContext(), "Thay đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();
                        ed_matkhaucu.setText("");
                        ed_matkhaumoi.setText("");
                        ed_nhaplaimatkhau.setText("");
                    }else{
                        Toast.makeText(getApplicationContext(), "Thay đổi mật khẩu thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public int validate(){
        int check=1;
        if (ed_matkhaucu.getText().length()==0 || ed_matkhaumoi.getText().length()==0 || ed_nhaplaimatkhau.getText().length()==0){
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check=-1;
        }else{
            // đọc user, pass trong sharepreferences
            SharedPreferences pref=getSharedPreferences("USER_FILE", Context.MODE_PRIVATE);
            String passOld=pref.getString("PASSWORD","");
            String pass=ed_matkhaumoi.getText().toString();
            String rePass=ed_nhaplaimatkhau.getText().toString();
            if (!passOld.equals(ed_matkhaucu.getText().toString())){
                Toast.makeText(getApplicationContext(), "Mật khẩu cũ sai", Toast.LENGTH_SHORT).show();
                check=-1;
            }
            if (!pass.equals(rePass)){
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check=-1;
            }
        }
        return check;
    }
}