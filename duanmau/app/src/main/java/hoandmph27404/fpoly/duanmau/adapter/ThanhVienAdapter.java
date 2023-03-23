package hoandmph27404.fpoly.duanmau.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.duanmau.R;
import hoandmph27404.fpoly.duanmau.fragment.ThanhVienFragment;
import hoandmph27404.fpoly.duanmau.model.ThanhVien;

public class ThanhVienAdapter extends ArrayAdapter<ThanhVien> {
    private Context context;
    ThanhVienFragment fragment;
    private ArrayList<ThanhVien> lists;
    ListView lvpeople;
    TextView tvMaTV, tvTenTV, tvNamSinh,tvGioiTinh;
    ImageView imgDel;


    public ThanhVienAdapter(@NonNull Context context, ThanhVienFragment fragment, ArrayList<ThanhVien> lists) {
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
            v=inflater.inflate(R.layout.thanh_vien_item,null);
        }
        final ThanhVien item=lists.get(position);
        if (item!=null){
            tvMaTV=v.findViewById(R.id.tvMaTV);
            tvMaTV.setText("Mã thành viên: " +item.getMaTV());
            tvTenTV=v.findViewById(R.id.tvTenTV);
            tvTenTV.setText("Tên thành viên:  " +item.getHoTen());
            tvNamSinh=v.findViewById(R.id.tvNamSinh);
            tvNamSinh.setText("Năm sinh: "+item.getNamSinh());
            tvGioiTinh=v.findViewById(R.id.tvGioiTinh);
            if (item.getGioiTinh().equalsIgnoreCase("nam")){
                tvGioiTinh.setTextColor(Color.BLUE);
                tvGioiTinh.setText("Giới tính: " + item.getGioiTinh());
            }else{
                tvGioiTinh.setTextColor(Color.YELLOW);
                tvGioiTinh.setText("Giới tính: " +item.getGioiTinh() );
            }
            imgDel=v.findViewById(R.id.imgDeletes);


        }
        imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi function Xóa trong ThanhVienFragment
                fragment.xoa(String.valueOf(item.getMaTV()));
            }
        });
        return v;

    }
}
