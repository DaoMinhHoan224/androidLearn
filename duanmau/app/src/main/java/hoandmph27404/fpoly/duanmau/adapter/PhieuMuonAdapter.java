package hoandmph27404.fpoly.duanmau.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import hoandmph27404.fpoly.duanmau.DAO.SachDAO;
import hoandmph27404.fpoly.duanmau.DAO.ThanhVienDAO;
import hoandmph27404.fpoly.duanmau.R;
import hoandmph27404.fpoly.duanmau.fragment.PhieuMuonFragment;
import hoandmph27404.fpoly.duanmau.model.LoaiSach;
import hoandmph27404.fpoly.duanmau.model.PhieuMuon;
import hoandmph27404.fpoly.duanmau.model.Sach;
import hoandmph27404.fpoly.duanmau.model.ThanhVien;

public class PhieuMuonAdapter extends ArrayAdapter<PhieuMuon> {
    private Context context;
    PhieuMuonFragment fragment;
    private ArrayList<PhieuMuon> lists;
    TextView tvMaPM, tvTenTV, tvTenSach, tvTienThue, tvNgay, tvTraSach;
    ImageView imgDel;
    SachDAO sachDAO;
    ThanhVienDAO thanhVienDAO;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

    public PhieuMuonAdapter(@NonNull Context context, PhieuMuonFragment fragment, ArrayList<PhieuMuon> lists) {
        super(context, 0, lists);
        this.context=context;
        this.lists=lists;
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v=convertView;
        if (v == null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.phieu_muon_item,null);
        }
        final PhieuMuon item=lists.get(position);
        if (item!=null){
            tvMaPM=v.findViewById(R.id.tvMaPM);
            tvMaPM.setText("Mã loại: " +item.getMaPM());
            sachDAO=new SachDAO(context);
            Sach sach=sachDAO.getID(String.valueOf(item.getMaSach()));
            tvTenSach=v.findViewById(R.id.tvTenSach);
            tvTenSach.setText("Tên loại:  " +sach.getTenSach());
            thanhVienDAO=new ThanhVienDAO(context);
            ThanhVien thanhVien=thanhVienDAO.getID(String.valueOf(item.getMaTV()));
            tvTenTV=v.findViewById(R.id.tvTenTV);
            tvTenTV.setText("Thành viên: " + thanhVien.getHoTen());
            tvTienThue=v.findViewById(R.id.tvTienThue);
            tvTienThue.setText("Tiền thuê: " +item.getTienThue());
            tvNgay=v.findViewById(R.id.tvNgayPM);
            tvNgay.setText("Ngày thuê: "+sdf.format(item.getNgay()));
            tvTraSach=v.findViewById(R.id.tvTraSach);
            if (item.getTraSach()==1){
                tvTraSach.setTextColor(Color.BLUE);
                tvTraSach.setText("Đã trả sách");
            }else{
                tvTraSach.setTextColor(Color.RED);
                tvTraSach.setText("Chưa trả sách");
            }
            imgDel=v.findViewById(R.id.imgDeletesPM);
        }
        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi function Xóa trong ThanhVienFragment
                fragment.xoa(String.valueOf(item.getMaPM()));
            }
        });
        return v;
    }
}
