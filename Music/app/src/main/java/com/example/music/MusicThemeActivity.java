package com.example.music;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MusicThemeActivity extends AppCompatActivity {

    TextView txtTitle, txtTimeStart, txtTimeEnd;
    SeekBar skSong;
    ImageButton btnPrev, btnNext, btnPlay, btnRandom, btnReplay;
    CircleImageView circleImageView;
    ObjectAnimator objectAnimator;
    ArrayList<song> songList;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_theme);

        songList=new ArrayList<>();
        circleImageView=findViewById(R.id.imgviewcircle);
        objectAnimator=ObjectAnimator.ofFloat(circleImageView,"rotation",0f,360f);
        objectAnimator.setDuration(10000);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.RESTART);
        objectAnimator.setInterpolator(new LinearInterpolator());

        anhXa();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer=MediaPlayer.create(MusicThemeActivity.this,songList.get(position).getSongId());
                mediaPlayer.start();
                txtTitle.setText(songList.get(position).getSongTitle());
            }
        });
    }

    private void anhXa(){
        txtTitle=findViewById(R.id.tv_title);
        txtTimeStart=findViewById(R.id.tv_timestart);
        txtTimeEnd=findViewById(R.id.tv_timeend);
        skSong=findViewById(R.id.id_seekbar);
        btnNext=findViewById(R.id.btn_next);
        btnPlay=findViewById(R.id.btn_play);
        btnPrev=findViewById(R.id.btn_prev);
        btnRandom=findViewById(R.id.btn_random);
        btnReplay=findViewById(R.id.btn_replay);

    }
}