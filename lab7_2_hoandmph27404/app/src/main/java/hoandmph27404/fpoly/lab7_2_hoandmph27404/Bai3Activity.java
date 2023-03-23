package hoandmph27404.fpoly.lab7_2_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Bai3Activity extends AppCompatActivity {
    ImageView ClockImage,SecondImage,MinuteImage,HourImage, img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        ClockImage=findViewById(R.id.ClockImage);
        ClockImage.setImageResource(R.drawable.bg);

        SecondImage=findViewById(R.id.SecondImage);
        SecondImage.setImageResource(R.drawable.second);

        MinuteImage=findViewById(R.id.MinuteImage);
        MinuteImage.setImageResource(R.drawable.minute);

        HourImage=findViewById(R.id.HourImage);
        HourImage.setImageResource(R.drawable.hour);

        img_back=findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void RunClock(View v){
        Animation animationHour= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.hour);
        Animation animationMinute=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.minute);
        Animation animationSecond=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.second);
        HourImage.startAnimation(animationHour);
        MinuteImage.startAnimation(animationMinute);
    }
}