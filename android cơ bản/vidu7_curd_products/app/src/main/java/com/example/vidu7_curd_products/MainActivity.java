package com.example.vidu7_curd_products;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vidu7_curd_products.DAO.CatDAO;
import com.example.vidu7_curd_products.DTO.Cat;
import com.example.vidu7_curd_products.dBhELPER.mydbhelper;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String TAG="zzzzzzzz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // thử nghiệm Mydbhelper
////        mydbhelper dbhelper=new mydbhelper(this);
////        dbhelper.getWritableDatabase();// phải get write thì mới tạo được
//
//        //thử nghiệm DAO
//        CatDAO catDAO=new CatDAO(this);
//        ArrayList<Cat> listCat=catDAO.selectAll();
//
//        //ghi log để kiểm tra kết quả lấy dữ liệu
//        Log.d(TAG,"onCreate:Số lượng dòng=" + listCat.size());
//
//        //in danh sách tên thì dùng for
//        for(int i=0;i<listCat.size();i++){
//            Cat objCat= listCat.get(i);
//            Log.d(TAG,"onCreate:Tên cat= " + objCat.getName());
//        }
        Button btnCat=findViewById(R.id.btnCat);
        btnCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),categoryactivity.class);
                startActivity(i);
            }
        });

        Button btncat2=findViewById(R.id.BTNCAT2);
        btncat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(),categoryactivity.class);
                startActivity(i);
            }
        });
    }
}