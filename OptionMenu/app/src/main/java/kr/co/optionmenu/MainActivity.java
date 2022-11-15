package kr.co.optionmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        //메뉴리소스 팽창(infalte) 하면 실제 메뉴가 생성
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }

    //옵션 메뉴 이벤트 클릭 처리
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.blue:
                view.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.green:
                view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.yellow:
                view.setBackgroundColor(Color.YELLOW);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}