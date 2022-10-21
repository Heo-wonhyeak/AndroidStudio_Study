package kr.co.framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView text1,text2,text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_foreground);
        setTitle("프레임 레이아웃 앱");

        text1 = findViewById(R.id.view1);
        text2 = findViewById(R.id.view2);
        text3 = findViewById(R.id.view3);

        public void btnClick(View view) {
            text1.setVisibility(View.INVISIBLE);
            text2.setVisibility(View.INVISIBLE);
            text3.setVisibility(View.INVISIBLE);

            switch(view.getID()) {
                case R.id.button1:
                    text1.setVisibility(View.VISIBLE);
                    break;
                case R.id.button2:
                    text2.setVisibility(View.VISIBLE);
                    break;
                case R.id.button3:
                    text3.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}