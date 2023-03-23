package com.example.lap3_2_hoanglvph27345;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lap3_2_hoanglvph27345.Adapter.AdapterNote;
import com.example.lap3_2_hoanglvph27345.DAO.NoteDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    NoteDAO noteDAO;
    Button btn_save;
    AdapterNote adapterNote;
    ArrayList<Note> listNote;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteDAO = new NoteDAO(this);
        btn_save = findViewById(R.id.btn_save);
        listView = findViewById(R.id.lv_note);
        listNote = noteDAO.selectAll();
        adapterNote = new AdapterNote(listNote);


        listView.setAdapter(adapterNote);

    }
    public void addNewNote(View view){
        EditText ed_title = findViewById(R.id.ed_title);
        EditText ed_noidung = findViewById(R.id.ed_noidung);
        EditText ed_ngaythang = findViewById(R.id.ed_ngaythang);
        Note note = new Note();
        note.setTitle(ed_title.getText().toString());
        note.setNoidung(ed_noidung.getText().toString());
        note.setNgaythang(ed_ngaythang.getText().toString());
        long res = noteDAO.insertNew(note);
        if(res > 0 ){
            listNote.clear();
            listNote.addAll(noteDAO.selectAll());
            adapterNote.notifyDataSetChanged();
            Toast.makeText(view.getContext(), "Thêm mới thành công", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(view.getContext(), "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
        }
    }


}