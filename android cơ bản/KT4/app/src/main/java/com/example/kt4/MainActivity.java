package com.example.kt4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<RecyObject> arrayList = new ArrayList<>();
    private RecyclerViewAdapter adapter;
    private RecyclerViewAdapter2 adapter2;
    private RecyclerView idRecyclerview1;
    private RecyclerView idRecyclerview2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idRecyclerview1 = (RecyclerView) findViewById(R.id.id_recyclerview1);

        CreateData();
        adapter = new RecyclerViewAdapter(this);
        adapter.setData(arrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        idRecyclerview1.setLayoutManager(layoutManager);
        idRecyclerview1.setAdapter(adapter);
        recy2();
    }

    public void CreateData(){
        arrayList = new ArrayList<>();
        arrayList.add(new RecyObject("android", R.drawable.android));
        arrayList.add(new RecyObject("apple", R.drawable.apple));
        arrayList.add(new RecyObject("blogger", R.drawable.blogger));
        arrayList.add(new RecyObject("chrome", R.drawable.chrome));
        arrayList.add(new RecyObject("firefox", R.drawable.firefox));
        arrayList.add(new RecyObject("dell", R.drawable.dell));
        arrayList.add(new RecyObject("facebook", R.drawable.facebook));

    }
    public void recy2(){
        idRecyclerview2 = (RecyclerView) findViewById(R.id.id_recyclerview2);
        CreateData();
        adapter2 = new RecyclerViewAdapter2(this);
        adapter2.setData2(arrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        idRecyclerview2.setLayoutManager(layoutManager);
        idRecyclerview2.setAdapter(adapter2);
    }
}