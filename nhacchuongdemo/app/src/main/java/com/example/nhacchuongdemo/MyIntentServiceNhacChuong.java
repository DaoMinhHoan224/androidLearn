package com.example.nhacchuongdemo;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class MyIntentServiceNhacChuong extends IntentService {
    MediaPlayer player=null;
    String TAG="PlayMusic-zzzzzzz";
    int ID_SV;

    public MyIntentServiceNhacChuong() {
        super("MyIntentServiceNhacChuong");
        Log.d(TAG,"Gọi hàm khởi tạo ... ");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG,"Gọi hàm onHandleIntent - id = " + startId);
        ID_SV=startId;
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        synchronized (this){
            Log.d(TAG,"gọi hàm onhandleintent - id= " +ID_SV);
            if (player==null){
                player=MediaPlayer.create(this,R.raw.nhac_chuong);
                player.start();
            }

            Toast.makeText(this, "onHandleIntent", Toast.LENGTH_SHORT).show();
            Log.d(TAG,"onhandleintent" + player.toString());

            while (player != null && player.isPlaying()){
               //đang chạy nhạc thì service chưa dừng
                try{
                    wait(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            stopSelf(ID_SV);
        }

    }

    @Override
    public void onDestroy() {
        Log.d(TAG,"Gọi hàm onDesTroy - id" + ID_SV);
        if (player!=null){
           Log.d(TAG,"player != null");
           player.stop();
           player.release();//giải phóng player
            player=null;
            Toast.makeText(this, "Hết nhạc rồi", Toast.LENGTH_SHORT).show();
        }
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}