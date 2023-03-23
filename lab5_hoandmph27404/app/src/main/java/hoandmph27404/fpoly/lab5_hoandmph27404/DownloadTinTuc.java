package hoandmph27404.fpoly.lab5_hoandmph27404;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadTinTuc extends AsyncTask<String,Void, List<TinTuc>> {
    MainActivity activity=null;
    AdapterTinTuc adapter;
    RecyclerView recyclerView;

    public DownloadTinTuc(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected List<TinTuc> doInBackground(String... strings) {
        TinTucLoader loader=new TinTucLoader();
        List<TinTuc> list=new ArrayList<TinTuc>();

        String urlRss=strings[0];

        try {
            URL url=new URL(urlRss);
            HttpURLConnection urlConnection=(HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if (urlConnection.getResponseCode()==200){
                InputStream inputStream=urlConnection.getInputStream();
                list=loader.getTintucList(inputStream);
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    protected void onPostExecute(List<TinTuc> tinTucs) {
        super.onPostExecute(tinTucs);

        Log.d("zzzzz","onPostExecute: số lượng bài viết= " + tinTucs.size());
        for (int i=0;i<tinTucs.size();i++){
            Log.d("zzzzz","Tiêu đề bài viết: " + tinTucs.get(i).getTitle());
        }

        recyclerView=(RecyclerView) activity.findViewById(R.id.recyclerview);
        adapter=new AdapterTinTuc(tinTucs,activity);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(activity.getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
