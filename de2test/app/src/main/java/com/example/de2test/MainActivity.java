package com.example.de2test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.example.de2test.adapter.adapter_viewpages;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    adapter_viewpages adapter_viewpages;
    LinearLayout linearprogressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.id_tablayout);
        viewPager2=findViewById(R.id.id_viewpages);
        linearprogressbar=findViewById(R.id.linearprogressbar);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                linearprogressbar.setVisibility(View.INVISIBLE);
            }
        },6000);

        adapter_viewpages=new adapter_viewpages(this);
        viewPager2.setAdapter(adapter_viewpages);

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Danh sách giáo viên");
                        break;
                    case 1:
                        tab.setText("Thêm giáo viên");
                        break;
                }
            }
        });
        tabLayoutMediator.attach();
    }
}