package com.example.testlailannuane;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.example.testlailannuane.Adapter.adapter_viewpages;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private com.example.testlailannuane.Adapter.adapter_viewpages adapter_viewpages;
    private LinearLayout linearLayoutprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.id_tabLayout);
        viewPager2=findViewById(R.id.id_viewpages2);
        linearLayoutprogress=findViewById(R.id.id_linearlayoutprogress);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                linearLayoutprogress.setVisibility(View.INVISIBLE);
            }
        },6000);
        adapter_viewpages=new adapter_viewpages(this);
        viewPager2.setAdapter(adapter_viewpages);

        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Danh sách GV");
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