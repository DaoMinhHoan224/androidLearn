package com.example.assigment_hoandmph27404;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.assigment_hoandmph27404.DAO.UserDAO;
import com.example.assigment_hoandmph27404.Fragment.NewsFragment;


import java.io.IOException;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    ImageView img_icnews, img_icsong, img_doimatkhau, img_avatar, img_camera,ic_logout;
    int REQUEST_CODE_CAMERA = 123;
    int SELECT_IMAGE_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_icnews = findViewById(R.id.img_icnews);
        img_icnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttrangchu = new Intent(MainActivity.this, MainActivityNews.class);
                startActivity(intenttrangchu);
            }
        });

        img_icsong = findViewById(R.id.img_icmusic);
        img_icsong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityMusic.class);
                startActivity(intent);
            }
        });

        img_doimatkhau = findViewById(R.id.img_doimatkhau);
        img_doimatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentdoimatkhau = new Intent(MainActivity.this, MainActivityForgotPassword.class);
                startActivity(intentdoimatkhau);
            }
        });

        ic_logout=findViewById(R.id.ic_logout);
        ic_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlogout=new Intent(MainActivity.this,MainActivityLogin.class);
                startActivity(intentlogout);
            }
        });

        img_avatar = findViewById(R.id.img_avatar1);
        img_camera = findViewById(R.id.img_icprofile);
        img_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE_CAMERA);
            }
        });

        img_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent=new Intent();
                 intent.setType("image/*");
                 intent.setAction(Intent.ACTION_GET_CONTENT);
                 startActivityForResult(Intent.createChooser(intent,"Title"),SELECT_IMAGE_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            Uri uri=data.getData();
            img_avatar.setImageURI(uri);
        }
    }


}
