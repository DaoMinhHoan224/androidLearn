package hoandmph27404.fpoly.xmlpullparser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import hoandmph27404.fpoly.xmlpullparser.DTO.ProductDTO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ProductDTO> list=null;
        ProductLoader loader=new ProductLoader();

        try {
            InputStream inputStream=getAssets().open("products.xml");

            list=loader.getProductDTOList(inputStream);

            for (int i=0;i< list.size();i++){
                Log.d("zzz","San pham: " + list.get(i).toString());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}