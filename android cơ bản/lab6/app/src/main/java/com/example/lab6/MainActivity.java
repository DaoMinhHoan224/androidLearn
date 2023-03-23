package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lab6.DAO.Lab6DAO;
import com.example.lab6.DBHelper.dbhelper;
import com.example.lab6.DTO.Lab6;
import com.example.lab6.adapter.adapter_lab6;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewLT;
    ArrayList<Lab6> lab6ArrayList=new ArrayList<>();
    adapter_lab6 adapter;
    Lab6DAO lab6DAO;
    dbhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewLT = findViewById(R.id.id_recycleviewKT);

        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewLT.setLayoutManager(linearLayoutManager);
        lab6DAO = new Lab6DAO(MainActivity.this);
        lab6ArrayList=lab6DAO.getAll();

        adapter=new adapter_lab6(lab6ArrayList,lab6DAO);
        adapter.setDatalab6(lab6ArrayList);
        recyclerViewLT.setAdapter(adapter);

    }

    public void createeData() {
        lab6ArrayList.add(new Lab6(1,"Android",R.drawable.android));
        lab6ArrayList.add(new Lab6(2,"Apple", R.drawable.apple));
        lab6ArrayList.add(new Lab6(3,"Blogger", R.drawable.blogger));
        lab6ArrayList.add(new Lab6(4,"Chrome", R.drawable.chrome));
        lab6ArrayList.add(new Lab6(5,"Dell", R.drawable.dell));
        lab6ArrayList.add(new Lab6(6,"Facebook", R.drawable.facebook));
        lab6ArrayList.add(new Lab6(7,"FireFox", R.drawable.firefox));
    }
    private void  showDialogAdd(){
        final Dialog dialog=new Dialog(this, androidx.constraintlayout.widget.R.style.Theme_AppCompat_Light_Dialog_Alert);
        dialog.setContentView(R.layout.dialog_update);


        EditText ed_nameLT=dialog.findViewById(R.id.ed_nameclass);


        Button btnsave=dialog.findViewById(R.id.btn_updateclass);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lab6 lab6=new Lab6();

                lab6.setName(ed_nameLT.getText().toString());

                long res=lab6DAO.addLT(lab6);

                if (res>0){
                    lab6ArrayList.clear();
                    lab6ArrayList.addAll(lab6DAO.getAll());
                    adapter.notifyDataSetChanged();


                    Toast.makeText(MainActivity.this, "Đã thêm mới", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Không thêm được" , Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }
}