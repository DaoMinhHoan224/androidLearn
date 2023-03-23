package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.assignment.GioiThieu.GioiThieuFragment;
import com.example.assignment.KhoangChi.KchiFragment;
import com.example.assignment.KhoangThu.KthuFragment;
import com.example.assignment.ThongKe.TkeFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawerLayout=findViewById(R.id.draw_layoutasm);
        toolbar=findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opendrawer,R.string.closedrawer);
        toggle.syncState();
        navigationView=findViewById(R.id.id_naviView);
        navigationView.setNavigationItemSelectedListener(this);
        replacFragment(KthuFragment.newInstance());

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.id_khoangthu) {
           //hiển thị màn hình khoản thu
            replacFragment(KthuFragment.newInstance());
        } else if (id == R.id.id_khoangchi) {
            //hiển thị màn hình khoản chi
            replacFragment(KchiFragment.newInstance());

        } else if (id == R.id.id_thongke) {
            //hiển thị màn hình thống kê
            replacFragment(TkeFragment.newInstance());

        } else if (id == R.id.id_gioithieu) {
            //hiển thị màn hình giới thiệu
            replacFragment(GioiThieuFragment.newInstance());

        } else if (id == R.id.id_thoat) {
           //thoát
            AlertDialog.Builder builder=new  AlertDialog.Builder(this);
            builder.setTitle("Bạn có muốn thoát? ");
            builder.setMessage("Có chắc chắn muốn thoát này? ");

            builder.setPositiveButton("Đồng ý thoát ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    finish();
                }
            });
            builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            AlertDialog dialog=builder.create();
            dialog.show();
        }
        drawerLayout.closeDrawer(navigationView);
        return true;
    }

    public void replacFragment(Fragment fragment){
        FragmentTransaction  transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.id_layoutcontentFrame,fragment);
        transaction.commit();
    }
}