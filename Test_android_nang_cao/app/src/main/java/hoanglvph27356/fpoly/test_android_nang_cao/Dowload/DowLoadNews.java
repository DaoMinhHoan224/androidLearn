package hoanglvph27356.fpoly.test_android_nang_cao.Dowload;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import hoanglvph27356.fpoly.test_android_nang_cao.DAO.NewSDAO;
import hoanglvph27356.fpoly.test_android_nang_cao.MainActivity;
import hoanglvph27356.fpoly.test_android_nang_cao.MyService0001;
import hoanglvph27356.fpoly.test_android_nang_cao.News;
import hoanglvph27356.fpoly.test_android_nang_cao.R;

public class DowLoadNews extends AsyncTask<String,Void, List<News>> {
    NewSDAO newSDAO;
    MainActivity mainActivity = null;


    public DowLoadNews(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected List<News> doInBackground(String... strings) {
        LoaderNews loader = new LoaderNews();
        List<News> list = new ArrayList<News>();
        String urlRss = strings[0];
        try {
            URL url = new URL(urlRss);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            if(urlConnection.getResponseCode() ==200){
                // kết nối thành công thì mới lấy luồng dữ liệu
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
    protected void onPostExecute(List<News> news) {
        super.onPostExecute(news);
        newSDAO = new NewSDAO(mainActivity.getApplicationContext());
        LinearLayout main_content;
        main_content = mainActivity.findViewById(R.id.main_content);
        for (int i = 0;i<news.size();i++){
            News objNews = new News();
            objNews.setTitle(news.get(i).getTitle());
            objNews.setPubDate(news.get(i).getPubDate());
            objNews.setCommemt(news.get(i).getCommemt());
            objNews.setLink(news.get(i).getLink());
            long kq = newSDAO.insertNews(objNews);
            if(kq > 0){
                Log.d("zzzz", "Thêm mới thành công: " + news.get(i).getTitle() );
            }else{
                Log.d("zzzz", "Thêm mới Thất bại: " + news.get(i).getTitle() );
            }

        }
        Snackbar snackbar = Snackbar
                .make(main_content, "Thông báo - Snackbar đơn giản", Snackbar.LENGTH_LONG);
        snackbar.show();
        Intent intent = new Intent(mainActivity, MyService0001.class);
        mainActivity.startService(intent);


    }

}
