package com.example.thwebview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     WebView mwebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mwebview = findViewById(R.id.mWebview);

        //cho phép js hoạt động
        mwebview.getSettings().setJavaScriptEnabled(true);

        final Activity activity = this;

        mwebview.setWebChromeClient(new WebChromeClient(){
                @Override
            public void onProgressChanged(WebView webView,int newProgress){
                    Log.d("zzzzzzzzz"," onProgressChanged"+ newProgress);// xem load tiến trình
                    super.onProgressChanged(webView,newProgress);
                }

        });

        mwebview.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView webView, WebResourceRequest request,WebResourceError error){
                super.onReceivedError(webView,request,error);
                //hiển thị lỗi khi có lỗi xảy ra
                Toast.makeText(activity, error.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
        //load web online
        String hoTen = "Nguyen van A";

        String chuoiHtml ="    <h1 style='color:blue'>Giới thiệu</h1>\n" +
                "    <h2 style='border: 1px solid red'>Họ tên:  "  +hoTen+ " </h2>\n";

        mwebview.loadData(chuoiHtml,"text/html","utf-8");
    }
}