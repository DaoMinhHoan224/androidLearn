package hoandmph27404.fpoly.baithuchanhthinangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import hoandmph27404.fpoly.baithuchanhthinangcao.Adapter.NewsAdapter;
import hoandmph27404.fpoly.baithuchanhthinangcao.DAO.NewsDAO;
import hoandmph27404.fpoly.baithuchanhthinangcao.DTO.News;

public class MainActivity extends AppCompatActivity {
    TextInputEditText edLink;
    Button btntim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edLink=findViewById(R.id.edLink);
        btntim=findViewById(R.id.btnTim);
        btntim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlnews=edLink.getText().toString();
                Downloadnews downloadnews=new Downloadnews(getApplicationContext(),MainActivity.this);
                downloadnews.execute(urlnews);
            }
        });
    }
}