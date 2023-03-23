package com.example.assigment_hoandmph27404;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.assigment_hoandmph27404.Fragment.GameFragment;
import com.example.assigment_hoandmph27404.Fragment.NewsFragment;
import com.example.assigment_hoandmph27404.Fragment.SportFragment;
import com.example.assigment_hoandmph27404.Fragment.WeatherFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityNews extends AppCompatActivity {
    ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_news);

        toolbar= getSupportActionBar();
        BottomNavigationView bottomNavigationView;
        bottomNavigationView=findViewById(R.id.bottom_nav);
//        toolbar.setTitle("Trang chủ");
        loadFragment(new NewsFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()){
                    case R.id.nav_trangchu:
//                        toolbar.setTitle("Trang chủ");
                        fragment=new NewsFragment();
                        loadFragment(fragment);
                        return  true;
                    case R.id.nav_game:
//                        toolbar.setTitle("Trò chơi");
                        fragment=new GameFragment();
                        loadFragment(fragment);
                        return  true;
                    case R.id.nav_sport:
//                        toolbar.setTitle("Thể thao ");
                        fragment=new SportFragment();
                        loadFragment(fragment);
                        return  true;
                    case R.id.nav_weather:
//                        toolbar.setTitle("Thời tiết");
                        fragment=new WeatherFragment();
                        loadFragment(fragment);
                        return  true;
                }
                return false;
            }
        });

    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_framelayoutnews,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
