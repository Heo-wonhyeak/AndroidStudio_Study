package kr.co.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("액티비티 생명주기","onCreate()");

        Button btnDial = findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:1544-8147");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        Button btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("액티비티 생명주기","onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("액티비티 생명주기","onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("액티비티 생명주기","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("액티비티 생명주기","onResume()");
    }
}