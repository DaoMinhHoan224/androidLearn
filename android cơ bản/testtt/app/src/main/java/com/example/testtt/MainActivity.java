package com.example.testtt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.testtt.Adapter.vatphamAdapter;
import com.example.testtt.DAO.vatphamDAO;
import com.example.testtt.DTO.vatPham;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    vatphamAdapter vatphamadapter;
    vatphamDAO vatphamdao;
    ArrayList<vatPham> listVP;
    vatPham currentVP;
    ListView lv_vatpham;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vatphamdao =new vatphamDAO(this);
        vatphamdao.open();

        vatphamadapter=new vatphamAdapter(vatphamdao.GetAll(),vatphamdao);
        lv_vatpham=findViewById(R.id.lv_dsvt);
        lv_vatpham.setAdapter(vatphamadapter);


        Button btn_them=findViewById(R.id.btn_them);
        btn_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vatphamadapter.showDialogAdd(MainActivity.this);
            }
        });
    }
}