package com.example.giaodienapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.giaodienapplication.bai1.bai1;
import com.example.giaodienapplication.bai2.fragment_bai2;
import com.example.giaodienapplication.home.homeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout idDrawlayout;
    private Toolbar idToolbar;
    private FrameLayout idLayoutcontent;
    private NavigationView idNaviView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idDrawlayout = (DrawerLayout) findViewById(R.id.id_drawlayout);
        idToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        idLayoutcontent = (FrameLayout) findViewById(R.id.id_layoutcontent);
        idNaviView = (NavigationView) findViewById(R.id.id_naviView);
        setSupportActionBar(idToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,idDrawlayout,
                idToolbar,R.string.opennav,R.string.closenav);
        toggle.syncState();
        idNaviView = findViewById(R.id.id_naviView);
        idNaviView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.Home){
//            idDrawlayout.closeDrawer(idNaviView);
            replaceFragment(homeFragment.newInstance());
        }else if(id == R.id.bai1){
//            idDrawlayout.closeDrawer(idNaviView);
            replaceFragment(bai1.newInstance());
        }else if(id == R.id.bai2){
//            idDrawlayout.closeDrawer(idNaviView);
            replaceFragment(fragment_bai2.newInstance());
        }
        idDrawlayout.closeDrawer(idNaviView);
        return true;
    }
    public void replaceFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_layoutcontent, fragment);
        transaction.commit();
    }

}