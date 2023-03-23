package hoandmph27404.fpoly.lab4_2_hoandmph27404;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
     EditText ed_linkimgg;
     Button btn_down;
     ImageView img_down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_linkimgg=findViewById(R.id.ed_linkimg);
       btn_down=findViewById(R.id.btn_down);
       btn_down.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(CheckNetworkConnect()){

                    String link=ed_linkimgg.getText().toString();

                   new DownloadImg().execute(link);

               }else{

                   Log.d(TAG, "onCreate: Bạn chưa kết nối internet");
               }
           }
       });
    }

    boolean CheckNetworkConnect(){
        ConnectivityManager cnn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cnn.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        boolean isWifi = networkInfo.isConnected();

        networkInfo = cnn.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        boolean isMobile = networkInfo.isConnected();

        if(isWifi)
            Log.d(TAG, "CheckNetworkConnect: Đang kết nối Wifi");

        if(isMobile)
            Log.d(TAG, "CheckNetworkConnect: Đang kết nối Mobile Data (3G,4G,5G)");

        return isMobile || isWifi;
    }

    class DownloadImg extends AsyncTask<String, Void, Bitmap> {
        InputStream inputStream;
        Bitmap bitmap;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("zzzzzz", "onPreExecute: bat dau download ");
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Log.d("zzzzzzzzz", "doInBackground: dang download " + strings[0]);
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();

                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.connect();

                int status = httpsURLConnection.getResponseCode();
                if(status == HttpsURLConnection.HTTP_OK){
                    inputStream = httpsURLConnection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);

                }
                httpsURLConnection.disconnect();

                inputStream.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            Log.d("zzzzzz", "onPostExecute: Download xong roi ");
            ImageView imageView = findViewById(R.id.img_down);
            imageView.setImageBitmap(bitmap);
        }
    }
}