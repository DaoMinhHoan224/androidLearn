package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class FramelayoutActivity extends AppCompatActivity {
    private FrameLayout mFramelayout;

    private int[] arrayImg = {R.drawable.img, R.drawable.img_1, R.drawable.img_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.framelayout);

        mFramelayout = findViewById(R.id.id_layout);


       for(int i=0;i<arrayImg.length;i++){
           FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                   ViewGroup.LayoutParams.WRAP_CONTENT,
                   ViewGroup.LayoutParams.WRAP_CONTENT//tạo khung ảnh(tạo keo dính)
           );
           ImageView mImageView = new ImageView(this);
           params.leftMargin=i*80;
           mImageView.setImageResource(arrayImg[i]);//tạo ra ảnh
           mImageView.setLayoutParams(params);//cho ảnh vào khung (bôi keo dính vào ảnh)
           mFramelayout.addView(mImageView);//treo ảnh lên tường (dán ảnh lên tường)
       }
    }
}