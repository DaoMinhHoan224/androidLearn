package hoandmph27404.fpoly.lab5__hoandmph27404;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed_link = findViewById(R.id.ed_add_link);
        ImageView img_search = findViewById(R.id.img_search);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlRss = ed_link.getText().toString().trim();
                if(urlRss.length() == 0){
                    Toast.makeText(MainActivity.this, "Chưa điền thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    DownLoadNews downloadTinTuc = new DownLoadNews(MainActivity.this);
                    downloadTinTuc.execute(urlRss);
                }
            }
        });



    }
    }