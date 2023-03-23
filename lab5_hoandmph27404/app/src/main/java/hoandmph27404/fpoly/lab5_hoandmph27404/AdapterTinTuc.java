package hoandmph27404.fpoly.lab5_hoandmph27404;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterTinTuc extends RecyclerView.Adapter<AdapterTinTuc.NewsViewHolder> {
    List<TinTuc> listNews;
    Context context;

    public AdapterTinTuc(List<TinTuc> listnews, Context context) {
        this.listNews = listNews;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final TinTuc objtintuc = listNews.get(position);
        if(objtintuc == null){
            return;
        }
        holder.tv_title.setText(objtintuc.getTitle());
        holder.tv_comment.setText(objtintuc.getComment()== null ? "0":objtintuc.getComment());
        holder.tv_date.setText(objtintuc.getDate());

        holder.tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivitywv.class);
                intent.putExtra("webView",objtintuc.getLink());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listNews != null){
            return listNews.size();
        }
        return 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title,tv_date,tv_comment;
        RecyclerView recyclerView;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_comment = itemView.findViewById(R.id.tv_comment);
            tv_date = itemView.findViewById(R.id.tv_date);

        }
    }
}
