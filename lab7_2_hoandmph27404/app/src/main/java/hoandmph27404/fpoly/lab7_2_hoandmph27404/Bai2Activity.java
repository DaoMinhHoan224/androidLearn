package hoandmph27404.fpoly.lab7_2_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Bai2Activity extends AppCompatActivity {
    Button btn_all,btn_doraemon, btn_nobita;
    ImageView imgAll, img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        btn_all=findViewById(R.id.btn_all);
        btn_doraemon=findViewById(R.id.btn_doraemon);
        btn_nobita=findViewById(R.id.btn_nobita);
        imgAll=findViewById(R.id.img_all);

        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("All");
            }
        });
        btn_doraemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("Doraemon");
            }
        });
        btn_nobita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showImage("Nobita");
            }
        });

        img_back=findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showImage(String img){
        //hide image
        ObjectAnimator anim=ObjectAnimator.ofFloat(imgAll,"translationX",0f,500f);
        anim.setDuration(2000);
        ObjectAnimator animl1=ObjectAnimator.ofFloat(imgAll,"alpha",1f,0f);
        animl1.setDuration(2000);

        //show image
        ObjectAnimator anim2=ObjectAnimator.ofFloat(imgAll,"translationX",-500f,0f);
        anim2.setDuration(2000);
        ObjectAnimator animl3=ObjectAnimator.ofFloat(imgAll,"alpha",0f,1f);
        animl3.setDuration(2000);
        //slideshow next image
        AnimatorSet ans=new AnimatorSet();
        ans.play(anim2).with(animl3).after(anim).after(animl1);
        ans.start();
        final String imgName=img;
        animl1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //change imageview
                if (imgName=="Nobita"){
                    imgAll.setImageResource(R.drawable.nobita);
                }
                if (imgName=="Doraemon"){
                    imgAll.setImageResource(R.drawable.doraemon);
                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}