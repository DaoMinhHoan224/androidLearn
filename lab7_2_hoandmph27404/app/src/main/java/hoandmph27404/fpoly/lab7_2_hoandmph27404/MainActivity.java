package hoandmph27404.fpoly.lab7_2_hoandmph27404;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_bai1, btn_bai2,btn_bai3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bai1=findViewById(R.id.btn_bai1);
        btn_bai2=findViewById(R.id.btn_bai2);
        btn_bai3=findViewById(R.id.btn_bai3);

        btn_bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Bai1Activity.class);
                startActivity(intent);
            }
        });
        btn_bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Bai2Activity.class);
                startActivity(intent);
            }
        });
        btn_bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Bai3Activity.class);
                startActivity(intent);
            }
        });
    }
}