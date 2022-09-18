package kr.co.viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.honeycomb);
        setTitle("자동사진보기앱");

        Button btnStart, btnStop;
        final ViewFlipper viewFlipper;

        btnStart =findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        viewFlipper = findViewById(R.id.viewFlipper);
        // 화면 넘김 간격 메서드(1초)
        viewFlipper.setFlipInterval(1000);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.startFlipping();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.stopFlipping();
            }
        });

    }
}