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

import hoandmph27404.fpoly.duanmau.DAO.ThanhVienDAO;
import hoandmph27404.fpoly.duanmau.R;
import hoandmph27404.fpoly.duanmau.adapter.ThanhVienAdapter;
import hoandmph27404.fpoly.duanmau.model.ThanhVien;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThanhVienFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThanhVienFragment extends Fragment {

    ListView lv;
    ArrayList<ThanhVien> list;
    FloatingActionButton fab;
    Dialog dialog;
    EditText edMaTV, edTenTv, edNamSinh,edGioitinh;
    Button btnSave, btnCancel;

    static ThanhVienDAO dao;
    ThanhVienAdapter adapter;
    ThanhVien item;

    public ThanhVienFragment() {
        // Required empty public constructor
    }


    public static ThanhVienFragment newInstance() {
        ThanhVienFragment fragment = new ThanhVienFragment();

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
        View v=inflater.inflate(R.layout.fragment_thanh_vien,container,false);
        lv=v.findViewById(R.id.lvThanhVien);
        fab=v.findViewById(R.id.fab);
        dao=new ThanhVienDAO(getActivity());
        capNhapLv();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog(getActivity(),0);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item=list.get(position);
                AlertDialog.Builder builder=new AlertDialog.Builder(parent.getContext());
                builder.setTitle("Thông tin người dùng");
                builder.setMessage("Name: " + item.getHoTen() + "\nNăm sinh: " + item.getNamSinh()  + "\nGiới tính: " + item.getGioiTinh());
                AlertDialog dialog=builder.create();
                dialog.show();
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
        dialog.setContentView(R.layout.thanh_vien_dialog);
        edMaTV=dialog.findViewById(R.id.edMaTV);
        edTenTv=dialog.findViewById(R.id.edTenTV);
        edNamSinh=dialog.findViewById(R.id.edNamSinh);
        edGioitinh=dialog.findViewById(R.id.edGioiTinh);
        btnCancel=dialog.findViewById(R.id.btnCancelTV);
        btnSave=dialog.findViewById(R.id.btnSaveTV);

        //kiểm tra type insert 0 hay update 1
        edMaTV.setEnabled(false);
        if (type!=0){
            edMaTV.setText(String.valueOf(item.getMaTV()));
            edTenTv.setText(item.getHoTen());
            edNamSinh.setText(item.getNamSinh());
            edGioitinh.setText(item.getGioiTinh());
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
                item=new ThanhVien();
                item.setHoTen(edTenTv.getText().toString());
                item.setNamSinh(edNamSinh.getText().toString());
                item.setGioiTinh(edGioitinh.getText().toString());

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
                        item.setMaTV(Integer.parseInt(edMaTV.getText().toString()));
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
        list=(ArrayList<ThanhVien>) dao.getAll();
        adapter=new ThanhVienAdapter(getActivity(),this,list);
        lv.setAdapter(adapter);
    }

    public int validate(){
        int check=1;
        if(edTenTv.getText().length()==0 || edNamSinh.getText().length()==0 || edGioitinh.getText().length()==0){
            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông", Toast.LENGTH_SHORT).show();
            check=-1;
        }
        return check;
    }
}