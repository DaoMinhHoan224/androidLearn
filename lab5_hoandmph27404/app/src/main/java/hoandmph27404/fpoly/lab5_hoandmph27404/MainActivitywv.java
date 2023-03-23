package hoandmph27404.fpoly.lab5_hoandmph27404;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivitywv extends AppCompatActivity {
     WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitywv);

        wb=findViewById(R.id.webView1);
        Bundle bundle=getIntent().getExtras();
        String url=bundle.getString("webView");
        wb.loadUrl(url);
        ActionBar  actionBar=getSupportActionBar();
        actionBar.setTitle("Tin tức");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
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