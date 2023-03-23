package com.example.testphatnua;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.testphatnua.Adapter.danhbaAdapter;
import com.example.testphatnua.DAO.danhbaDAO;
import com.example.testphatnua.DTO.danhBa;
import com.example.testphatnua.SQLite.createDanhba;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText ed_id,ed_hoten,ed_sdt,ed_ghichu;
    danhbaAdapter danhbaadapter;
    danhbaDAO danhbadao;
    danhBa danhba;
    createDanhba createdanhba;
    danhBa currendanhba;
    ArrayList<danhBa> danhBaArrayList;
    ListView lv_tbdanhba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_hoten=findViewById(R.id.ed_name);
        ed_sdt=findViewById(R.id.ed_phone);
        ed_ghichu=findViewById(R.id.ed_note);

        danhbadao=new danhbaDAO(this);
        danhbadao.open();

        danhBaArrayList=new ArrayList<>();
        danhbaadapter=new danhbaAdapter(danhBaArrayList);
        lv_tbdanhba.setAdapter(danhbaadapter);
        lv_tbdanhba=findViewById(R.id.lv_tb_danhba);
        lv_tbdanhba.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                currendanhba=danhBaArrayList.get(position);
                ed_hoten.setText(currendanhba.getHoten());
                ed_sdt.setText(currendanhba.getSdt());
                ed_ghichu.setText(currendanhba.getGhichu());
                return false;
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        danhbadao.close();
    }
    public void add(View view){
        danhBa danhbA=new danhBa();
        danhbA.setHoten(ed_hoten.getText().toString());
        danhbA.setSdt(ed_sdt.getText().toString());
        danhbA.setGhichu(ed_ghichu.getText().toString());

        long res=danhbadao.addNew(danhbA);
        if (res>0){
            danhBaArrayList.clear();
            danhBaArrayList.addAll(danhbadao.GetAll());
            danhbaadapter.notifyDataSetChanged();
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }
    public void update(View view){
        String hoten_new=ed_hoten.getText().toString();
        String sdt_new=ed_sdt.getText().toString();
        String ghichu_new=ed_ghichu.getText().toString();

        if (currendanhba!=null &&(!currendanhba.getHoten().equalsIgnoreCase(hoten_new) || !currendanhba.getSdt().equalsIgnoreCase(sdt_new)
        || !currendanhba.getGhichu().equalsIgnoreCase(ghichu_new))){

            currendanhba.setHoten(hoten_new);
            currendanhba.setSdt(sdt_new);
            currendanhba.setGhichu(ghichu_new);

            int res=danhbadao.update(danhba);
            if(res>0){
                ed_hoten.setText("");
                ed_sdt.setText("");
                ed_ghichu.setText("");

                danhBaArrayList.clear();
                danhBaArrayList.addAll(danhbadao.GetAll());
                danhbaadapter.notifyDataSetChanged();
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
    }
    public void delete(){
         if(currendanhba!=null){
             int res=danhbadao.delete(danhba);
             if (res > 0){
                 danhBaArrayList.clear();
                 danhBaArrayList.addAll(danhbadao.GetAll());
                 danhbaadapter.notifyDataSetChanged();
                 ed_hoten.setText("");
                 ed_sdt.setText("");
                 ed_ghichu.setText("");
                 Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
             }else{
                 Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
             }
             
         }else{
             Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
         }
    }
}