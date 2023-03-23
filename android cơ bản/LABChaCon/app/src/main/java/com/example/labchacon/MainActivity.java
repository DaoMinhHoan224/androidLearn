package com.example.labchacon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent objintent=getIntent();
        Bundle objBundle=objintent.getBundleExtra("goihang");
        String hoten=objBundle.getString("hoten");
        tv_info=findViewById(R.id.tv_info);
        tv_info.setText("hoten" + hoten);
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item){
          if(item.getItemId()==android.R.id.home)
              this.onBackPress();
          return super.onOptionsItemSelected(item);
    }

    public void onBackPress(){
        Intent i=getIntent();
        i.putExtra("adssad","ưqrqrqw");
        setResult(Activity.RESULT_OK,i);
        super.onBackPressed();
    }
}