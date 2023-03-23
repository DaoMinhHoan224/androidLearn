package com.example.kt4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.UserViewHolder>{
    private Context context;
    private ArrayList<RecyObject> arrayList;


    public RecyclerViewAdapter2(Context context) {
        this.context = context;
    }
    public void setData2(ArrayList<RecyObject> arrayList){
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item2,parent,false);
        return new RecyclerViewAdapter2.UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        RecyObject object = arrayList.get(position);
        if (object == null){
            return;
        }
        holder.tv_name.setText(object.getName());
        holder.img_avt.setImageResource(object.getImg());
        holder.img_dowload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"da tai len", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_avt;
        private TextView tv_name;
        private ImageView img_dowload;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            img_avt = itemView.findViewById(R.id.id_avt);
            tv_name = itemView.findViewById(R.id.tvv_name);
            img_dowload = itemView.findViewById(R.id.id_dowload);
        }
    }
}
