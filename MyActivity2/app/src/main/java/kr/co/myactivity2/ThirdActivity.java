package kr.co.myactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("ThirdActivity");

        Button btnNewActivity2 = findViewById(R.id.btnNewActivity);
        RadioButton mainActivity = findViewById(R.id.radioMain);
        RadioButton secondActivity = findViewById(R.id.radioSecond);

        btnNewActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainActivity.isChecked()) {
                    Intent intent = new Intent(ThirdActivity.this,MainActivity.class);
                    startActivity(intent);
                } else if (secondActivity.isChecked()) {
                    Intent intent = new Intent(ThirdActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}