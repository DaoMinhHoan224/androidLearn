package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class bai4lab1 extends AppCompatActivity {

    private FrameLayout frameLayout;
    private int[] labai={R.drawable.img_3,R.drawable.img_4,R.drawable.img_5,R.drawable.img_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4lab1);

        frameLayout=findViewById(R.id.id_labailayoout);

        for(int i=0;i< labai.length;i++){
            FrameLayout.LayoutParams mParamas=new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
            ImageView imgviewlabai=new ImageView(this);
            mParamas.leftMargin=i*60;
            mParamas.height=250;
            mParamas.width=200;
            imgviewlabai.setImageResource(labai[i]);
            imgviewlabai.setLayoutParams(mParamas);
            frameLayout.addView(imgviewlabai);
        }
    }
}