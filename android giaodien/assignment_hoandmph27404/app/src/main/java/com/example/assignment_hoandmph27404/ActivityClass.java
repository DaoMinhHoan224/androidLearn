package com.example.assignment_hoandmph27404;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_hoandmph27404.Adapter.AdapterClass;
import com.example.assignment_hoandmph27404.DAO.LOPDao;
import com.example.assignment_hoandmph27404.DTO.TBclass;

import java.util.ArrayList;

public class ActivityClass extends AppCompatActivity {
    LayoutInflater inflater;
    AlertDialog dialog;
    Button btnquanlysv, btnxem, btnsave, btnadd;
    EditText ed_idclass, ed_nameclass;
    AdapterClass adapterclass;
    LOPDao lopdao;
    TBclass currenTBclass = null;
    ArrayList<TBclass> tbclassArrayList;
    ListView lv_addclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hienthidulieulop_activity);

        lopdao = new LOPDao(this);
        lopdao.open();
        tbclassArrayList = new ArrayList<>();
        adapterclass = new AdapterClass(lopdao.GetAll(), lopdao);
//        btnadd = findViewById(R.id.btn_add);
        lv_addclass = findViewById(R.id.lv_addclass);

        lv_addclass.setAdapter(adapterclass);
//        btnadd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                adapterclass.showDialogAdd(ActivityClass.this);
//            }
//        });
    }
}
