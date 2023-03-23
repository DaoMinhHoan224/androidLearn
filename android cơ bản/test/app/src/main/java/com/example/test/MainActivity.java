package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_product;
    ArrayList<productstest> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       lv_product=findViewById(R.id.lv_product);


        list=new ArrayList<productstest>();
        list.add(new productstest(1,"SP1",100,R.drawable.aa));
        list.add(new productstest(1,"SP1",100,R.drawable.aa));
        list.add(new productstest(1,"SP1",100,R.drawable.aa));
        list.add(new productstest(1,"SP1",100,R.drawable.aa));
        list.add(new productstest(1,"SP1",100,R.drawable.aa));

        productstestadapter adapter=new productstestadapter((list));
        lv_product.setAdapter(adapter);

    }
}