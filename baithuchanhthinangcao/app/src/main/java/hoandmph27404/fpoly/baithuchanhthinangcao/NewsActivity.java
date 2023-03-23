package hoandmph27404.fpoly.baithuchanhthinangcao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ListView;

import java.util.ArrayList;

import hoandmph27404.fpoly.baithuchanhthinangcao.Adapter.NewsAdapter;
import hoandmph27404.fpoly.baithuchanhthinangcao.DAO.NewsDAO;
import hoandmph27404.fpoly.baithuchanhthinangcao.DTO.News;

public class NewsActivity extends AppCompatActivity {
    WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        wb=findViewById(R.id.webview);
        Bundle bundle=getIntent().getExtras();
        String url=bundle.getString("webView");
        wb.loadUrl(url);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Tin tuc");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}