package duymvph27211.fpoly.baitaponthi.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import duymvph27211.fpoly.baitaponthi.DTO.TinTuc;
import duymvph27211.fpoly.baitaponthi.MainActivity;
import duymvph27211.fpoly.baitaponthi.R;
import duymvph27211.fpoly.baitaponthi.webViewActivity;

public class Adapter_item_view extends BaseAdapter {
    Context context;
    MainActivity activity;
    List<TinTuc>  list;
    TextView tvTitle;
    public Adapter_item_view(Context context, MainActivity activity, List<TinTuc> list) {
        this.context = context;
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
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
        if (convertView == null){
            LayoutInflater inflater  = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_view,null);

        }
        final TinTuc item  = list.get(position);
        if (item!=null){
            TextView tvTitle = convertView.findViewById(R.id.tvTitle);
            tvTitle.setText(item.getTitle());

            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, webViewActivity.class);
                    intent.putExtra("webView",item.getLink());
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }

        return convertView;
    }
}
