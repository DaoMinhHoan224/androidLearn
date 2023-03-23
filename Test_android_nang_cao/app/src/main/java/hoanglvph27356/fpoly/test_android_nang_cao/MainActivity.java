package hoanglvph27356.fpoly.test_android_nang_cao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import hoanglvph27356.fpoly.test_android_nang_cao.Adaptert.AdapterNews;
import hoanglvph27356.fpoly.test_android_nang_cao.DAO.NewSDAO;
import hoanglvph27356.fpoly.test_android_nang_cao.Dowload.DowLoadNews;

public class MainActivity extends AppCompatActivity {
    NewSDAO newSDAO;
    AdapterNews adapterNews;
    ArrayList<News> list;
    RecyclerView recyclerView;
    LinearLayout main_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newSDAO = new NewSDAO(getApplicationContext());
        main_content = findViewById(R.id.main_content);
        recyclerView = findViewById(R.id.ryc_view_news);
        DowLoadNews downloadTinTuc = new DowLoadNews(MainActivity.this);
        downloadTinTuc.execute("https://vnexpress.net/rss/cuoi.rss");
        list = newSDAO.getAll();
        Log.d("pppp", "onCreate: " + list.size());
        adapterNews = new AdapterNews(list,getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterNews);



    }
}