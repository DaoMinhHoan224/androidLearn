package duymvph27211.fpoly.baitaponthi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText edLink;
    Button btnTim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edLink = findViewById(R.id.edLink);
        btnTim =  findViewById(R.id.btnTim);
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = edLink.getText().toString();
                DownloadTinTuc downloadTinTuc  = new DownloadTinTuc(getApplicationContext(),MainActivity.this);
                downloadTinTuc.execute(link);
            }
        });


    }
}