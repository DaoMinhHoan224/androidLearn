package com.example.thuchanhwebview;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class weBView extends AppCompatActivity {
    WebView mwebview;
     SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_activity);
        sharedPreferences=getSharedPreferences("login_register", Context.MODE_PRIVATE);
        mwebview=findViewById(R.id.mwebView);

        mwebview.getSettings().setJavaScriptEnabled(true);

        final Activity activity=this;

        mwebview.setWebChromeClient(new WebChromeClient(){
           @Override
            public void onProgressChanged(WebView webView,int newProgress){
               Log.d("","onProgressChanged" + newProgress);
               super.onProgressChanged(webView,newProgress);
           }
        });

        mwebview.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView webView, WebResourceRequest request,WebResourceError error){
                super.onReceivedError(webView,request,error);
                Toast.makeText(activity, error.getDescription(), Toast.LENGTH_SHORT).show();
            }
        });
        String hoten=sharedPreferences.getString("hoten","");
        String email=sharedPreferences.getString("email","");
        String sdt=sharedPreferences.getString("sdt","");
        String ghichu=sharedPreferences.getString("ghichu","");

        String codeHTML="<h1 style='color:red'>Thông tin giới thiệu</h1>\n" +
                         "<h3 style='color:cornflowerblue'>Họ tên:" +hoten+ "</h3>\n" +
                         "<h3>Email:" +email+ "</h3>\n" +
                         "<h3 style='color:red'>Điện thoại:" +sdt+ "</h3>\n" +
                         "<h3>Ghi chú:" +ghichu+ "</h3>";
        mwebview.loadData(codeHTML,"text/html","utf-8");
    }
}
