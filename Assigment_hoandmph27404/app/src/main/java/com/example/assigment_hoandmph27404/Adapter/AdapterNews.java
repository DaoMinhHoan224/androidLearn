package com.example.assigment_hoandmph27404.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment_hoandmph27404.DTO.Trangchu;
import com.example.assigment_hoandmph27404.Fragment.NewsFragment;
import com.example.assigment_hoandmph27404.R;
import com.example.assigment_hoandmph27404.WebViewNews;

import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.NewsViewHolder>{

    private List<Trangchu> listTrangchu;
    Context context;
    NewsFragment fragment;

    public AdapterNews(List<Trangchu> listTrangchu, Context context) {
        this.listTrangchu = listTrangchu;
        this.context = context;
    }



    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final Trangchu objNews = listTrangchu.get(position);
        if(objNews == null){
            return;
        }
        holder.tv_title.setText(objNews.getTitle());
        holder.tv_comment.setText(objNews.getCommemt()== null ? "0":objNews.getCommemt());
        holder.tv_date.setText(objNews.getPubDate());

        holder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebViewNews.class);
                intent.putExtra("webView",objNews.getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listTrangchu != null){
            return listTrangchu.size();
        }
        return 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title,tv_date,tv_comment;
        private ImageView img_avata;
        RecyclerView recyclerView;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_comment = itemView.findViewById(R.id.tv_comment);
            tv_date = itemView.findViewById(R.id.tv_date);



        }
    }
}
