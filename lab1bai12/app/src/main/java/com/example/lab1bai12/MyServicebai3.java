package com.example.lab1bai12;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyServicebai3 extends Service {

    IBinder iBinder=new LocalBiner();
    public MyServicebai3() {
    }

    public String Demkitu(String a,char b){
         int tong=0;
         for (int i=0;i<a.length();i++){
             if (a.charAt(i)==b){
                 tong++;
             }
         }
         return tong+"";
    }


    public class LocalBiner extends Binder{
        LocalBiner getLocalBiner(){
            return LocalBiner.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}