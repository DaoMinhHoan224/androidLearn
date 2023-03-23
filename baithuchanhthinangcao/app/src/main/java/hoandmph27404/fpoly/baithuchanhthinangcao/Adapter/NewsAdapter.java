package hoandmph27404.fpoly.baithuchanhthinangcao.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.baithuchanhthinangcao.DAO.NewsDAO;
import hoandmph27404.fpoly.baithuchanhthinangcao.DTO.News;
import hoandmph27404.fpoly.baithuchanhthinangcao.MainActivity;
import hoandmph27404.fpoly.baithuchanhthinangcao.NewsActivity;
import hoandmph27404.fpoly.baithuchanhthinangcao.R;

public class NewsAdapter extends BaseAdapter {
    List<News> newsList;
    Context context;
    NewsDAO newsDAOl;
    MainActivity mainActivity;


    public NewsAdapter(Context context, MainActivity mainActivity, List<News> newsList) {
        this.context = context;
        this.mainActivity=mainActivity;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.news_item,null);
        }

        final News newsitem=newsList.get(position);
        if (newsitem!=null){
            TextView tv_title=convertView.findViewById(R.id.tvTitle);
            tv_title.setText(newsitem.getTitle());

           tv_title.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(context, NewsActivity.class);
                   intent.putExtra("webView", newsitem.getLink());
                   intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(intent);
               }
           });
        }
        return convertView;
    }
}
