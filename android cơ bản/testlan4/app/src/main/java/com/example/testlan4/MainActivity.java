package com.example.testlan4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;

import com.example.testlan4.Adapter.adapter_ViewPages;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private LinearLayout linearLayoutprogress;
    private adapter_ViewPages adapter_viewPages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.id_tabLayout);
        viewPager2=findViewById(R.id.id_viewpages2);
        linearLayoutprogress=findViewById(R.id.id_linearprogress);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                linearLayoutprogress.setVisibility(ViewPager2.INVISIBLE);
            }
        },6000);

        adapter_viewPages=new adapter_ViewPages(this);
        viewPager2.setAdapter(adapter_viewPages);
        TabLayoutMediator tabLayoutMediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Danh sách gv");
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