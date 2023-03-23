package hoandmph27404.fpoly.testbaithinangcaolan2.Download;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import hoandmph27404.fpoly.testbaithinangcaolan2.Adapter.NewsAdapter;
import hoandmph27404.fpoly.testbaithinangcaolan2.DAO.NewsDAO;
import hoandmph27404.fpoly.testbaithinangcaolan2.DTO.News;
import hoandmph27404.fpoly.testbaithinangcaolan2.MainActivity;
import hoandmph27404.fpoly.testbaithinangcaolan2.MyService;
import hoandmph27404.fpoly.testbaithinangcaolan2.R;

public class Downloadnews extends AsyncTask<String, Void, List<News>> {
    Context context;
    MainActivity mainActivity;
    List<News> newsList;
    NewsDAO newsDAO;

    public Downloadnews(Context context, MainActivity mainActivity) {
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    protected List<News> doInBackground(String... strings) {
        Newsloader loader=new Newsloader();
        List<News> list=new ArrayList<>();
        newsDAO=new NewsDAO(context);
        try {
            URL urllink=new URL(strings[0]);
            HttpURLConnection urlConnection=(HttpURLConnection)urllink.openConnection();
            urlConnection.connect();

            if (urlConnection.getResponseCode()==200){
                InputStream inputStream=urlConnection.getInputStream();
                list=loader.getTinTucList(inputStream);
                for (int i=0;i<list.size();i++){
                    News news=new News();
                    news.setTitle(list.get(i).getTitle());
                    news.setLink(list.get(i).getLink());
                    newsDAO.insertNews(news);
                }
            }
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        list=newsDAO.getAll();

        return null;
    }

    @Override
    protected void onPostExecute(List<News> news) {
        super.onPostExecute(news);
        LinearLayout main_content=mainActivity.findViewById(R.id.main_contant);
        news=newsDAO.getAll();
        for (int i=0;i<news.size();i++){
            Log.d("aaaaa","on id + "+i+"-"+news.get(i).getTitle());
        }
        ListView listView=mainActivity.findViewById(R.id.listView);
        NewsAdapter newsAdapter=new NewsAdapter(mainActivity.getApplicationContext(),mainActivity,news);
        listView.setAdapter(newsAdapter);

        Snackbar snackbar=Snackbar.make(main_content,"DDa load xong",Snackbar.LENGTH_LONG);
        snackbar.show();

        Intent intent=new Intent(mainActivity, MyService.class);
        mainActivity.startService(intent);
    }
}
