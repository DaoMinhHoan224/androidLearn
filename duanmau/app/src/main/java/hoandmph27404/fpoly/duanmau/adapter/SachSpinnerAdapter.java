package hoandmph27404.fpoly.duanmau.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import hoandmph27404.fpoly.duanmau.R;
import hoandmph27404.fpoly.duanmau.model.Sach;
import hoandmph27404.fpoly.duanmau.model.ThanhVien;

public class SachSpinnerAdapter extends ArrayAdapter<Sach> {
    private Context context;
    private ArrayList<Sach> lists;
    TextView tvMaSach, tvTenSach;

    public SachSpinnerAdapter(@NonNull Context context, ArrayList<Sach> lists) {
        super(context, 0,lists);
        this.context=context;
        this.lists=lists;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v=convertView;
        if (v==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.sach_item_spinner,null);
        }
        final Sach item= lists.get(position);
        if (item!=null){
            tvMaSach=v.findViewById(R.id.tvMaSachSp);
            tvMaSach.setText(item.getMaSach() + ". ");
            tvTenSach=v.findViewById(R.id.tvTenSachSp);
            tvTenSach.setText(item.getTenSach());
        }
        return v;
    }

    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View v=convertView;
        if (v==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inflater.inflate(R.layout.sach_item_spinner,null);
        }
        final Sach item= lists.get(position);
        if (item!=null){
            tvMaSach=v.findViewById(R.id.tvMaSachSp);
            tvMaSach.setText(item.getMaSach() + ". ");
            tvTenSach=v.findViewById(R.id.tvTenSachSp);
            tvTenSach.setText(item.getTenSach());
        }
        return v;
    }
}
