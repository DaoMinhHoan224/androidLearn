package com.example.assigment_hoandmph27404.Service;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import com.example.assigment_hoandmph27404.DTO.Song;

import java.util.ArrayList;

public class MusicService extends Service implements MediaPlayer.OnPreparedListener,MediaPlayer.OnErrorListener,MediaPlayer.OnCompletionListener {
    private MediaPlayer player;
    //song list
    private ArrayList<Song> songs;
    //current position
    private int songPosn;
    private final IBinder musicBind = new MusicBinder();

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        songPosn=0;
        player=new MediaPlayer();
        initMusicPlayer();
    }

    public void initMusicPlayer(){
        player.setWakeMode(getApplicationContext(),
                PowerManager.PARTIAL_WAKE_LOCK);
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);

        player.setOnPreparedListener(this);
        player.setOnCompletionListener(this);
        player.setOnErrorListener(this);
    }

    public void setList(ArrayList<Song> theSongs){
        songs=theSongs;
    }

    public class MusicBinder extends Binder {
        public MusicService getService(){
             return MusicService.this;
        }
    }

    public void playSong(){
        //play a song
        player.reset();
        //get song
        Song playSong = songs.get(songPosn);
        //get id
        long currSong = playSong.getSongID();
        //set uri
        Uri trackUri = ContentUris.withAppendedId(
                android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                currSong);

        try{
            player.setDataSource(getApplicationContext(), trackUri);
        }
        catch(Exception e){
            Log.e("MUSIC SERVICE", "Error setting data source", e);
        }

        player.prepareAsync();
    }

    public void setSong(int songIndex){
        songPosn=songIndex;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return musicBind;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
     //start playback
        mp.start();
    }

    @Override
    public boolean onUnbind(Intent intent){
        player.stop();
        player.release();
        return false;
    }
}