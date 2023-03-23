package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_info);

        WebView mwebViewinfo=findViewById(R.id.mwebvview_info);
        mwebViewinfo.getSettings().setJavaScriptEnabled(true);

        final Activity activity=this;
        mwebViewinfo.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView webView,int newProgress){
                super.onProgressChanged(webView,newProgress);
            }
        });

        mwebViewinfo.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView webView, WebResourceRequest request, WebResourceError error){
                super.onReceivedError(webView,request,error);
            }
        });
        String themlop="Là những khoản và loại thu mà người dùng đã thực hiện được và nhập vào như 1 danh sách để ghi nhớ";
        String xemlop="Là những khoản và loại chi mà người dùng đã thực hiện được và nhập vào như 1 danh sách để ghi nhớ";
        String quanlysv="Là mục thống kê với số tiền mà người dùng đã thu và chi ";
        String ghichu="Hoànsieudeptrai ";

        String codehtmldksd="<style>line-height:200px</style>" +"<h1 style='color:red'>Điều khoản sử dụng </h1>\n" +
                "    <h3 style='color:cornflowerblue'>Khoản thu: </h3>\n" + themlop +
                "    <h3>Khoản chi:</h3>\n" + xemlop +
                "    <h3 style='color:red'>Thống kê: </h3>\n" + quanlysv +
                "    <h3>Ghi chú:  </h3>" + ghichu ;
        mwebViewinfo.loadData(codehtmldksd,"text/html","utf-8");
    }
    }
