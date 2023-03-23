package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView_gt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_gt);

        WebView mWebViewgt=findViewById(R.id.mwebvview_gt);
        mWebViewgt.getSettings().setJavaScriptEnabled(true);

        final Activity activityinfo=this;
        mWebViewgt.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView webView,int newProgress){
                super.onProgressChanged(webView,newProgress);
            }
        });

        mWebViewgt.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView webView, WebResourceRequest request, WebResourceError error){
                super.onReceivedError(webView,request,error);
            }
        });
        String infoungdung=" là ứng dụng nhập và thống kê những khoản thu chi của người dùng.Giúp người dùng có thể tự quản lý được những vấn đề của mình ";



        String codehtmlgt="<h1 style='color:red'>Giới thiệu</h1>\n" +
                "    <h3 style='color:cornflowerblue'>Quản lý thu chi:  </h3>\n"+ infoungdung ;
        mWebViewgt.loadData(codehtmlgt,"text/html","utf-8");
    }
    }
