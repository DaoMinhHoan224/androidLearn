package com.example.vidu7_curd_products;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.vidu7_curd_products.Adapter.CategoryAdapter;
import com.example.vidu7_curd_products.Adapter.cateadapter;
import com.example.vidu7_curd_products.DAO.CatDAO;
import com.example.vidu7_curd_products.DAO.CatDao2;
import com.example.vidu7_curd_products.DTO.Cat;
import com.example.vidu7_curd_products.DTO.Cat2;

import java.util.ArrayList;

public class categoryactivity extends AppCompatActivity {

    ListView lv_cat;
    cateadapter adapter;
    CatDao2 dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

//        lv_cat=findViewById(R.id.lv_cat);
//        dao=new CatDAO(this);
//        Log.d("zzzzzzz","onCreate:Số lượng dòng category= " + dao.selectAll().size()   );
//
//        //thử nghiệm DAO thêm mới
//        Cat objCat=new Cat();
//        objCat.setName("Dofng thêm mới");
//        long new_id=dao.insertRow(objCat);
//        Log.d("zzzzzzzz","onCreate:ID them mooi" + new_id);
//
//
//
//
//        //tạo adapter
//        adapter=new CategoryAdapter(dao.selectAll());
//        //gắn vào listview
//        lv_cat.setAdapter(adapter);

        lv_cat=findViewById(R.id.lv_cat);
        dao=new CatDao2(this);
        Log.d("zzzzzzzz","onCreate:Số lượng category= " +dao.selectAll().size());

        Cat2 objcat=new Cat2();
        objcat.setName("Hoàn dzai");
        long new_id=dao.insert(objcat);
        Log.d("zzzzzzzz","onCreate:id them moi"+ new_id);

        adapter=new cateadapter((ArrayList<Cat2>) dao.selectAll());
        lv_cat.setAdapter(adapter);
    }
}