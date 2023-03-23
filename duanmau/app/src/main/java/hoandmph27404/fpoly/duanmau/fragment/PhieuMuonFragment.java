package hoandmph27404.fpoly.duanmau.fragment;

import static java.time.LocalDateTime.now;

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import hoandmph27404.fpoly.duanmau.DAO.LoaiSachDAO;
import hoandmph27404.fpoly.duanmau.DAO.PhieuMuonDAO;
import hoandmph27404.fpoly.duanmau.DAO.SachDAO;
import hoandmph27404.fpoly.duanmau.DAO.ThanhVienDAO;
import hoandmph27404.fpoly.duanmau.R;
import hoandmph27404.fpoly.duanmau.adapter.LoaiSachAdapter;
import hoandmph27404.fpoly.duanmau.adapter.PhieuMuonAdapter;
import hoandmph27404.fpoly.duanmau.adapter.SachSpinnerAdapter;
import hoandmph27404.fpoly.duanmau.adapter.ThanhVienSpinnerAdapter;
import hoandmph27404.fpoly.duanmau.model.LoaiSach;
import hoandmph27404.fpoly.duanmau.model.PhieuMuon;
import hoandmph27404.fpoly.duanmau.model.Sach;
import hoandmph27404.fpoly.duanmau.model.ThanhVien;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhieuMuonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhieuMuonFragment extends Fragment {
    ListView lv;
    ArrayList<PhieuMuon> list;
    FloatingActionButton fab;
    Dialog dialog;
    EditText edMaPM;
    Spinner spTV, spSach;
    TextView tvNgay, tvTienThue;
    CheckBox chkTraSach;
    Button btnSave, btnCancel;
    static PhieuMuonDAO dao;
    PhieuMuonAdapter adapter;
    PhieuMuon item;
    ThanhVienSpinnerAdapter thanhVienSpinnerAdapter;
    ArrayList<ThanhVien> listThanhVien;
    ThanhVienDAO thanhVienDAO;
    ThanhVien thanhVien;
    int maThanhVien;
    SachSpinnerAdapter sachSpinnerAdapter;
    ArrayList<Sach> listSach;
    SachDAO sachDAO;
    Sach sach;
    int maSach, tienThue;
    int positionTV, positionSach;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    public PhieuMuonFragment() {
        // Required empty public constructor
    }


    public static PhieuMuonFragment newInstance() {
        PhieuMuonFragment fragment = new PhieuMuonFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_phieu_muon,container,false);
        lv=v.findViewById(R.id.lvPhieuMuon);
        fab=v.findViewById(R.id.fab);
        dao=new PhieuMuonDAO(getActivity());
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
        dialog.setContentView(R.layout.phieu_muon_dialog);
        edMaPM=dialog.findViewById(R.id.edMaPM);
        spTV=dialog.findViewById(R.id.spMaTV);
        spSach=dialog.findViewById(R.id.spMaSach);
        tvNgay=dialog.findViewById(R.id.tvNgay);
        tvTienThue=dialog.findViewById(R.id.tvTienThue);
        chkTraSach=dialog.findViewById(R.id.chkTraSach);
        btnCancel=dialog.findViewById(R.id.btnCancelPM);
        btnSave=dialog.findViewById(R.id.btnSavePM);

        //ngay thue
        tvNgay.setText("Ngày thuê: " +sdf.format(new Date()));

        thanhVienDAO=new ThanhVienDAO(context);
        listThanhVien=new ArrayList<>();
        listThanhVien=(ArrayList<ThanhVien>) thanhVienDAO.getAll();
        thanhVienSpinnerAdapter=new ThanhVienSpinnerAdapter(context,listThanhVien);
        spTV.setAdapter(thanhVienSpinnerAdapter);

        //lay maloaiSach
        spTV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maThanhVien=listThanhVien.get(position).getMaTV();
                Toast.makeText(context, "Chon "+listThanhVien.get(position).getHoTen(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sachDAO=new SachDAO(context);
        listSach=new ArrayList<>();
        listSach=(ArrayList<Sach>)sachDAO.getAll();
        sachSpinnerAdapter=new SachSpinnerAdapter(context,listSach);
        spSach.setAdapter(sachSpinnerAdapter);
        spSach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                maSach=listSach.get(position).getMaSach();
                tienThue=listSach.get(position).getGiaThue();
                tvTienThue.setText("Tiền thuê: " + tienThue);
                Toast.makeText(context, "Chon "+listSach.get(position).getTenSach(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //kiểm tra type insert 0 hay update 1
        edMaPM.setEnabled(false);
        if (type!=0) {
            edMaPM.setText(String.valueOf(item.getMaPM()));
            for (int i = 0; i < listThanhVien.size(); i++)
                if (item.getMaTV() == (listThanhVien.get(i).getMaTV())) {
                    positionTV = i;
                }

            spTV.setSelection(positionTV);
            for (int i = 0; i < listSach.size(); i++)
                if (item.getMaSach() == (listSach.get(i).getMaSach())) {
                    positionSach = i;
                }
            spSach.setSelection(positionSach);

            tvNgay.setText("Ngày thuê: " + sdf.format(item.getNgay()));
            tvTienThue.setText("Tiền thuê: " + item.getTienThue());
            if (item.getTraSach() == 1) {
                chkTraSach.setChecked(true);
            } else {
                chkTraSach.setChecked(false);
            }
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
                item=new PhieuMuon();
                item.setMaSach(maSach);
                item.setMaTV(maThanhVien);
                item.setNgay(new Date());
                item.setTienThue(tienThue);
                if (chkTraSach.isChecked()){
                    item.setTraSach(1);
                }else{
                    item.setTraSach(0);
                }

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
                        item.setMaPM(Integer.parseInt(edMaPM.getText().toString()));
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
        list=(ArrayList<PhieuMuon>) dao.getAll();
        adapter=new PhieuMuonAdapter(getActivity(),this,list);
        lv.setAdapter(adapter);
    }

    public int validate(){
        int check=1;
//        if(edTenLoaiSach.getText().length()==0){
//            Toast.makeText(getContext(), "Bạn phải nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
//            check=-1;
//        }
        return check;
    }
}