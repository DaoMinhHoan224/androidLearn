package com.example.day04.bai5;

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

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.UserViewHolder>{

    private Context mContext;
    private ArrayList<UserObject> arrayList;

    public RecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(ArrayList<UserObject> arrayList){
        this.arrayList=arrayList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_recyclerview,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserObject object=arrayList.get(position);
        if (object==null){
            return;
        }
        holder.tv_name.setText(object.getName());
        holder.img_avatar.setImageResource(object.getImg());
        holder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Au dau qua", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (arrayList!=null)
        return arrayList.size();
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_avatar;
        private ImageView img_edit;
        private TextView tv_name;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            img_avatar=itemView.findViewById(R.id.id_avatar);
            img_edit=itemView.findViewById(R.id.id_edit);
            tv_name=itemView.findViewById(R.id.id_tvName);
        }
    }
}
