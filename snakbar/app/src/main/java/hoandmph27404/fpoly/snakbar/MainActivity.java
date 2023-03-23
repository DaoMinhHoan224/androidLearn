package hoandmph27404.fpoly.snakbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    CoordinatorLayout main_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_content = findViewById(R.id.main_content);

        findViewById(R.id.snackbar1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(main_content, "Thông báo - Snackbar đơn giản", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        findViewById(R.id.snackbar2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(main_content, "Không có mạng", Snackbar.LENGTH_LONG)
                        .setAction("Thử lại", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Code khi bấm vào nút thư lại ở đây
                            }
                        });
                snackbar.show();
            }
        });

        findViewById(R.id.snackbar3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(main_content, "Không có mạng", Snackbar.LENGTH_LONG)
                        .setAction("Thử lại", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //Code khi bấm vào nút thư lại ở đây
                            }
                        });

                // Changing message text color
                snackbar.setActionTextColor(Color.RED);


                // Changing action button text color
                View sbView = snackbar.getView();
                sbView.setBackgroundColor(Color.YELLOW);
                TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.BLUE);


                snackbar.show();
            }
        });



        setClickFloatButton();


    }

    void setClickFloatButton() {
        FloatingActionButton floatingActionButton = findViewById(R.id.floatbutton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar mySnackbar = Snackbar.make(view, "Thông báo ...", Snackbar.LENGTH_LONG);
                mySnackbar.show();
            }
        });
    }

}
