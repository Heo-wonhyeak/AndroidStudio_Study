package kr.co.ezenac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 홈화면에 아이콘 넣기
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        // activity_main.xml 파일에서 만든 객체에 지정한 아이디를 찾아옴
        button = findViewById(R.id.android_button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"버튼을 눌렀습니다.",Toast.LENGTH_SHORT).show();
            }
        });




    }
}