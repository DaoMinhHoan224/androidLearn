package com.example.lamlaiday04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

     private DrawerLayout drawer_layout;
     private Toolbar toolbar;
     private NavigationView navi_view;
     private FrameLayout layoutcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer_layout=findViewById(R.id.draw_layout);
        toolbar=findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.opendrawer,R.string.closedrawer);
        toggle.syncState();
        navi_view=findViewById(R.id.id_naviView);
        navi_view.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.home){
            drawer_layout.closeDrawer(navi_view);
        }else if(id==R.id.bai1){
            drawer_layout.closeDrawer(navi_view);
        }else if(id==R.id.bai2){
            drawer_layout.closeDrawer(navi_view);
        }
        return true;
    }
}