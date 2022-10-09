package kr.co.activityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1,edit2,edit3;
    static final int GET_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnResult = findViewById(R.id.btnResult);
        edit1= findViewById(R.id.edit1);
        edit2= findViewById(R.id.edit2);
        edit3= findViewById(R.id.edit3);

        btnResult.setOnClickListener(new View.OnClickListener() {
            //버튼이 클릭되면 숫자들을 인텐트에 넣어서 서브 액티비티를 호출
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                intent.putExtra("num1",Integer.parseInt(edit1.getText().toString()));
                intent.putExtra("num2",Integer.parseInt(edit2.getText().toString()));

                startActivityForResult(intent,GET_RESULT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == GET_RESULT) {
            if(resultCode == RESULT_OK) {
                edit3.setText(""+data.getIntExtra("result",0));
            } else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "result cancel", Toast.LENGTH_SHORT).show();
            }
        }
    }
}