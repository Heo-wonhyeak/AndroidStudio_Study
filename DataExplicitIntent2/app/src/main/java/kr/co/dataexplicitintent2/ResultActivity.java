package kr.co.dataexplicitintent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String calc = intent.getStringExtra("Calc");

        double result = 0;

        if(calc.equals("+")) {
            result = intent.getIntExtra("num1",0)+intent.getIntExtra("num2",0);
        } else if(calc.equals("-")) {
            result = intent.getIntExtra("num1",0)-intent.getIntExtra("num2",0);
        } else if(calc.equals("*")) {
            result = intent.getIntExtra("num1",0)*intent.getIntExtra("num2",0);
        } else {
            if (intent.getIntExtra("num2",2) ==0) {
                Toast.makeText(this, "0으로 나눌수 없습니다", Toast.LENGTH_SHORT).show();
            } else {
                result = intent.getIntExtra("num1",0)/intent.getIntExtra("num2",0);
            }
        }

        final double returnValue = result;

        Button btnReturn = findViewById(R.id.btnBack);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("returnValue",returnValue);
                setResult(RESULT_OK,outIntent);
                finish();
            }
        });


    }
}