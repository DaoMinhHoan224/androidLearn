package hoandmph27404.fpoly.testmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.view.View;
import android.widget.MediaController.MediaPlayerControl;

import android.os.Bundle;

public class MainActivity extends Activity implements MediaPlayerControl {
    private MusicController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setController();
    }

    @Override
    public void start() {

    }

    @Override
    public void pause() {

    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public void seekTo(int pos) {

    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public boolean canPause() {
        return false;
    }

    @Override
    public boolean canSeekBackward() {
        return false;
    }

    @Override
    public boolean canSeekForward() {
        return false;
    }

    @Override
    public int getAudioSessionId() {
        return 0;
    }

    private void setController(){
       controller=new MusicController(this);
       controller.setPrevNextListeners(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               s;
           }
       }, new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

       controller.setMediaPlayer(this);
       controller.setAnchorView(findViewById(R.id.lv_listmusic));
       controller.setEnabled(true);
    }
}