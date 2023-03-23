package hoandmph27404.fpoly.lab5__hoandmph27404;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class DownLoadNews extends AsyncTask<String,Void, List<News>> {
    MainActivity activity = null;
    RecyclerView recyclerView;
    AdapterNews adapterNews;

    public DownLoadNews(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected List<News> doInBackground(String... strings) {
        NewsLoader loader = new NewsLoader();
        List<News> list = new ArrayList<News>();
        String urlRss = strings[0];
        try {
            URL url = new URL(urlRss);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if(urlConnection.getResponseCode() ==200){

                InputStream inputStream = urlConnection.getInputStream();
                list = loader.getListNews(inputStream);

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return list;
    }
    @Override
    protected void onPostExecute(List<News> tinTucs) {
        super.onPostExecute(tinTucs);
        recyclerView = activity.findViewById(R.id.recyclerview);
        Log.d("zzzzz", "onPostExecute: số lượng bài viết = " + tinTucs.size());
        for (int i = 0; i < tinTucs.size(); i++) {
            Log.d("zzzzz", "Tiêu đề bài viết:  " + tinTucs.get(i).getTitle());
        }
        adapterNews = new AdapterNews(tinTucs,activity);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity.getApplication(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterNews);

    }
}
