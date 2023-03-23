package com.example.thithu2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.thithu2.Adapter.AdapterVP;
import com.example.thithu2.DAO.VatphamDAO;

public class MainActivity extends AppCompatActivity {
     VatphamDAO vatphamDAO;
     AdapterVP adapterVP;
     ListView lvvp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    vatphamDAO=new VatphamDAO(this);
    vatphamDAO.open();

    adapterVP=new AdapterVP(vatphamDAO.GetAll(), vatphamDAO);
    lvvp=findViewById(R.id.lv_vp);
    lvvp.setAdapter(adapterVP);

    Button btnthem=findViewById(R.id.btnthem);
    btnthem.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            adapterVP.showadd(MainActivity.this);
        }
    });

    }
}