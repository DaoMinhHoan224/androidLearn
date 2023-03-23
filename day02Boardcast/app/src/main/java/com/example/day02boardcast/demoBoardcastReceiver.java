package com.example.day02boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class demoBoardcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Có nhận Broadcast", Toast.LENGTH_LONG).show();

        /// Gọi activity
        Intent i2 = new Intent(context, GoiDien.class);
        i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        // gửi kèm dữ liệu
        i2.putExtra("dienthoai","0911111111");

        context.startActivity(i2);

    }
}
