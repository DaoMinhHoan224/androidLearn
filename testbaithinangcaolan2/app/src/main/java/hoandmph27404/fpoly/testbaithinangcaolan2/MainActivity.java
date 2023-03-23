package hoandmph27404.fpoly.testbaithinangcaolan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import hoandmph27404.fpoly.testbaithinangcaolan2.Download.Downloadnews;

public class MainActivity extends AppCompatActivity {
    TextInputEditText edlink;
    Button btnlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edlink=findViewById(R.id.edLink);
        btnlink=findViewById(R.id.btnTim);
        btnlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=edlink.getText().toString();
                Downloadnews downloadnews=new Downloadnews(getApplicationContext(),MainActivity.this);
                downloadnews.execute(url);
            }
        });
    }
}