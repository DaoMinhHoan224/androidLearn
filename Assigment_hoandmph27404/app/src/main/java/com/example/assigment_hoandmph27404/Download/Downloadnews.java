package com.example.assigment_hoandmph27404.Download;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment_hoandmph27404.Adapter.AdapterNews;
import com.example.assigment_hoandmph27404.DTO.Trangchu;
import com.example.assigment_hoandmph27404.Fragment.NewsFragment;
import com.example.assigment_hoandmph27404.Loader.Newsloader;
import com.example.assigment_hoandmph27404.MainActivity;
import com.example.assigment_hoandmph27404.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Downloadnews extends AsyncTask<String, Void, List<Trangchu>>
{
    NewsFragment fragment=null;
    RecyclerView recyclerView;
    AdapterNews adapterNews;


    public Downloadnews(NewsFragment fragment){
        this.fragment=fragment;
    }

    @Override
    protected List<Trangchu> doInBackground(String... strings) {
        Newsloader loader = new Newsloader();
        List<Trangchu> list = new ArrayList<Trangchu>();
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
    protected void onPostExecute(List<Trangchu> trangchus) {
        super.onPostExecute(trangchus);

        recyclerView = fragment.getActivity().findViewById(R.id.recyclerviewNews);
        Log.d("zzzzz", "onPostExecute: số lượng bài viết = " + trangchus.size());
        for (int i = 0; i < trangchus.size(); i++) {
            Log.d("zzzzz", "Tiêu đề bài viết:  " + trangchus.get(i).getTitle());
        }
        adapterNews = new AdapterNews(trangchus,fragment.getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragment.getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterNews);
    }
}
