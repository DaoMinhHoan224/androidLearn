package com.example.thuchanhtrenlop1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class info extends AppCompatActivity {

    EditText ed_phone;
    Button btn_goi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        ed_phone=findViewById(R.id.ed_phone);
        btn_goi=findViewById(R.id.btn_goi);

        Intent objIntent=getIntent();
        Bundle objBundle=objIntent.getBundleExtra("goi_hang");
        String email=objBundle.getString("email");
        String pass=objBundle.getString("pass");

        TextView tv_info=findViewById(R.id.tv_info);
        tv_info.setText("Email: " + email + "\nPassword" + pass);
        btn_goi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdt=ed_phone.getText().toString();

                Intent intent_call=new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + sdt));
                startActivity(intent_call);
            }
        });

    }
}