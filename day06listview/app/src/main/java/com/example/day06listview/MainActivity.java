package com.example.day06listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.day06listview.adapter.adapter_view;
import com.example.day06listview.object.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_products;
    ArrayList<User>productsArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        lv_products=findViewById(R.id.id_listview);
        adapter_view adapter=new adapter_view(productsArrayList);
        lv_products.setAdapter(adapter);
    }

    public ArrayList<User> getData(){
        productsArrayList=new ArrayList<>();
        productsArrayList.add(new User("Hancock",18,R.drawable.img));
        productsArrayList.add(new User("Shank",18,R.drawable.img));
        return productsArrayList;
    }
}