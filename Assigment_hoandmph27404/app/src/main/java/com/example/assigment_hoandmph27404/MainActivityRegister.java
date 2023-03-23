package com.example.assigment_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assigment_hoandmph27404.DAO.UserDAO;
import com.example.assigment_hoandmph27404.DTO.User;

public class MainActivityRegister extends AppCompatActivity {
    Button btn_dangky,btn_huydangky;
    EditText ed_retendangnhap,ed_hovaten,ed_pass,ed_repassregister;
    UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);

        btn_huydangky=findViewById(R.id.btn_huydangky);
        ed_retendangnhap=findViewById(R.id.ed_retendangnhap);
        ed_repassregister=findViewById(R.id.ed_repassregister);
        ed_hovaten=findViewById(R.id.ed_hovaten);
        ed_pass=findViewById(R.id.ed_pass);
        btn_dangky=findViewById(R.id.btn_dangky);
        userDAO=new UserDAO(this);


        btn_huydangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ed_retendangnhap.setText("");
                ed_hovaten.setText("");
                ed_pass.setText("");
                ed_repassregister.setText("");
            }
        });
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user=new User();
                user.setIdUser(ed_retendangnhap.getText().toString());
                user.setHoTen(ed_hovaten.getText().toString());
                user.setMatKhau(ed_pass.getText().toString());
                if (validate()>0){
                    if (userDAO.insert(user)>0){
                        Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                        ed_retendangnhap.setText("");
                        ed_hovaten.setText("");
                        ed_pass.setText("");
                        ed_repassregister.setText("");
                    }else{
                        Toast.makeText(getApplicationContext(), "Lưu thất bại ", Toast.LENGTH_SHORT).show();
                    }
                }
                Intent intent=new Intent(MainActivityRegister.this,MainActivityLogin.class);
                startActivity(intent);
            }

        });
    }

    public int validate(){
        int check=1;
        if (ed_retendangnhap.getText().length()==0 || ed_hovaten.getText().length()==0 || ed_pass.getText().length()==0
                || ed_repassregister.getText().length()==0){
            Toast.makeText(getApplicationContext(), "Bạn phải nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check=-1;
        }else{
            String pass= ed_pass.getText().toString();
            String rePass=ed_repassregister.getText().toString();
            if (!pass.equals(rePass)){
                Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                check=-1;
            }
        }
        return check;
    }
}