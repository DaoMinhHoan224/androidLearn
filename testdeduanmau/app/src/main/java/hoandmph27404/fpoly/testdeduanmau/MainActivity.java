package hoandmph27404.fpoly.testdeduanmau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import hoandmph27404.fpoly.testdeduanmau.DAO.ThuThuDAO;
import hoandmph27404.fpoly.testdeduanmau.fragment.AddUserFragment;
import hoandmph27404.fpoly.testdeduanmau.fragment.ChangePassFragment;
import hoandmph27404.fpoly.testdeduanmau.fragment.DoanhThuFragment;
import hoandmph27404.fpoly.testdeduanmau.fragment.LoaiSachFragment;
import hoandmph27404.fpoly.testdeduanmau.fragment.PhieuMuonFragment;
import hoandmph27404.fpoly.testdeduanmau.fragment.SachFragment;
import hoandmph27404.fpoly.testdeduanmau.fragment.ThanhVienFragment;
import hoandmph27404.fpoly.testdeduanmau.fragment.TopFragment;
import hoandmph27404.fpoly.testdeduanmau.model.ThuThu;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer;
    Toolbar toolbar;
    View mHeaderView;
    TextView edUser;
    ThuThu thuThu;
    ThuThuDAO thuThuDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer=findViewById(R.id.drawer_layout);
        toolbar=findViewById(R.id.toolbar);
        //set toolbar thay the cho actionbar
        setSupportActionBar(toolbar);
        ActionBar ab=getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.menu);
        ab.setDisplayHomeAsUpEnabled(true);
        //dùng fragment phiếu mượn làm home
        FragmentManager manager=getSupportFragmentManager();
        PhieuMuonFragment phieuMuonFragment=new PhieuMuonFragment();
        manager.beginTransaction()
                .replace(R.id.flContent,phieuMuonFragment)
                .commit();

        NavigationView nv=findViewById(R.id.nvView);
        //show user in header
        mHeaderView=nv.getHeaderView(0);
        edUser=mHeaderView.findViewById(R.id.tvUser);
        Intent i=getIntent();
        String user=i.getStringExtra("user");
//        thuThuDAO=new ThuThuDAO(this);
//        thuThu=thuThuDAO.getID(user);
//        String username=thuThu.getHoTen();
        edUser.setText("Welcome " + user  + "!");

        //admin có quyền add user
        if (user.equalsIgnoreCase("admin")){
            nv.getMenu().findItem(R.id.sub_AddUser).setVisible(true);
        }

        nv.setNavigationItemSelectedListener((item) -> {
            FragmentManager manager1=getSupportFragmentManager();

            switch (item.getItemId()){
                case R.id.nav_PhieuMuon:
                    setTitle("Quản lý phiếu mượn");
                    PhieuMuonFragment phieuMuonFragment1=new PhieuMuonFragment();
                    manager1.beginTransaction()
                            .replace(R.id.flContent,phieuMuonFragment1)
                            .commit();
                    break;

                case R.id.nav_LoaiSach:
                    setTitle("Quản lý loại sách");
                    LoaiSachFragment loaiSachFragment=new LoaiSachFragment();
                    manager1.beginTransaction()
                            .replace(R.id.flContent,loaiSachFragment)
                            .commit();
                    break;

                case R.id.nav_Sach:
                    setTitle("Quản lý Sách");
                    SachFragment sachFragment=new SachFragment();
                    manager1.beginTransaction()
                            .replace(R.id.flContent,sachFragment)
                            .commit();
                    break;

                case R.id.nav_ThanhVien:
                    setTitle("Quản lý thành viên");
                    ThanhVienFragment thanhVienFragment=new ThanhVienFragment();
                    manager1.beginTransaction()
                            .replace(R.id.flContent,thanhVienFragment)
                            .commit();
                    break;

                case R.id.sub_Top:
                    setTitle("Top 10 sách cho thuê nhiều nhất");
                    TopFragment topFragment=new TopFragment();
                    manager1.beginTransaction()
                            .replace(R.id.flContent,topFragment)
                            .commit();
                    break;

                case R.id.sub_DoanhThu:
                    setTitle("Thống kế doanh thu");
                    DoanhThuFragment doanhThuFragment=new DoanhThuFragment();
                    manager1.beginTransaction()
                            .replace(R.id.flContent,doanhThuFragment)
                            .commit();
                    break;

                case R.id.sub_AddUser:
                    setTitle("Thêm người dùng");
                    AddUserFragment addUserFragment=new AddUserFragment();
                    manager1.beginTransaction()
                            .replace(R.id.flContent,addUserFragment)
                            .commit();
                    break;

                case R.id.sub_Pass:
                    setTitle("Thay dổi mật khẩu");
                    ChangePassFragment changePassFragment=new ChangePassFragment();
                    manager1.beginTransaction()
                            .replace(R.id.flContent,changePassFragment)
                            .commit();
                    break;

                case R.id.sub_Logout:

                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    finish();
                    break;
            }
            drawer.closeDrawers();

            return false;
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        if (id==android.R.id.home)
            drawer.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }
}