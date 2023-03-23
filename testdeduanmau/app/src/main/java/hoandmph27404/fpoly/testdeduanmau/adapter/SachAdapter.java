package hoandmph27404.fpoly.testdeduanmau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.testdeduanmau.DAO.LoaiSachDAO;
import hoandmph27404.fpoly.testdeduanmau.DAO.ThongKeDAO;
import hoandmph27404.fpoly.testdeduanmau.fragment.SachFragment;
import hoandmph27404.fpoly.testdeduanmau.model.LoaiSach;
import hoandmph27404.fpoly.testdeduanmau.model.Sach;
import hoandmph27404.fpoly.testdeduanmau.R;
import hoandmph27404.fpoly.testdeduanmau.model.Top;

public class SachAdapter extends ArrayAdapter<Sach> {

    private Context context;
    SachFragment fragment;
    private ArrayList<Sach> lists;
    private List<Top> list;
    TextView tvMaSach, tvTenSach, tvGiaThue, tvLoai, tvSoLuong;
    ImageView imgDel;

    public SachAdapter(@NonNull Context context, SachFragment fragment, ArrayList<Sach> lists) {
        super(context, 0, lists);
        this.context=context;
        this.lists=lists;
        this.fragment=fragment;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v=convertView;

        if (v==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.sach_item,null);
        }
        final Sach item=lists.get(position);
        if (item!=null){
            LoaiSachDAO loaiSachDAO=new LoaiSachDAO(context);
            LoaiSach loaiSach=loaiSachDAO.getID(String.valueOf(item.getMaLoai()));
            ThongKeDAO thongKeDAO=new ThongKeDAO(context);
            list=thongKeDAO.getTop();
            tvMaSach=v.findViewById(R.id.tvMaSach);
            tvMaSach.setText("Mã sách: " +item.getMaSach());
            tvTenSach=v.findViewById(R.id.tvTenSach);
            tvTenSach.setText("Tên sách: " + item.getTenSach());
            tvGiaThue=v.findViewById(R.id.tvGiaThue);
            tvGiaThue.setText("Giá thuê: " + item.getGiaThue());
            tvSoLuong=v.findViewById(R.id.tvSL);
            tvSoLuong.setText("Số lượng: " +list);
            tvLoai=v.findViewById(R.id.tvLoai);
            tvLoai.setText("Loại sách: " + loaiSach.getTenLoai());
            imgDel=v.findViewById(R.id.imgDeletesls);
        }
        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.xoa(String.valueOf(item.getMaSach()));
            }
        });
        return v;
    }
}
