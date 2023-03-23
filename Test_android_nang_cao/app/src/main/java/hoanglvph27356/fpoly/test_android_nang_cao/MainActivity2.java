package hoanglvph27356.fpoly.test_android_nang_cao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity2 extends AppCompatActivity {
    WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wb = findViewById(R.id.web_view);
        Bundle extras =  getIntent().getExtras();
        String url = extras.getString("webView");
        wb.loadUrl(url);
    }
}