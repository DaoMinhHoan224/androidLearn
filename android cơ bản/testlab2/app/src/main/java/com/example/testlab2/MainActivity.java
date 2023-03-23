package com.example.testlab2;

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

import com.example.testlab2.bai1.Bai1Fragment;
import com.example.testlab2.home.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout layout_draw;
    private Toolbar layout_toolbar;
    private FrameLayout layout_frame;
    private NavigationView layout_navi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       layout_draw=findViewById(R.id.draw_layout);
       layout_toolbar=findViewById(R.id.id_toolbar);
       setSupportActionBar(layout_toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,layout_draw,layout_toolbar,R.string.opendrawer,R.string.closedrawer);
       toggle.syncState();
       layout_navi=findViewById(R.id.id_navview);
       layout_navi.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.home){
           replaceFragment(HomeFragment.newInstance());
        }else if (id==R.id.bai1){
           replaceFragment(Bai1Fragment.newInstance());
        }
        layout_draw.closeDrawer(layout_navi);
        return true;
    }

    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_framelayout,fragment);
        transaction.commit();
    }
}