package com.example.day01;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class MyService0001 extends Service {
    MediaPlayer player;
    public MyService0001() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Bắt đầu chạy service", Toast.LENGTH_SHORT).show();

        player=MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        player.setLooping(true);
        player.start(); //bắt đâfu chạy nhạc

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MyService0001.this, "Hết 10s đợi rồi, stop", Toast.LENGTH_SHORT).show();
                stopSelf();
            }
        },10000);

        notification=new Notification.Builder(this,CHANNEL_ID).setContentTitle("Tiêu đề thông báo")
                .setContentText("Ứng dụng bắt đầu chơi nhạc").setSmallIcon(android.R.drawable.ic_dialog_info).build();

        startForeground(1, notification);

        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        Toast.makeText(this, "Huy nhac", Toast.LENGTH_SHORT).show();
    }

    public static final String CHANNEL_ID="exampleServiceChannel";
    Notification notification=null;

    @Override
    public void onCreate() {
        super.onCreate();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel serviceChannel= new NotificationChannel(CHANNEL_ID,"Example service channel",
                    NotificationManager.IMPORTANCE_DEFAULT);

            NotificationManager notificationManager= getSystemService(NotificationManager.class);

            notificationManager.createNotificationChannel(serviceChannel);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}