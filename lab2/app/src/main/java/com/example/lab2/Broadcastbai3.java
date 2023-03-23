package com.example.lab2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Broadcastbai3 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String checkcheck=intent.getStringExtra("CHECK_VOUCHER");

        if (checkcheck.equals("")){
            Toast.makeText(context, "Không được để trống", Toast.LENGTH_SHORT).show();
        }else if(checkcheck.length()>9 || checkcheck.length()<9){
            Toast.makeText(context, "Chuỗi gồm 9 ký tự", Toast.LENGTH_SHORT).show();
        }else if(!checkcheck.substring(0,3).equalsIgnoreCase("MEM") && !checkcheck.substring(0,3).equalsIgnoreCase("VIP")){
            Toast.makeText(context, "Mã phải bắt đầu bằng MEM hoặc VIP ", Toast.LENGTH_SHORT).show();
        }else if(checkcheck.equalsIgnoreCase("MEM537128")){
            Toast.makeText(context, "Khuyến mãi 10%", Toast.LENGTH_SHORT).show();
        }else if(checkcheck.equalsIgnoreCase("MEM537129")){
            Toast.makeText(context, "Khuyến mãi 20%", Toast.LENGTH_SHORT).show();
        }else if(checkcheck.equalsIgnoreCase("VIP537128")){
            Toast.makeText(context, "Khuyến mãi 30%", Toast.LENGTH_SHORT).show();
        }else if(checkcheck.equalsIgnoreCase("VIP537129")){
            Toast.makeText(context, "Khuyến mãi 50%", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Không khuyến mãi", Toast.LENGTH_SHORT).show();
        }
    }
}
