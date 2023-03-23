package com.example.assigment_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assigment_hoandmph27404.DAO.UserDAO;

public class MainActivityLogin extends AppCompatActivity {
    TextView tv_dangky;
    EditText ed_tendangnhap, ed_pass;
    Button btn_dangnhap,btn_huydangnhap;
    String strUser, strPass;
    CheckBox chkRememberPass;
    UserDAO userDAO;
    ImageView img_viewavatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        setTitle("ĐĂNG NHẬP");
        tv_dangky=findViewById(R.id.id_dangky);
        btn_dangnhap=findViewById(R.id.btn_dangnhap);
        ed_tendangnhap=findViewById(R.id.ed_tendangnhap);
        ed_pass=findViewById(R.id.ed_pass);
        btn_huydangnhap=findViewById(R.id.btn_huydangnhap);
        chkRememberPass=findViewById(R.id.id_checkbox);
        img_viewavatar=findViewById(R.id.img_avatar);

        userDAO=new UserDAO(this);

        SharedPreferences pref=getSharedPreferences("USER_FILE", MODE_PRIVATE);
        ed_tendangnhap.setText(pref.getString("USERNAME",""));
        ed_pass.setText(pref.getString("PASSWORD",""));
        chkRememberPass.setChecked(pref.getBoolean("REMEMBER",false));


        tv_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdangky=new Intent(MainActivityLogin.this, MainActivityRegister.class);
                startActivity(intentdangky);
            }
        });


        btn_huydangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ed_tendangnhap.setText("");
               ed_pass.setText("");
            }
        });
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checklogin();
            }
        });



    }

    public void checklogin(){
        strUser=ed_tendangnhap.getText().toString();
        strPass=ed_pass.getText().toString();
        if (strUser.isEmpty() || strPass.isEmpty()){
            Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu không được bỏ trống",
                    Toast.LENGTH_SHORT).show();
        }else{
            if (userDAO.checkLogin(strUser,strPass)>0 || (strUser.equals("admin") && strPass.equals("admin"))){
                Toast.makeText(getApplicationContext(), "Login thành công", Toast.LENGTH_SHORT).show();
                rememberUser(strUser,strPass,chkRememberPass.isChecked());
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("user",strUser);
                startActivity(i);
                finish();
            }else{
                Toast.makeText(getApplicationContext(), "Tên đăng nhập và mật khẩu khônd đúng ", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void rememberUser(String u, String p, boolean status){
        SharedPreferences pref =getSharedPreferences("USER_FILE", MODE_PRIVATE);
        SharedPreferences.Editor edit= pref.edit();
        if (!status){
            //xóa tình trạng lưu trữ trước đó
            edit.clear();
        }else{
            //Lưu dữ liệu
            edit.putString("USERNAME",u);
            edit.putString("PASSWORD",p);
            edit.putBoolean("REMEMBER",status);
        }
        //lưu lại toàn bộ
        edit.commit();
    }
}