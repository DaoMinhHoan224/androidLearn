package com.example.chuyenthithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.chuyenthithu.Adapter.AdapterVP;
import com.example.chuyenthithu.DAO.VatphamDao;
import com.example.chuyenthithu.DTO.VatPham;

public class MainActivity extends AppCompatActivity {
    AdapterVP adapterVP;
    VatphamDao vatphamDao;
    ListView lv_vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vatphamDao=new VatphamDao(this);
        vatphamDao.open();

        adapterVP=new AdapterVP(vatphamDao.GetAll(),vatphamDao);
        lv_vp=findViewById(R.id.lv_dsvt);
        lv_vp.setAdapter(adapterVP);

        Button btn_them=findViewById(R.id.btn_them);
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterVP.showadd(MainActivity.this);
            }
        });
    }
}