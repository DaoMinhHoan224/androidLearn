package com.example.demoxulychuoikytu;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class DemoBoundServiceTinhTong extends Service {
    IBinder iBinder=new LocalBinder();//Đối tượng sử dụng để liên kết với client
    public DemoBoundServiceTinhTong() {
    }


    public class LocalBinder extends Binder {
        LocalBinder getLocalBinder(){
            return LocalBinder.this;//phương thức khởi tạo khi client gọi tới các phương thức của service
        }
    }


    public int Tong(int a, int b){
        int t=a+b;
        return t;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}