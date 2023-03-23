package com.example.lab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadCastbai2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
           String name=intent.getStringExtra("NAME_BAI2");
          Toast.makeText(context.getApplicationContext(), "MyBroadCast " + name , Toast.LENGTH_SHORT).show();
    }
}
