package com.example.bonhotrong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    EditText ed_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_content=findViewById(R.id.ed_content);
    }

    public void SaveFile(View view){
       String noidung=ed_content.getText().toString();//Lấy nội dung người dùng vừa nhập
       String file_name="vidu.txt";// khai báo tên lưu file

       try {
          //Mở rộng tạo file
           FileOutputStream fos=openFileOutput(file_name, Context.MODE_PRIVATE);
           //ghi dữ liệu vào file,chuyển chuỗi nội dung thành mảng các byte dữ liệu và ghi file
           fos.write(noidung.getBytes());
           //đóng luồng
           fos.close();
           //nếu không có lỗi thì hiện thông bóa
           Toast.makeText(getBaseContext(), "Đã ghi vào file", Toast.LENGTH_SHORT).show();

       } catch (FileNotFoundException e) {
           //lỗi không đúng đường dẫn
           e.printStackTrace();
       } catch (IOException e) {
           //lỗi ko ghi dữ liệu vào file hoặc không mở được file
           e.printStackTrace();
       }
    }

    public void ReadFile(View view){
         String file_name="vidu.txt";
         //tạo đối tượng string buff để xây dựng chuỗi dữ liệu
        StringBuffer stringBuffer=new StringBuffer();

        try {
            //Luồng dữ liệu file
            FileInputStream fis=openFileInput(file_name);
            //khai báo luồng đọc dữ liệu
            InputStreamReader isr=new InputStreamReader(fis);
            //tạo biến đệm cho quá trình đọc
            BufferedReader bufferedReader=new BufferedReader(isr);

            String line;
            //dùng vòng lặp để đọc từ đầu đến hết file
            while ((line = bufferedReader.readLine()) != null){
                //nếu kết quả đọc 1 dòng vào biến line mà khác null ( biến line nhận null) thì append vào chuỗi buffer
                stringBuffer.append(line); //nối vào chuỗi buffer
            }
            //khi nào đọc hết file thì line sẽ là null
            Toast.makeText(getBaseContext(), stringBuffer.toString(), Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}