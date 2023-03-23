package com.example.option_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_03, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //xử lí sự kiện click lựa chọn menu


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //kiểm tra ID của menu đang chọn
        switch (item.getItemId()){
            case R.id.m_add1:
                Toast.makeText(this, "Bạn chọn menu 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_add2:
                Toast.makeText(this, "Bạn chọn menu 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.m_add3:
                Toast.makeText(this, "Bạn chọn menu 3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}