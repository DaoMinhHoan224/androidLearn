package hoandmph27404.fpoly.testdeduanmau.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import hoandmph27404.fpoly.testdeduanmau.DAO.LoaiSachDAO;
import hoandmph27404.fpoly.testdeduanmau.DAO.SachDAO;
import hoandmph27404.fpoly.testdeduanmau.R;
import hoandmph27404.fpoly.testdeduanmau.adapter.LoaiSachAdapter;
import hoandmph27404.fpoly.testdeduanmau.adapter.LoaiSachSpinnerAdapter;
import hoandmph27404.fpoly.testdeduanmau.adapter.SachAdapter;
import hoandmph27404.fpoly.testdeduanmau.model.LoaiSach;
import hoandmph27404.fpoly.testdeduanmau.model.Sach;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SachFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SachFragment extends Fragment {
    ListView lv;
    ArrayList<Sach> lists;
    FloatingActionButton fab;
    Dialog dialog;
    EditText edMaSach, edTenSach, edGiaThue,edSoLuong;
    Spinner spinner;
    Button btnSave, btnCancel;
    static SachDAO dao;
    SachAdapter adapter;
    Sach item;
    LoaiSachSpinnerAdapter spinnerAdapter;
    ArrayList<LoaiSach> listLoaiSach;
    LoaiSachDAO loaiSachDAO;
    LoaiSach loaiSach;
    int maLoaiSach, position;

    public SachFragment() {
        // Required empty public constructor
    }

    public static SachFragment newInstance(String param1, String param2) {
        SachFragment fragment = new SachFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_sach,container,false);
        lv=v.findViewById(R.id.lvSach);
        fab=v.findViewById(R.id.fab);
        dao=new SachDAO(getActivity());
        capNhapLv();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(getActivity(),0);
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                item=lists.get(position);
                openDialog(getActivity(),1);//1 update

                return false;
            }
        });
        return v;
    }

    protected void openDialog(final Context context, final int type){
        //custom dialog
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.sach_dialog);
        edMaSach=dialog.findViewById(R.id.edMaSach);
        edTenSach=dialog.findViewById(R.id.edTenSach);
        edGiaThue=dialog.findViewById(R.id.edGiaThue);
//        edSoLuong=dialog.findViewById(R.id.edSoLuong);
        spinner=dialog.findViewById(R.id.spnLoaiSach);
        btnCancel=dialog.findViewById(R.id.btnCancelSach);
        btnSave=dialog.findViewById(R.id.btnSaveSach);
        listLoaiSach=new ArrayList<>();
        loaiSachDAO=new LoaiSachDAO(context);
        listLoaiSach=(ArrayList<LoaiSach>) loaiSachDAO.getAll();
        spinnerAdapter=new LoaiSachSpinnerAdapter(context,listLoaiSach);
        spinner.setAdapter(spinnerAdapter);

        //lay maLoaiSach
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maLoaiSach=listLoaiSach.get(position).getMaLoai();
                Toast.makeText(context, "Chon " +listLoaiSach.get(position).getTenLoai(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //kiểm tra type insert 0 hay update 1
        edMaSach.setEnabled(false);
        if (type!=0){
            edMaSach.setText(String.valueOf(item.getMaSach()));
            edTenSach.setText(item.getTenSach());
//            edSoLuong.setText(item.getSoluong());
            edGiaThue.setText(String.valueOf(item.getGiaThue()));
            for (int i=0;i<listLoaiSach.size();i++)
                if (item.getMaLoai()==(listLoaiSach.get(i).getMaLoai())){
                    position=i;
                }
            Log.i("demo","posSach" +position);
                spinner.setSelection(position);

        }
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item=new Sach();
                item.setTenSach(edTenSach.getText().toString());
//                item.setSoluong(Integer.parseInt(edSoLuong.getText().toString()));
                item.setGiaThue(Integer.parseInt(edGiaThue.getText().toString()));
                item.setMaLoai(maLoaiSach);
                if (validate()>0){
                    if (type==0){
                        //type = 0 (insert)
                        if (dao.insert(item)>0){
                            Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        //type=1 update
                        item.setMaSach(Integer.parseInt(edMaSach.getText().toString()));
                        if (dao.update(item)>0){
                            Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                    capNhapLv();
                    dialog.dismiss();
                }
            }
        });
        dialog.show();
    }

    public void xoa(final String Id){
        // sử dụng alert

        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("Delete");
        builder.setMessage("Bạn có muốn xóa không?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dao.delete(Id);
                capNhapLv();
                dialog.cancel();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        builder.show();
    }

    void capNhapLv(){
        lists=(ArrayList<Sach>) dao.getAll();
        adapter=new SachAdapter(getActivity(),this,lists);
        lv.setAdapter(adapter);
    }

    public int validate(){
        int check=1;
        if(edTenSach.getText().length()==0 || edGiaThue.getText().length()==0){
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
            check=-1;
        }
        return check;
    }
}