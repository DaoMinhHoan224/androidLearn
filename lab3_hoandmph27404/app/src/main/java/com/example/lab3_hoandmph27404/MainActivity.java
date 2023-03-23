package com.example.lab3_hoandmph27404;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.Browser;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=getSupportActionBar();
        BottomNavigationView bottomNavigationView;
        bottomNavigationView=findViewById(R.id.bottom_nav_bar);
        toolbar.setTitle("Contact");
        loadFragment(new ContactFragment());



        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.nav_contact:
                        //công việc phone ở đây
                        toolbar.setTitle("Contact");
                        fragment = new ContactFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.nav_bookmark:
                        toolbar.setTitle("Bookmark");
                        fragment = new BookmarkFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.nav_calllog:
                        toolbar.setTitle("Call logs");
                        fragment = new CalllogsFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.nav_media:
                        toolbar.setTitle("Media");
                        fragment = new MediaFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });
    }
    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_framelayout,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}