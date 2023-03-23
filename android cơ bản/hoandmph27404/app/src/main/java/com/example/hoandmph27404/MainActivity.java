package com.example.hoandmph27404;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.hoandmph27404.adapter.adapter_Viewpager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    adapter_Viewpager adapter_viewpager;
    LinearLayout lnprogressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.id_Tablayout);
        viewPager2=findViewById(R.id.id_viewpager);
        lnprogressBar=findViewById(R.id.layoutprogressbar);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                lnprogressBar.setVisibility(View.INVISIBLE);
            }
        },3000);
        adapter_viewpager=new adapter_Viewpager(this);
        viewPager2.setAdapter(adapter_viewpager);

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
              switch (position){
                  case 0:
                      tab.setText("Danh sách");
                      break;
                  case 1:
                      tab.setText("Thêm ghi chú");
                      break;
              }
            }
        });
        tabLayoutMediator.attach();
    }
}