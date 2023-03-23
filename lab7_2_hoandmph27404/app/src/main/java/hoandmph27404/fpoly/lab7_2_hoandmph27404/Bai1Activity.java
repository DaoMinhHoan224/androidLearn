package hoandmph27404.fpoly.lab7_2_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Bai1Activity extends AppCompatActivity {
    Button btn_rotation, btn_moving, btn_zoom;
    int dest;
    ImageView aniView, img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        aniView=findViewById(R.id.img_all);
        btn_rotation=findViewById(R.id.btn_rotation);
        btn_zoom=findViewById(R.id.btn_zoom);
        btn_moving=findViewById(R.id.btn_moving);
        btn_rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dest=360;
                if (aniView.getRotation() == 360){
                    System.out.println(aniView.getAlpha());
                    dest=0;
                }
                ObjectAnimator animation1=ObjectAnimator.ofFloat(aniView,"rotation",dest);
                animation1.setDuration(2000);
                animation1.start();
            }
        });

        btn_zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(Bai1Activity.this,R.anim.zoom);
                aniView.startAnimation(animation);
            }
        });

        btn_moving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(aniView,"translationX",0f,200f);
                objectAnimator.setDuration(2000);
                objectAnimator.setRepeatMode(ValueAnimator.RESTART);
                objectAnimator.start();
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
}