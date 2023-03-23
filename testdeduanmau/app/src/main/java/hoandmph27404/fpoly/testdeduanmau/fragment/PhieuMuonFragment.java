package hoandmph27404.fpoly.testdeduanmau.fragment;

import static java.time.LocalDateTime.now;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
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
import java.util.List;
import java.util.Objects;

import hoandmph27404.fpoly.testdeduanmau.DAO.LoaiSachDAO;
import hoandmph27404.fpoly.testdeduanmau.DAO.PhieuMuonDAO;
import hoandmph27404.fpoly.testdeduanmau.DAO.SachDAO;
import hoandmph27404.fpoly.testdeduanmau.DAO.ThanhVienDAO;
import hoandmph27404.fpoly.testdeduanmau.MainActivity;
import hoandmph27404.fpoly.testdeduanmau.R;
import hoandmph27404.fpoly.testdeduanmau.adapter.LoaiSachAdapter;
import hoandmph27404.fpoly.testdeduanmau.adapter.PhieuMuonAdapter;
import hoandmph27404.fpoly.testdeduanmau.adapter.SachSpinnerAdapter;
import hoandmph27404.fpoly.testdeduanmau.adapter.ThanhVienSpinnerAdapter;
import hoandmph27404.fpoly.testdeduanmau.database.DbHelper;
import hoandmph27404.fpoly.testdeduanmau.model.LoaiSach;
import hoandmph27404.fpoly.testdeduanmau.model.PhieuMuon;
import hoandmph27404.fpoly.testdeduanmau.model.Sach;
import hoandmph27404.fpoly.testdeduanmau.model.ThanhVien;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PhieuMuonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhieuMuonFragment extends Fragment {
    ListView lv;
    ArrayList<PhieuMuon> list;
    ArrayList<PhieuMuon> arrayListpm;
    FloatingActionButton fab;
    Dialog dialog;
    EditText edMaPM,edSearch,edTieude;
    Spinner spTV, spSach;
    TextView tvNgay, tvTienThue,tvGio;
    CheckBox chkTraSach;
    Button btnSave, btnCancel;
    static PhieuMuonDAO dao;
    PhieuMuonAdapter adapter;
    PhieuMuon item;
    ThanhVienSpinnerAdapter thanhVienSpinnerAdapter;
    ArrayList<ThanhVien> listThanhVien;
    ThanhVienDAO thanhVienDAO;
    ThanhVien thanhVien;
    DbHelper dbHelper;
    int maThanhVien;
    SachSpinnerAdapter sachSpinnerAdapter;
    ArrayList<Sach> listSach;
    SachDAO sachDAO;
    Sach sach;
    String tieude;
    int maSach, tienThue;
    int positionTV, positionSach;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat stime=new SimpleDateFormat("HH:mm:ss");
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
        edSearch=v.findViewById(R.id.edsearch);
        dao=new PhieuMuonDAO(getActivity());
        capNhapLv();
        initList();
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
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search(s.toString());
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
        tvGio=dialog.findViewById(R.id.tvGio);
        tvTienThue=dialog.findViewById(R.id.tvTienThue);
        chkTraSach=dialog.findViewById(R.id.chkTraSach);
        btnCancel=dialog.findViewById(R.id.btnCancelPM);
        btnSave=dialog.findViewById(R.id.btnSavePM);


        //ngay thue
        tvNgay.setText("Ngày thuê: " +sdf.format(new Date()));
        tvGio.setText("Giờ thuê: " +stime.format(new Date()));

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
            tvGio.setText("Giờ thuê: " + stime.format(item.getGiomuahang()));
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
                item.setGiomuahang(new Date());
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

    private void search(String text){


        ArrayList<PhieuMuon> fillteredList=new ArrayList<>();
        for (PhieuMuon item: list){
            if (item.getTieude().toLowerCase().contains(text.toLowerCase())){
                fillteredList.add(item);

                arrayListpm.add(item);
            }
        }
        adapter.filterList(fillteredList);
    }

    public void initList(){

        list=(ArrayList<PhieuMuon>) dao.getAll();
        adapter=new PhieuMuonAdapter(getActivity(),this,list);
        lv.setAdapter(adapter);
    }
}