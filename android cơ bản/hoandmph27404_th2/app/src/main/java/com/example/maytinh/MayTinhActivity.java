package com.example.maytinh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MayTinhActivity extends AppCompatActivity {
    private double so_a;
    private double so_b;
    private String pheptoan="";
    private TextView manhinhhienthiso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goplayout);

        manhinhhienthiso=findViewById(R.id.manhinhhienthiso);
        Intent objintent=getIntent();
        Bundle objBundle=objintent.getBundleExtra("goi_hang");
        String hoten=objBundle.getString("hoten");
        TextView tv_info=findViewById(R.id.tv_info);
        tv_info.setText("hoten " + hoten);
        }


    public void NumberClick(View view){
       Button btn=(Button) view;
       if(this.pheptoan.length()==0){
           so_a=Double.parseDouble(btn.getText().toString());
           manhinhhienthiso.setText(String.valueOf(so_a));
       }else{
           so_b = Double.parseDouble(btn.getText().toString());
           manhinhhienthiso.setText(String.valueOf(so_b));
       }


    }

    public void ChonPhepToan(View view){
        Button btn=(Button) view;
        this.pheptoan=btn.getText().toString();
        manhinhhienthiso.setText(pheptoan);
    }

    public void ketqua(View view){
        if(this.pheptoan.length()>0){
            Double KQ;
            switch (this.pheptoan){
                case "+":
                    KQ=so_a+so_b;
                    Toast.makeText(getBaseContext(), String.valueOf(KQ), Toast.LENGTH_SHORT).show();
                    manhinhhienthiso.setText(String.valueOf(KQ));
                    break;
                case "-":
                    KQ=so_a-so_b;
                    Toast.makeText(getBaseContext(), String.valueOf(KQ), Toast.LENGTH_SHORT).show();
                    manhinhhienthiso.setText(String.valueOf(KQ));
                    break;
                case "*":
                    KQ=so_a*so_b;
                    Toast.makeText(getBaseContext(), String.valueOf(KQ), Toast.LENGTH_SHORT).show();
                    manhinhhienthiso.setText(String.valueOf(KQ));
                    break;
                case "/":
                    KQ=so_a/so_b;
                    Toast.makeText(getBaseContext(), String.valueOf(KQ), Toast.LENGTH_SHORT).show();
                    manhinhhienthiso.setText(String.valueOf(KQ));
                    break;
                case "C":
                    String resetText=pheptoan.substring(0,this.pheptoan.length()-1);
                    pheptoan=resetText;
                    break;

            }

        }
    }
    }
