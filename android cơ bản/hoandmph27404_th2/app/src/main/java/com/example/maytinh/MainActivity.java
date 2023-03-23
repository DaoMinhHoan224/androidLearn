package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn_welcome;
    EditText ed_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_name=findViewById(R.id.ed_name);
        btn_welcome=findViewById(R.id.btn_computer);
        btn_welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ed_name.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("hoten",name);


                Intent intend=new Intent(getBaseContext(),MayTinhActivity.class);
                intend.putExtra("goi_hang",bundle);
                startActivity(intend);
            }
        });
    }

}