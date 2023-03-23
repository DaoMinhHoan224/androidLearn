package hoandmph27404.fpoly.duanmau.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import hoandmph27404.fpoly.duanmau.DAO.LoaiSachDAO;
import hoandmph27404.fpoly.duanmau.DAO.ThanhVienDAO;
import hoandmph27404.fpoly.duanmau.R;
import hoandmph27404.fpoly.duanmau.adapter.LoaiSachAdapter;
import hoandmph27404.fpoly.duanmau.adapter.ThanhVienAdapter;
import hoandmph27404.fpoly.duanmau.model.LoaiSach;
import hoandmph27404.fpoly.duanmau.model.ThanhVien;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoaiSachFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoaiSachFragment extends Fragment {

    ListView lv;
    ArrayList<LoaiSach> list;
    FloatingActionButton fab;
    Dialog dialog;
    EditText edMaLoaiSach, edTenLoaiSach;
    Button btnSave, btnCancel;

    static LoaiSachDAO dao;
    LoaiSachAdapter adapter;
    LoaiSach item;

    public LoaiSachFragment() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public static LoaiSachFragment newInstance(String param1, String param2) {
        LoaiSachFragment fragment = new LoaiSachFragment();

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
        View v=inflater.inflate(R.layout.fragment_loai_sach,container,false);
        lv=v.findViewById(R.id.lvLoaiSach);
        fab=v.findViewById(R.id.fab);
        dao=new LoaiSachDAO(getActivity());
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
                item=list.get(position);
                openDialog(getActivity(),1);//1 update

                return false;
            }
        });
        return v;
    }

    protected void openDialog(final Context context, final int type){
        //custom dialog
        dialog=new Dialog(context);
        dialog.setContentView(R.layout.loai_sach_dialog);
        edMaLoaiSach=dialog.findViewById(R.id.edMaLoai);
        edTenLoaiSach=dialog.findViewById(R.id.edTenLoai);
        btnCancel=dialog.findViewById(R.id.btnCancelLoai);
        btnSave=dialog.findViewById(R.id.btnSaveLoai);

        //kiểm tra type insert 0 hay update 1
        edMaLoaiSach.setEnabled(false);
        if (type!=0){
            edMaLoaiSach.setText(String.valueOf(item.getMaLoai()));
            edTenLoaiSach.setText(item.getTenLoai());

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
                item=new LoaiSach();
                item.setTenLoai(edTenLoaiSach.getText().toString());


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
                        item.setMaLoai(Integer.parseInt(edMaLoaiSach.getText().toString()));
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
        list=(ArrayList<LoaiSach>) dao.getAll();
        adapter=new LoaiSachAdapter(getActivity(),this,list);
        lv.setAdapter(adapter);
    }

    public int validate(){
        int check=1;
        if(edTenLoaiSach.getText().length()==0){
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
            check=-1;
        }
        return check;
    }
}