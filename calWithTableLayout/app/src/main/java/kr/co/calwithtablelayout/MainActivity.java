package kr.co.calwithtablelayout;

/*
    화면디자인
        - TableLayout 1 ea. TableRow 9ea
        - EditText 2ea, 숫자버튼 10ea, 연산버튼 4개, 텍스트뷰 1개 생성

    자바코드
        - 전역변수 선언
        - 각 버튼의 클릭 이벤트 처리(리스너생성)
 */
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2;
    //10개 숫자 배열
    Button[] numButtons = new Button[10];
    //10개의 숫자버튼의 id 값 배열
    Integer[] numBtnIds = {R.id.btnNum0,R.id.btnNum1,R.id.btnNum2,R.id.btnNum3,R.id.btnNum4,R.id.btnNum5,R.id.btnNum6
                            ,R.id.btnNum7,R.id.btnNum8,R.id.btnNum9};
    int i;

    Button btnAdd,btnMin,btnMul,btnDiv;
    TextView textResult;

    String num1,num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("계산기");

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);

        btnAdd = findViewById(R.id.btnAdd);
        btnMin = findViewById(R.id.btnMinus);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        textResult = findViewById(R.id.TextResult);

        //숫자버튼 10개 대입
        for(i=0; i<numBtnIds.length; i++) {
            numButtons[i] = findViewById(numBtnIds[i]);
        }

        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)+Integer.parseInt(num2);
                textResult.setText("계산결과" +result);
                return false;
            }
        });

        btnMin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)-Integer.parseInt(num2);
                textResult.setText("계산결과" +result);
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)*Integer.parseInt(num2);
                textResult.setText("계산결과" +result);
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = Integer.parseInt(num1)/Integer.parseInt(num2);
                textResult.setText("계산결과" +result);
                return false;
            }
        });

        //숫자 버튼 10개에 클릭 이벤트 처리
        for(i=0; i<numBtnIds.length; i++) {
            //0~9까지 중 선택된 버튼의 index 정보
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // 포커스 되어있는 에디트 텍스트에 숫자 추가
                    if(edit1.isFocused()) {
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if(edit2.isFocused()) {
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),"입력창을 선택해주세요",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }

    }
}