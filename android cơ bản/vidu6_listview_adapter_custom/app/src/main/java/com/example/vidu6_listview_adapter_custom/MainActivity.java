package com.example.vidu6_listview_adapter_custom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_product;
    ArrayList<products> listproducts;// khai báo dssp
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ánh xạ view
        lv_product=findViewById(R.id.lv_product);

        //tạo ds đối tượng sản phẩm
        listproducts =new ArrayList<products>();
        listproducts.add(new products(1,"SP1",100,R.drawable.abc) );
        listproducts.add(new products(2,"SP2",200,R.drawable.abc) );
        listproducts.add(new products(3,"SP3",300,R.drawable.abc) );
        listproducts.add(new products(4,"SP4",400,R.drawable.abc) );
        listproducts.add(new products(5,"SP5",500,R.drawable.abc) );

        //tạo adapter
        productsadapter adapter=new productsadapter(listproducts);
        //gắn adapter cho listview
        lv_product.setAdapter(adapter);
    }
}