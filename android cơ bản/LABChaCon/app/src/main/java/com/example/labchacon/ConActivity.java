package com.example.labchacon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ConActivity extends AppCompatActivity {
    Button btn_login;
    EditText ed_user,ed_pass;
    ActivityResultLauncher toolActivityResultLauncher=registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d("","onActivityResult: " +result.toString());
                    Log.d("","onActivityResult"+ result.getResultCode());
                    Log.d("","onActivityResult" + result.getData().getStringExtra("hoten"));
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con);

        ed_user=findViewById(R.id.ed_user);
        ed_pass=findViewById(R.id.ed_pass);
        btn_login=findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=ed_user.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("hoten",name);

                Intent intent=new Intent(getBaseContext(),MainActivity.class);
                intent.putExtra("goihang",bundle);
                toolActivityResultLauncher.launch(intent);


            }
        });
    }
}
