package com.example.thuchanhwebview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class reGister extends AppCompatActivity {
    Button btn_rregister;
    EditText eduser,edpass,ed_name,ed_email,ed_sdt,ed_ghichu;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        eduser=findViewById(R.id.ed_user);
        edpass=findViewById(R.id.ed_pass);
        ed_name=findViewById(R.id.ed_name);
        ed_email=findViewById(R.id.ed_email);
        ed_sdt=findViewById(R.id.ed_phone);
        ed_ghichu=findViewById(R.id.ed_note);
        sharedPreferences=getSharedPreferences("login_register", Context.MODE_PRIVATE);
        btn_rregister=findViewById(R.id.btn_registerr);
        btn_rregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ed_userremember=eduser.getText().toString();
                String ed_passremember=edpass.getText().toString();
                String ed_nameremember=ed_name.getText().toString();
                String ed_emailremember=ed_email.getText().toString();
                String ed_sdtremember=ed_sdt.getText().toString();
                String ed_ghichuremember=ed_ghichu.getText().toString();
                SharedPreferences.Editor editor= sharedPreferences.edit();

                editor.putString("Username",ed_userremember);
                editor.putString("Password",ed_passremember);
                editor.putString("hoten",ed_nameremember);
                editor.putString("email",ed_emailremember);
                editor.putString("sdt",ed_sdtremember);
                editor.putString("ghichu",ed_ghichuremember);

                editor.commit();
                Toast.makeText(reGister.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
