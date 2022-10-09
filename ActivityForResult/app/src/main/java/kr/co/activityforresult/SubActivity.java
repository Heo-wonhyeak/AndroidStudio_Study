package kr.co.activityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    EditText subEdit;
    TextView subText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        subEdit = findViewById(R.id.subEdit);
        subText = findViewById(R.id.subText);

        Intent subIntent = getIntent();
        int num1 = subIntent.getIntExtra("num1",0);
        int num2 = subIntent.getIntExtra("num2",0);

        subText.setText(num1+"+"+num2+" = ");
        subEdit.setText(""+(num1+num2));

        Button btnOK = findViewById(R.id.btnOK);

        // 버튼이 클릭되면 사용자가 입력한 숫자를 인텐트에 넣어서 메인 액티비티로 전달함
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result",num1+num2);
                setResult(RESULT_OK,intent);
                finish();

            }
        });

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}