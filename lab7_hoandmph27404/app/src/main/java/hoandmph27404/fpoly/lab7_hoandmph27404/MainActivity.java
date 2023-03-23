package hoandmph27404.fpoly.lab7_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView img_logo,img_news,img_music,img_account;
    TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_logo=findViewById(R.id.img_logo);
        img_news=findViewById(R.id.img_news);
        img_music=findViewById(R.id.img_music);
        img_account=findViewById(R.id.img_account);
        tv_name=findViewById(R.id.tv_name);

        img_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.hieuung_logo);
                img_logo.startAnimation(animation);
            }
        });

        img_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet=(AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.hieuung_news);
                animatorSet.setTarget(img_news);
                animatorSet.start();
            }
        });

        img_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet=(AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.hieuung_music);
                animatorSet.setTarget(img_music);
                animatorSet.start();
            }
        });

        img_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet animatorSet=(AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.hieuung_account);
                animatorSet.setTarget(img_account);
                animatorSet.start();
            }
        });

        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.hieuung_name);
                animation.setFillAfter(true);
                tv_name.startAnimation(animation);
            }
        });
    }
}