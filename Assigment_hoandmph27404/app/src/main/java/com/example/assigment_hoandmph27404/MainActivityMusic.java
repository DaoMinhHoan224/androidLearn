package com.example.assigment_hoandmph27404;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.assigment_hoandmph27404.Fragment.FavoriteMusicFragment;
import com.example.assigment_hoandmph27404.Fragment.ListMusicFragment;
import com.example.assigment_hoandmph27404.Fragment.MusicFragment;
import com.example.assigment_hoandmph27404.Fragment.NewsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivityMusic extends AppCompatActivity {
    ActionBar toolbar1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_music);

        toolbar1= getSupportActionBar();
        BottomNavigationView bottomNavigationView1;
        bottomNavigationView1=findViewById(R.id.bottom_navmusic);

        loadFragment(new MusicFragment());

        bottomNavigationView1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()){
                    case R.id.nav_trangchumusic:
//                        toolbar1.setTitle("Trang chủ nhạc");
                        fragment=new MusicFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.nav_librarymusic:
//                        toolbar1.setTitle("Danh sách nhạc");
                        fragment=new ListMusicFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_framelayoutmusic,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}