package hoanglvph27356.fpoly.test_android_nang_cao.Adaptert;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import hoanglvph27356.fpoly.test_android_nang_cao.MainActivity2;
import hoanglvph27356.fpoly.test_android_nang_cao.News;
import hoanglvph27356.fpoly.test_android_nang_cao.R;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.NewsViewHolder> {
    private ArrayList<News> list;
    private Context context;


    public AdapterNews(ArrayList<News> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_news,parent,false);
       return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        final News  news = list.get(position);
        if(news == null){
            return;
        }
        holder.tv_title.setText(news.getTitle());
        holder.tv_pubdate.setText(news.getPubDate());
        holder.tv_comment.setText(news.getCommemt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("webView",news.getLink());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title,tv_pubdate,tv_comment;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_comment = itemView.findViewById(R.id.tv_comment);
            tv_pubdate = itemView.findViewById(R.id.tv_pubdate);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
