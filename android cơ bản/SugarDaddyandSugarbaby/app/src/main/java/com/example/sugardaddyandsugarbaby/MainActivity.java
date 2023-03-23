package com.example.sugardaddyandsugarbaby;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Button btn_con;
    ActivityResultLauncher toolActivityResultLauncher
            =registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            Log.d("","onActivityResult: " + result.toString());
            Log.d("","onActivityResult:"+ result.getResultCode());
            Log.d("","onActivityResult: hoten= "+ result.getData().getStringExtra("hoten"));

        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_con=findViewById(R.id.btn_con);
        btn_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),ActivityBaby.class);
                toolActivityResultLauncher.launch(intent);

                Log.d("","OpenAct2: ");
            }
        });

    }
}