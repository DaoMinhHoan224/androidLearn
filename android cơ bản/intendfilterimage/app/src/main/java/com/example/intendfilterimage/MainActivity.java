package com.example.intendfilterimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=findViewById(R.id.img_shared);
        if(getIntent().getExtras()!=null ) {
            imageView.setImageURI((Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM));
        }
    }
}