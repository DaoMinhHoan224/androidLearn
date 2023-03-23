package com.example.assignment_hoandmph27404;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class webview_activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);

        WebView mwebView=findViewById(R.id.mwebvview);
            mwebView.getSettings().setJavaScriptEnabled(true);

            final Activity activity=this;
            mwebView.setWebChromeClient(new WebChromeClient(){
                @Override
                public void onProgressChanged(WebView webView,int newProgress){
                    super.onProgressChanged(webView,newProgress);
                }
            });

            mwebView.setWebViewClient(new WebViewClient(){
                @Override
                public void onReceivedError(WebView webView, WebResourceRequest request, WebResourceError error){
                    super.onReceivedError(webView,request,error);
                }
            });
            String themlop="Khi bạn ấn vào chức năng này thì sẽ thực hiện lên 1 màn hình để bạn thêm mới 1 lớp học";
            String xemlop="Chức năng này được chọn để thực hiện xem danh sách lớp mà bạn vừa thêm khi thực hiện chức năng đầu";
            String quanlysv="Thêm sinh viên vào danh sách để quản lý là chức năng của nút này";
            String ghichu="hoan sieu dep trai";

            String codehtml="<style>line-height:200px</style>" +"<h1 style='color:red'>Giới thiệu chức năng</h1>\n" +
                    "    <h3 style='color:cornflowerblue'>Thêm mới: " + themlop + " </h3>\n" +
                    "    <h3>Xem danh sách sinh viên:" + xemlop + "</h3>\n" +
                    "    <h3 style='color:red'>Thêm mới sinh viên: " + quanlysv + "</h3>\n" +
                    "    <h3>Ghi chú: " + ghichu +" </h3>";
            mwebView.loadData(codehtml,"text/html","utf-8");
    }
}
