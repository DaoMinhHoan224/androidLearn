package com.example.fixlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.fixlistview.Adapter.AdapterVP;
import com.example.fixlistview.DAO.VatphamDAO;

public class MainActivity extends AppCompatActivity {
     AdapterVP adapterVP;
     VatphamDAO vatphamDAO;
     ListView lv_vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vatphamDAO=new VatphamDAO(this);
        vatphamDAO.open();

        adapterVP=new AdapterVP(vatphamDAO.GetAll(),vatphamDAO);
        lv_vp=findViewById(R.id.lv_dsvt);
        lv_vp.setAdapter(adapterVP);

        Button btnthem=findViewById(R.id.btn_them);
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterVP.showadd(MainActivity.this);
            }
        });
    }
}