package com.example.lab1bai12;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

public class ClassLabService extends Service {
    public ClassLabService() {
    }


    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        Toast.makeText(this, "new service was started", Toast.LENGTH_SHORT).show();
        Bundle b=intent.getBundleExtra("student");
        int StuID=b.getInt("StuID");
        String StuName=b.getString("StuName");
        String StuClass=b.getString("Class");

        String content="Thêm sinh viên thành công.\n Thông tin sinh viên: \nSinh viên:" +StuID+""+StuName;
        content += "\nLớp" + StuClass;
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}