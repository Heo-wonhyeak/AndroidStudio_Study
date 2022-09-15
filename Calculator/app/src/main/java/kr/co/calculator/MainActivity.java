package kr.co.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    Button btnAdd,btnSub,btnMul,btnDiv,btnRem;
    TextView textResult;
    //입력될 2개의 문자열을 저장할 변수
    String num1,num2;
    //계산 결과를 저장할 실수 변수
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //아이콘 설정
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        //제목설정
        setTitle("간단한 계산기");

        //edittext 값
        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);

        // button 할당
        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        btnRem = findViewById(R.id.BtnRem);

        //TextView 를 변수에 대입
        textResult = findViewById(R.id.TextResult);



        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //값이 비어있다면 (trim() 공백 잘라냄)
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1)+Double.parseDouble(num2);

                    textResult.setText("계산결과 : "+result);
                }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //값이 비어있다면 (trim() 공백 잘라냄)
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1)-Double.parseDouble(num2);

                    textResult.setText("계산결과 : "+result);
                }
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //값이 비어있다면 (trim() 공백 잘라냄)
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1)*Double.parseDouble(num2);

                    textResult.setText("계산결과 : "+result);
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //값이 비어있다면 (trim() 공백 잘라냄)
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (num2.trim().equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1)/Double.parseDouble(num2);
                    // 소수점 첫재짜리 까지 받기
                    String strResult = String.format("%.1f",result);
                    textResult.setText("계산결과 : "+strResult);
                }
            }
        });

        btnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();

                //값이 비어있다면 (trim() 공백 잘라냄)
                if(num1.trim().equals("") || num2.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력해주세요", Toast.LENGTH_SHORT).show();
                } else if (num2.trim().equals("0")) {
                    Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다", Toast.LENGTH_SHORT).show();
                } else {
                    result = Double.parseDouble(num1)%Double.parseDouble(num2);

                    textResult.setText("계산결과 : "+result);
                }
            }
        });





    }
}