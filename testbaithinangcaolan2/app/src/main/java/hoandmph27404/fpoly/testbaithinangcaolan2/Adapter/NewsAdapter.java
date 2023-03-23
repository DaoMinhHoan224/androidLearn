package hoandmph27404.fpoly.testbaithinangcaolan2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hoandmph27404.fpoly.testbaithinangcaolan2.DTO.News;
import hoandmph27404.fpoly.testbaithinangcaolan2.MainActivity;
import hoandmph27404.fpoly.testbaithinangcaolan2.R;
import hoandmph27404.fpoly.testbaithinangcaolan2.WebViewwwww;

public class NewsAdapter extends BaseAdapter {
    Context context;
    MainActivity mainActivity;
    List<News> newslist;

    public NewsAdapter(Context context, MainActivity mainActivity, List<News> newslist) {
        this.context=context;
        this.mainActivity=mainActivity;
        this.newslist=newslist;
    }


    @Override
    public int getCount() {
        return newslist.size();
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
            LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.news_item,null);
        }
        final News newss=newslist.get(position);
        if (newss!=null){
            TextView tvTitle=convertView.findViewById(R.id.tvTitle);
            tvTitle.setText(newss.getTitle());

            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, WebViewwwww.class);
                    intent.putExtra("webView", newss.getLink());
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
        return convertView;
    }
}
