package vn.edu.spx.vd2_broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // gửi Broadcast
                Intent i3 = new Intent(getApplicationContext(), DemoBroadcastReceiver.class);
                i3.setAction("vn.edu.spx.vd2_broadcast.DEMO_ACTION_001");

                sendBroadcast(i3);


            }
        });

    }
}