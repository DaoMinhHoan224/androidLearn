    package com.example.assignment_hoandmph27404;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.assignment_hoandmph27404.Adapter.AdapterClass;
import com.example.assignment_hoandmph27404.DAO.LOPDao;
import com.example.assignment_hoandmph27404.DTO.TBclass;

import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {
        public View layout_dialog_add;
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
            setContentView(R.layout.activity_main);

//lưu Lớp vào bảng
            lopdao = new LOPDao(this);
            lopdao.open();
            tbclassArrayList = new ArrayList<>();
            adapterclass = new AdapterClass(lopdao.GetAll(), lopdao);
            btnadd = findViewById(R.id.btn_add);
//            lv_addclass = findViewById(R.id.lv_addclass);
//
//            lv_addclass.setAdapter(adapterclass);
            btnadd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterclass.showDialogAdd(MainActivity.this);
                }
            });
//hiển thị sang activity sinh vien

            btnquanlysv = findViewById(R.id.btn_quanlysv);
            btnquanlysv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intend = new Intent(getBaseContext(), ActivitySV.class);
                    startActivity(intend);
                }
            });

//hiển thị sang listview activity Lop
            btnxem = findViewById(R.id.btn_xem);
            btnxem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(), ActivityClass.class);
                    startActivity(intent);
                }
            });
        }

        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.option_menu,menu);

            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item){
             switch (item.getItemId()){
                 case R.id.menu_gioithieu:
                     Intent intentt=new Intent(getBaseContext(),webview_activity.class);
                     startActivity(intentt);
             }
             return super.onOptionsItemSelected(item);
        }
    }