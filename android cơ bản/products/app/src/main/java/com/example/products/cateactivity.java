package com.example.products;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.products.DAO.Catdao2;
import com.example.products.DTO.Cat2;
import com.example.products.adapter.adabter;

import java.util.ArrayList;


public class cateactivity extends AppCompatActivity {
    ListView lv_cat;
    adabter adapter;
    Catdao2 dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cate);

       lv_cat=findViewById(R.id.lv_cat);
       dao=new Catdao2(this);
        Log.d("zzzzzzzz","onCreate:So luong cate= " +dao.selectAll().size());

        Cat2 objcat=new Cat2();
        objcat.setName("Hoàn dzai");
        long new_id=dao.insert(objcat);
        Log.d("zzzzzzzz","onCreate:id them moi"+new_id);

        adapter=new adabter((ArrayList<Cat2>) dao.selectAll());
        lv_cat.setAdapter(adapter);
    }
}
