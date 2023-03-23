package hoandmph27404.fpoly.hoandmph27404_thi;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;

public class MyService extends Service {
    MediaPlayer player;
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        player=MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        player.setLooping(false);
        player.start();

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                stopSelf();
            }
        },1000);


        return START_NOT_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();

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