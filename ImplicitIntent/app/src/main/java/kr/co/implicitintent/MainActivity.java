package kr.co.implicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("암시적 인텐트");
    }

    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.web:
                //액션이 ACTION_VIEW 인 인텐트를 생성함 // https://www.apple.com 를 데이터로 설정함.
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apple.com"));
                break;
            case R.id.call:
                // 암시적 인텐트로 전화걸기
                intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:(+82)10-9244-2499"));
                break;
            case R.id.map:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.502072295376,127.02451465959"));
                break;
            case R.id.contact:
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people"));
                break;
        }

        if(intent != null) {
            startActivity(intent);
        }
    }
}