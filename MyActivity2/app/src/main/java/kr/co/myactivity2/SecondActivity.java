package kr.co.myactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("SecondActivity");

        Button btnNewActivity2 = findViewById(R.id.btnNewActivity);
        RadioButton mainActivity = findViewById(R.id.radioMain);
        RadioButton thirdActivity = findViewById(R.id.radioThird);

        btnNewActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mainActivity.isChecked()) {
                    Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                    startActivity(intent);
                } else if (thirdActivity.isChecked()) {
                    Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
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