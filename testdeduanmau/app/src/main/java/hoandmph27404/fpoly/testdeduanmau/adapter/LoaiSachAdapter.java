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

import hoandmph27404.fpoly.testdeduanmau.fragment.LoaiSachFragment;
import hoandmph27404.fpoly.testdeduanmau.fragment.ThanhVienFragment;
import hoandmph27404.fpoly.testdeduanmau.model.LoaiSach;
import hoandmph27404.fpoly.testdeduanmau.model.ThanhVien;
import hoandmph27404.fpoly.testdeduanmau.R;

public class LoaiSachAdapter extends ArrayAdapter<LoaiSach> {

    private Context context;
    LoaiSachFragment fragment;
    private ArrayList<LoaiSach> lists;
    TextView tvMaLoai, tvTenLoai;
    ImageView imgDel;


    public LoaiSachAdapter(@NonNull Context context, LoaiSachFragment fragment, ArrayList<LoaiSach> lists) {
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
            v=inflater.inflate(R.layout.loai_sach_item,null);
        }
        final LoaiSach item=lists.get(position);
        if (item!=null){
            tvMaLoai=v.findViewById(R.id.tvMaLoaiSach);
            tvMaLoai.setText("Mã loại: " +item.getMaLoai());

            tvTenLoai=v.findViewById(R.id.tvTenLoaiSach);
            tvTenLoai.setText("Tên loại:  " +item.getTenLoai());
            imgDel=v.findViewById(R.id.imgDeletesls);
        }
        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi function Xóa trong ThanhVienFragment
                fragment.xoa(String.valueOf(item.getMaLoai()));
            }
        });
        return v;
    }
}
