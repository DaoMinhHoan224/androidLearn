package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private FrameLayout mFramelayout;
    private Button btn_show,btn_an;
    private int[] arrimg = {R.drawable.img};
    boolean show=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFramelayout = findViewById(R.id.layvanout);
        btn_show = findViewById(R.id.btn_show);




               for (int i=0;i<arrimg.length;i++){
                   FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(
                           ViewGroup.LayoutParams.WRAP_CONTENT,
                           ViewGroup.LayoutParams.WRAP_CONTENT
                   );
                   params.gravity=1;
                   ImageView mImgview=new ImageView(this);
                   mImgview.setImageResource(arrimg[i]);

                   mImgview.setLayoutParams(params);
                   mFramelayout.addView(mImgview);
               }

               btn_show.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if (show){
                           mFramelayout.setVisibility(View.INVISIBLE);
                           btn_show.setText("Show");
                           show=false;
                       }else{
                           mFramelayout.setVisibility(View.VISIBLE);
                           btn_show.setText("High");
                           show=true;
                       }
                   }
               });

           }





//    public void showanh(View view){
//        for (int i=0;i<arrimg.length;i++){
//            FrameLayout.LayoutParams params=new FrameLayout.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//            );
//            ImageView mImgview=new ImageView(this);
//            mImgview.setImageResource(arrimg[i]);
//            mImgview.setLayoutParams(params);
//            mFramelayout.addView(mImgview);
//            if (show){
//                mImgview.setVisibility(View.VISIBLE);
//                btn_show.setVisibility(View.GONE);
//                btn_an.setVisibility(View.VISIBLE);
//                show=true;
//            }else{
//                mImgview.setVisibility(View.INVISIBLE);
//                btn_show.setVisibility(View.VISIBLE);
//                btn_an.setVisibility(View.GONE);
//                show=false;
//            }
//        }
//    }

}