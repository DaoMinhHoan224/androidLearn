package hoandmph27404.fpoly.hoandmph27404_thi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import hoandmph27404.fpoly.hoandmph27404_thi.Download.Downloadnews;

public class MainActivity extends AppCompatActivity {
    Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_save=findViewById(R.id.btnTim);

        String urll="https://vnexpress.net/rss/khoa-hoc.rss";
        Downloadnews downloadnews=new Downloadnews(getApplicationContext(),MainActivity.this);
        downloadnews.execute(urll);
    }
}