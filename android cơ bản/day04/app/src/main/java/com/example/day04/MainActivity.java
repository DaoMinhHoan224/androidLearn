package com.example.day04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.day04.bai1.Bai1Fragment;
import com.example.day04.bai2.Bai2Fragment;
import com.example.day04.bai3.Bai3Fragment;
import com.example.day04.bai4.Bai4Fragment;
import com.example.day04.bai5.RecyclerViewFragment;
import com.example.day04.bai6.Context_popup_MenuFragment;
import com.example.day04.bai7.DialogDemoFragment;
import com.example.day04.home.HomeFragment;
import com.example.day04.lab4.Lab4Fragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout draw_layout;
    private Toolbar toolbar;
    private NavigationView navi_view;
    private FrameLayout layoutcontent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        draw_layout=findViewById(R.id.draw_layout);
        toolbar=findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);//add toolbar vào ứng dụng
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,draw_layout,toolbar,R.string.opendrawer,R.string.closedrawer);
        toggle.syncState();//tạo thanh 3 gạch trên toolbar
        navi_view=findViewById(R.id.id_naviView);
        //set bộ lắng nghe khi click vào item menu
        navi_view.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.Home){
            // Hiển thị màn hình home

           replaceFragment(HomeFragment.newInstance());
        }else if (id==R.id.bai1) {
            //hiển thị màn hình bài 1
            replaceFragment(Bai1Fragment.newInstance());
        }else if (id==R.id.bai2){
            //hiển thị màn hình bài 2

            replaceFragment(Bai2Fragment.newInstance());
        }else if (id==R.id.bai3){
            //hiển thị màn hình bài 3

            replaceFragment(Bai3Fragment.newInstance());
        }else if (id==R.id.bai4){
            replaceFragment(Bai4Fragment.newInstance());
        }else if (id==R.id.bai5){
            replaceFragment(RecyclerViewFragment.newInstance());
        }else if(id==R.id.lab4){
            replaceFragment(Lab4Fragment.newInstance());
        }else if(id==R.id.bai6){
            replaceFragment(Context_popup_MenuFragment.newInstance());
        }else if(id==R.id.bai7){
            replaceFragment(DialogDemoFragment.newInstance());
        }
        draw_layout.closeDrawer(navi_view);
        return true;
    }

    public void replaceFragment(Fragment fragment){
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_layoutcontend,fragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.setting:
                Toast.makeText(this, "Belo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.account:
                Toast.makeText(this, "Account", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}