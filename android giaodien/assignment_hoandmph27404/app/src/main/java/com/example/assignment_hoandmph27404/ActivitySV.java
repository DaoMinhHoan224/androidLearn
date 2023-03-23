package com.example.assignment_hoandmph27404;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment_hoandmph27404.Adapter.AdapterClass;
import com.example.assignment_hoandmph27404.Adapter.AdapterSV;
import com.example.assignment_hoandmph27404.Adapter.SpinSVAdapter;
import com.example.assignment_hoandmph27404.DAO.LOPDao;
import com.example.assignment_hoandmph27404.DAO.SVDao;
import com.example.assignment_hoandmph27404.DTO.TBclass;
import com.example.assignment_hoandmph27404.DTO.TBsv;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class ActivitySV extends AppCompatActivity {
    EditText ed_name, ed_birth, ed_sdt,ed_classsv;
    Spinner sp_class;
    ListView lv_addsv;
    ArrayList<TBsv> tbsvArrayList;
    AdapterSV adapterSV;
    SVDao svDao;
    LOPDao lopDao=new LOPDao();
    TBsv currenttbsv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quanlysinhvien_layout);

        ed_name = findViewById(R.id.ed_name);
        ed_birth = findViewById(R.id.ed_birth);
        ed_sdt = findViewById(R.id.ed_sdt);
        ed_classsv = findViewById(R.id.ed_classsv);


        svDao = new SVDao(this);
        svDao.opensv();
        tbsvArrayList =svDao.GetAll();
        adapterSV = new AdapterSV(svDao.GetAll(),svDao);
        lv_addsv = findViewById(R.id.lv_addsv);
        lv_addsv.setAdapter(adapterSV);
//làm spinner
//        LOPDao lopDao=new LOPDao(this);
//        lopDao.open();
//
//        ArrayList<TBclass> tBclassArrayList=lopDao.GetAll();
//        SpinSVAdapter adapter=new SpinSVAdapter(tBclassArrayList);
//        sp_class.setAdapter(adapter);
//
//        sp_class.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String text=adapter.getItemViewType(position).toString();
//                Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
//
//            }

//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        lv_addsv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                currenttbsv = tbsvArrayList.get(position);
                ed_classsv.setText((currenttbsv.getLop()));
                ed_name.setText(currenttbsv.getTensv());
                ed_birth.setText(currenttbsv.getNgaysinh());
                ed_sdt.setText(currenttbsv.getSdt());

                return false;
            }
        });



    }



    public void add(View view) {
        TBsv tBsv = new TBsv();
        tBsv.setLop(ed_classsv.getText().toString());
        tBsv.setTensv(ed_name.getText().toString());
        tBsv.setNgaysinh(ed_birth.getText().toString());
        tBsv.setSdt(ed_sdt.getText().toString());

//        TBclass objtbclass=(TBclass)sp_class.getSelectedItem();
//        currenttbsv.setId_cl(objtbclass.getId_cl());

        long kq = svDao.addSV(tBsv);

        if (kq > 0) {
            tbsvArrayList.clear();
            tbsvArrayList.addAll(svDao.GetAll());
            adapterSV.notifyDataSetChanged();

            Toast.makeText(this, "Thêm mới thành công", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Thêm mới thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View view) {
        String class_new=ed_classsv.getText().toString();
        String name_new = ed_name.getText().toString();
        String birth_new = ed_birth.getText().toString();
        String sdt_new = ed_sdt.getText().toString();

//        ArrayList<TBclass> tBclassArrayList=lopDao.GetAll();
//        SpinSVAdapter adapterobjsv=new SpinSVAdapter(tBclassArrayList);
//        sp_class.setAdapter(adapterobjsv);

//        for(int j=0;j<tBclassArrayList.size();j++){
//            TBclass tmp=tBclassArrayList.get(j);
//            if(tmp.getId_cl()==currenttbsv.getId_cl()){
//                sp_class.setSelection(j);
//                sp_class.setSelected(true);
//            }
//            }
//        TBclass objtbclass=(TBclass) sp_class.getSelectedItem();
//        currenttbsv.setId_cl(objtbclass.getId_cl());

        if (currenttbsv != null && (!currenttbsv.getLop().equalsIgnoreCase(class_new)||!currenttbsv.getTensv().equalsIgnoreCase(name_new) ||
                !currenttbsv.getNgaysinh().equalsIgnoreCase(birth_new) ||
                !currenttbsv.getSdt().equalsIgnoreCase(sdt_new))) {

            currenttbsv.setLop(class_new);
            currenttbsv.setTensv(name_new);
            currenttbsv.setNgaysinh(birth_new);
            currenttbsv.setSdt(sdt_new);

            int res = svDao.updateSV(currenttbsv);
            if (res > 0) {
                ed_classsv.setText("");
                ed_name.setText("");
                ed_birth.setText("");
                ed_sdt.setText("");

                tbsvArrayList.clear();
                tbsvArrayList.addAll(svDao.GetAll());
                adapterSV.notifyDataSetChanged();
                Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                currenttbsv=null;
            } else {
                Toast.makeText(this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Không có gì để cập nhật", Toast.LENGTH_SHORT).show();
        }
    }

    public void eventCall(View view){

            TextView tv_sdt=findViewById(R.id.tv_sdt);
            String call=tv_sdt.getText().toString();
            Intent ii=new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +call));
            startActivity(ii);

}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        svDao.closesv();
    }
}
