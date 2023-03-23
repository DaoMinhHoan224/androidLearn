package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webView_dksd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_dksd);

        WebView mwebViewdksd=findViewById(R.id.mwebvview_dksd);
        mwebViewdksd.getSettings().setJavaScriptEnabled(true);

        final Activity activity=this;
        mwebViewdksd.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView webView,int newProgress){
                super.onProgressChanged(webView,newProgress);
            }
        });

        mwebViewdksd.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView webView, WebResourceRequest request, WebResourceError error){
                super.onReceivedError(webView,request,error);
            }
        });
        String capnhat="Thỏa Thuận này có thể được cập nhật thường xuyên bởi Hoàn, phiên bản cập nhật sẽ được chúng tôi công bố tại\n" +
                "      website http://hoan.me/zalo/dieukhoan/. Phiên bản cập nhật sẽ thay thế cho các quy định và điều kiện trong\n" +
                "      thỏa thuận ban đầu. Bạn có thể truy cập vào Ứng Dụng hoặc vào website trên đây để xem nội dung chi tiết của\n" +
                "      phiên bản cập nhật.";
        String quyensohuu="Ứng Dụng này được phát triển và sở hữu bởi Hoàn, tất cả các quyền sở hữu trí tuệ liên quan đến Ứng Dụng (bao\n" +
                "      gồm nhưng không giới hạn mã nguồn, hình ảnh, dữ liệu, thông tin, nội dung chứa đựng trong Ứng Dụng; các sửa\n" +
                "      đổi, bổ sung, cập nhật của Ứng Dụng) và các tài liệu hướng dẫn liên quan (nếu có) sẽ thuộc quyền sở hữu duy\n" +
                "      nhất bởi Hoàn và không cá nhân, tổ chức nào được phép sao chép, tái tạo, phân phối, hoặc hình thức khác xâm\n" +
                "      phạm tới quyền của chủ sở hữu nếu không có sự đồng ý và cho phép bằng văn bản của Hoàn.";

        String baomat="Hoàn sử dụng các phương thức truyền tin an toàn https và mã hóa để truyền tải và lưu trữ các dữ liệu cá nhân\n" +
                "      và giao tiếp của bạn. Chúng tôi cam kết giữ bí mật tất cả thông tin mà bạn cung cấp cho Hoàn hoặc chúng tôi\n" +
                "      thu thập từ bạn và không tiết lộ với bất kỳ bên thứ ba nào trừ khi có yêu cầu từ Cơ quan Nhà nước có thẩm\n" +
                "      quyền. ";
        String ghichu="Hoànsieudeptrai ";

        String codehtmldksd="<style>line-height:200px</style>" +"<h1 style='color:red'>Điều khoản sử dụng </h1>\n" +
                "    <h3 style='color:cornflowerblue'>Cập nhật: </h3>\n" + capnhat +
                "    <h3>Khoản chi:</h3>\n" + quyensohuu +
                "    <h3 style='color:red'>Bảo mật: </h3>\n" + baomat +
                "    <h3>Ghi chú:  </h3>" + ghichu ;
        mwebViewdksd.loadData(codehtmldksd,"text/html","utf-8");
    }
    }
