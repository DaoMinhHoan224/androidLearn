package com.example.b7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv_color;
    //khai báo mảng dữ liệu nguồn
    String[] color={"Xanh","Đỏ","Tím","vàng"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        lv_color=findViewById(R.id.lv_color);
        //tạo adapter
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this
                , android.R.layout.simple_list_item_1,color);
        //Gắn adapter vào listview
        lv_color.setAdapter(adapter);
    }
}