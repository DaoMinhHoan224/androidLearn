package com.example.assigment_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.assigment_hoandmph27404.DTO.Bxhmusic;
import com.example.assigment_hoandmph27404.DTO.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import de.hdodenhof.circleimageview.CircleImageView;

public class BxhPlayActivity extends AppCompatActivity {
    TextView tv_songtitle, tv_singer, tv_timestart, tv_timeend;
    SeekBar seekBar;
    ImageButton pause_play, btn_prev, btn_next, btn_rand, btn_replay;
    ArrayList<Bxhmusic> bxhsong;
    Bxhmusic bxh;
    MediaPlayer mymediaPlayer =MyMediaPlayer.getInstance();
    int x = 0;
    int position=0;
    CircleImageView imgcircleview;
    ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bxh_play);

        tv_songtitle = findViewById(R.id.tv_songtitle);
        tv_singer = findViewById(R.id.tv_singer);
        tv_timestart = findViewById(R.id.tv_timestart1);
        tv_timeend = findViewById(R.id.tv_timeend1);
        seekBar = findViewById(R.id.id_seekbar1);
        btn_next = findViewById(R.id.btn_next1);
        btn_prev = findViewById(R.id.btn_prev1);
        pause_play = findViewById(R.id.play_pause1);
        btn_rand = findViewById(R.id.btn_random1);
        btn_replay = findViewById(R.id.btn_replay1);
        imgcircleview = findViewById(R.id.imgviewcircle1);

        img_back=findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tv_songtitle.setSelected(true);


        bxhsong = (ArrayList<Bxhmusic>) getIntent().getSerializableExtra("BXHLIST");

        setResourcesWithMusic();
        mymediaPlayer=MediaPlayer.create(getBaseContext(), bxhsong.get(position).getFile());
        BxhPlayActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mymediaPlayer != null) {

                    seekBar.setProgress(mymediaPlayer.getCurrentPosition());
//                    tv_timestart.setText(convertToMMSS(mediaPlayer.getCurrentPosition()+""));

                    if (mymediaPlayer.isPlaying()) {
                        pause_play.setImageResource(R.drawable.ic_pause);
                        imgcircleview.setRotation(x++);
                    } else {
                        pause_play.setImageResource(R.drawable.play);
                        imgcircleview.setRotation(0);
                    }

                }
                new Handler().postDelayed(this, 1000);
            }
        });

//        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if(mediaPlayer!=null && fromUser){
//                    mediaPlayer.seekTo(progress);
//                }
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

    }

    void setResourcesWithMusic() {
        bxh = bxhsong.get(MyMediaPlayer.currentIndex);

        tv_songtitle.setText(bxh.getSong());
        tv_singer.setText(bxh.getSinger());

//        tv_timeend.setText(convertToMMSS(bxh.getDuration()));

        pause_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pausePlay();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNextSong();
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPreviousSong();
            }
        });

        playMusic();


    }

    private void playMusic() {

        mymediaPlayer.reset();
        try {
            mymediaPlayer.setDataSource(bxh.getSong());
            mymediaPlayer.prepare();
            mymediaPlayer.start();
            //seekBar.setProgress(0);
//            seekBar.setMax(mediaPlayer.getDuration());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void playNextSong() {

        if (MyMediaPlayer.currentIndex == bxhsong.size()-1)
            return;
        MyMediaPlayer.currentIndex += 1;
        mymediaPlayer.reset();
        setResourcesWithMusic();

    }

    private void playPreviousSong() {
        if (MyMediaPlayer.currentIndex == 0)
            return;
        MyMediaPlayer.currentIndex -= 1;
        mymediaPlayer.reset();
        setResourcesWithMusic();
    }

    private void pausePlay() {
        if (mymediaPlayer.isPlaying())
            mymediaPlayer.pause();
        else
            mymediaPlayer.start();
    }


//    public static String convertToMMSS(String duration){
//        Long millis = Long.parseLong(duration);
//        return String.format("%02d:%02d",
//                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1),
//                TimeUnit.MILLISECONDS.toSeconds(millis) % TimeUnit.MINUTES.toSeconds(1));
//    }
}