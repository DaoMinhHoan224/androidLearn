package hoandmph27404.fpoly.animation7;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv01;
    Button btn01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv01=findViewById(R.id.tv01);
        btn01=findViewById(R.id.btn01);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // viết code load file hiệu ứng gán cho textview
//                AnimatorSet animatorSet= (AnimatorSet) AnimatorInflater.loadAnimator(
//                        MainActivity.this,R.animator.hieu_ung001
//
//                );
//
//                animatorSet.setTarget(tv01);
//                animatorSet.start();

//                code java tạo hiệu ứng
//                float x_tv=tv01.getX();
//
//                AnimatorSet animatorSet=new AnimatorSet();
//                //tạo ra các đối tượng hiệu ứng
//                ObjectAnimator sangPhai=ObjectAnimator.ofFloat(tv01,"x",x_tv,500);
//                sangPhai.setDuration(3000);
//
//                ObjectAnimator sangTrai=ObjectAnimator.ofFloat(tv01,"x",x_tv);
//                sangTrai.setDuration(3000);
//
//                animatorSet.playSequentially(sangPhai,sangTrai); //chạy tuần tự
//                animatorSet.start();

                //code làm việc với View Animation

                Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.hieu_ungtv);
                tv01.startAnimation(animation);
            }
        });
    }
}