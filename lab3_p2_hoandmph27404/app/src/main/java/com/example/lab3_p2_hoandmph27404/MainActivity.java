package com.example.lab3_p2_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lab3_p2_hoandmph27404.DAO.GhiChuDAO;
import com.example.lab3_p2_hoandmph27404.adapter.adapter_note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    EditText ed_title,ed_noidung,ed_ngaythang;
    GhiChuDAO ghiChuDAO;
    Button btn_save;
    com.example.lab3_p2_hoandmph27404.adapter.adapter_note adapter_note;
    ArrayList<Note> listNote;
    ListView listView;
    Note crNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_title=findViewById(R.id.ed_title);
        ed_noidung=findViewById(R.id.ed_noidung);
        ed_ngaythang=findViewById(R.id.ed_ngaythang);

        btn_save=findViewById(R.id.btn_save);

        ghiChuDAO=new GhiChuDAO(this);
        listView=findViewById(R.id.lv_note);
        listNote=ghiChuDAO.selectAll();
        adapter_note=new adapter_note(ghiChuDAO.selectAll(), ghiChuDAO);

        listView.setAdapter(adapter_note);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                crNote=listNote.get(position);
                ed_title.setText(crNote.getTieude());
                ed_noidung.setText(crNote.getNoidung());
                ed_ngaythang.setText(crNote.getNgaythang());
                return false;
            }
        });

    }

    public void addnote(View view){
        Note note=new Note();
        note.setTieude(ed_title.getText().toString());
        note.setNoidung(ed_noidung.getText().toString());
        note.setNgaythang(ed_ngaythang.getText().toString());
        long res=ghiChuDAO.insert(note);
        if (res>0){
            listNote.clear();
            listNote.addAll(ghiChuDAO.selectAll());
            adapter_note.notifyDataSetChanged();
            Log.d("zzz","Them moi thanh congnnha");
            Toast.makeText(MainActivity.this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
        }
    }


    public void updateNote(View view){
        String tieudenew=ed_title.getText().toString();
        String noidungnew=ed_noidung.getText().toString();
        String ngaythangnew=ed_ngaythang.getText().toString();

        if (crNote != null && (!crNote.getTieude().equalsIgnoreCase(tieudenew) || !crNote.getNoidung().equalsIgnoreCase(noidungnew) ||
                !crNote.getNgaythang() .equalsIgnoreCase(ngaythangnew))){

            crNote.setTieude(tieudenew);
            crNote.setNoidung(noidungnew);
            crNote.setNgaythang(ngaythangnew);

            int res=ghiChuDAO.update(crNote);
            if (res >0){
                ed_title.setText("");
                ed_noidung.setText("");
                ed_ngaythang.setText("");

                listNote.clear();
                listNote.addAll(ghiChuDAO.selectAll());
                adapter_note.notifyDataSetChanged();

                Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                crNote=null;
            }else{
                Toast.makeText(this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Không có gì để cập nhật ", Toast.LENGTH_SHORT).show();
        }
    }


}