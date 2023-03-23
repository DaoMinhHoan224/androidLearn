package com.example.day04.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day04.R;
import com.example.day04.bai5.UserObject;

import java.util.ArrayList;

public class Lab4Adapter extends RecyclerView.Adapter<Lab4Adapter.UserViewHolderLab4> {
    private Context mContext;
    private ArrayList<UserObjectLab4> arrayList4;

    public Lab4Adapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDatalab4(ArrayList<UserObjectLab4> arrayList4){
        this.arrayList4=arrayList4;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Lab4Adapter.UserViewHolderLab4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_lab4,parent,false);
        return new UserViewHolderLab4(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolderLab4 holder, int position) {
        UserObjectLab4 userObjectLab4=arrayList4.get(position);
        if (userObjectLab4==null){
            return;
        }
        holder.tvName.setText(userObjectLab4.getName());
        holder.img_hdh.setImageResource(userObjectLab4.getImg4());

    }



    @Override
    public int getItemCount() {
        if (arrayList4!=null)
            return arrayList4.size();
        return 0;

    }


    public class UserViewHolderLab4 extends RecyclerView.ViewHolder {
           private TextView tvName;
           private ImageView img_hdh;

        public UserViewHolderLab4(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.id_tvNamengang);
            img_hdh=itemView.findViewById(R.id.id_avatarngang);

        }
    }
}